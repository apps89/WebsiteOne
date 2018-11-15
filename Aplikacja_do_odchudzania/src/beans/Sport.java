package beans;

public class Sport {
    private String describe;
    private int calories;
    private int category;

    public Sport(){}

    public Sport(String describe, int calories, int category) {
        this.describe = describe;
        this.calories = calories;
        this.category = category;
    }

    public String getDescribe() {
        return describe;
    }

    public int getCalories() {
        return calories;
    }

    public int getCategory() {
        return category;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setCategory(int category) {
        this.category = category;
    }


}
