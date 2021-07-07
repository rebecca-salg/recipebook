package se.group2.Recepies;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepository {
    public List<Recipe> recipes = new ArrayList<>();

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public boolean removeRecipe(long id) {
        for (Recipe r : recipes) {
            if (r.getId() == id) {
                recipes.remove(r);
                return true;
            }
        }

        return false;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
