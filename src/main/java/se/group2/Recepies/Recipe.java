package se.group2.Recepies;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToMany(mappedBy = "ownerRecipe", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients = new ArrayList<>();
    private String description;
    private Category category;

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Category getCategory() { return category; }

    public void setCategory(Category category) {
        this.category = category;
    }
}
