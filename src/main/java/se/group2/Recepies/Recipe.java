package se.group2.Recepies;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private long id;
    private String title;
    private List<Ingredient> ingredients = new ArrayList<>();
    private String description;
    private Category category;

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
