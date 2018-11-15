package Fabryka;

public abstract class FabrykaDAO {
    public static final int anInt = 1;


    public abstract UserDAO getUserDAO();
    public abstract UserHistoryDAO getUserHistoryDAO();
    public abstract BreakfastDAO getBreakfastDAO();
    public abstract DinnerDAO getDinnerDAO();
    public abstract SupperDAO getSupperDAO();
    public abstract SportDAO getSportDAO();

    private static FabrykaDAO instance;

    public static FabrykaDAO getFaktoryDAO(int factoryType) {
        if(instance == null) {
            if(factoryType == anInt) {
                instance = new Factory();
            }

        }
        return instance;
    }

}

