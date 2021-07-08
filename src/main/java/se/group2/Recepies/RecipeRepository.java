package se.group2.Recepies;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepository {
    public List<Recipe> recipes = new ArrayList<>();

    public RecipeRepository() {
        // TODO remove generic recipe creations
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setTitle("Spaghetti med paprika och salladsost");
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Salt", "kryddmått", 1.0));
        ingredients.add(new Ingredient("Peppar", "kryddmått", 1.5));
        ingredients.add(new Ingredient("Fusellini", "gram", 500.0));
        recipe.setIngredients(ingredients);
        recipe.setDescription("Hacka lite. Blanda lite.\n\nKoka upp vattnet och lägg i pastan.");
        recipe.setCategory(Category.CATEGORY_MAIN);
        addRecipe(recipe);

        recipe = new Recipe();
        recipe.setId(2L);
        recipe.setTitle("Påskkyckling med äppelcider");
        ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Peppar", "kryddmått", 2.0));
        recipe.setIngredients(ingredients);
        recipe.setDescription("Dränk kycklingen.");
        recipe.setCategory(Category.CATEGORY_MAIN);
        addRecipe(recipe);

        recipe = new Recipe();
        recipe.setId(3L);
        recipe.setTitle("Rabarberpaj med sås");
        ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Rabarber", "styck", 4.0));
        recipe.setIngredients(ingredients);
        recipe.setDescription("Kör in i ugnen");
        recipe.setCategory(Category.CATEGORY_DESSERT);
        addRecipe(recipe);
    }

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

    Recipe getRecipeById(long id) {
        for (Recipe recipe : recipes) {
            if (recipe.getId() == id) {
                return recipe;
            }
        }

        return null;
    }
}
