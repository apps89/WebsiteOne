package beans;

public class Dinner {
    private int id;
    private String firstDish;
    private String secondDish;
    private String descriptions;
    private int cost;
    private String ingredients;
    private int calory;
    private int category;

    public Dinner() {
    }

    public Dinner(int id, String firstDish, String secondDish, String descriptions, int cost, String ingredients, int calory, int category) {
        this.id = id;
        this.firstDish = firstDish;
        this.secondDish = secondDish;
        this.descriptions = descriptions;
        this.cost = cost;
        this.ingredients = ingredients;
        this.calory = calory;
        this.category = category;
    }

    public int getId() {
        return id;
    }



    public String getDescriptions() {
        return descriptions;
    }

    public int getCost() {
        return cost;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getCalory() {
        return calory;
    }

    public int getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setCalory(int calory) {
        this.calory = calory;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getFirstDish() {
        return firstDish;
    }

    public String getSecondDish() {
        return secondDish;
    }

    public void setFirstDish(String firstDish) {
        this.firstDish = firstDish;
    }

    public void setSecondDish(String secondDish) {
        this.secondDish = secondDish;
    }
}
