package di;

import java.util.List;

public class Sandwich {
    private Bread bread;
    private List<Ingredient> ingredients;
    private List<Sauce> sauces;

    public Sandwich(Bread bread, List<Ingredient> ingredients, List<Sauce> sauces) {
        this.bread = bread;
        this.ingredients = ingredients;
        this.sauces = sauces;
    }
}
