package change.responsibility;

public class SelectCategory {
    Category firstCategory = new FirstCategory();
    Category secondCategory = new SecondCategory();
    Category thirdCategory = new ThirdCategory();


    public int chosse (String sex, String height, String weight) {
        firstCategory.setNext(secondCategory);
        secondCategory.setNext(thirdCategory);
        thirdCategory.setNext(null);
        return  firstCategory.choose(sex, height, weight);




    }
}
