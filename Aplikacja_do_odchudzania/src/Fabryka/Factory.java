package Fabryka;

public class Factory extends FabrykaDAO {
    @Override
    public UserDAO getUserDAO() {
        return new UserDAO();
    }
    @Override
    public UserHistoryDAO getUserHistoryDAO () {
        return new UserHistoryDAO();
    }

    @Override
    public BreakfastDAO getBreakfastDAO() {
        return new BreakfastDAO();
    }

    @Override
    public DinnerDAO getDinnerDAO() {
        return new DinnerDAO();
    }

    @Override
    public SupperDAO getSupperDAO() {
        return new SupperDAO();
    }

    @Override
    public SportDAO getSportDAO() {
        return new SportDAO();
    }
}
