package beans;

public class Breakfast {
    private int id;
    private String name;
    private String descriptions;
    private int cost;
    private String ingredients;
    private int calory;
    private int category;

    public Breakfast() {
    }

    public Breakfast(int id, String name, String descriptions, int cost, String ingredients, int calory, int category) {
        this.id = id;
        this.name = name;
        this.descriptions = descriptions;
        this.cost = cost;
        this.ingredients = ingredients;
        this.calory = calory;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
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
}
