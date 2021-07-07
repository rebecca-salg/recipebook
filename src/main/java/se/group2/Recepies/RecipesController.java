package se.group2.Recepies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RecipesController {

    @Autowired
    RecipeRepository repository;

    @GetMapping("/recipes")
    String onGet(Model model) {
        // TODO remove generic recipe creations
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setTitle("Spaghetti med paprika och salladsost");
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Salt", "kryddmått", 1.0));
        recipe.setIngredients(ingredients);
        recipe.setDescription("Blanda ihop.");
        recipe.setCategory(Category.CATEGORY_MAIN);
        repository.addRecipe(recipe);

        recipe = new Recipe();
        recipe.setId(2L);
        recipe.setTitle("Påskkyckling med äppelcider");
        ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Peppar", "kryddmått", 2.0));
        recipe.setIngredients(ingredients);
        recipe.setDescription("Dränk kycklingen.");
        recipe.setCategory(Category.CATEGORY_MAIN);
        repository.addRecipe(recipe);

        recipe = new Recipe();
        recipe.setId(3L);
        recipe.setTitle("Rabarberpaj med sås");
        ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Rabarber", "styck", 4.0));
        recipe.setIngredients(ingredients);
        recipe.setDescription("Kör in i ugnen");
        recipe.setCategory(Category.CATEGORY_DESSERT);
        repository.addRecipe(recipe);

        model.addAttribute("recipes", repository.recipes);

        return "recipes";
    }

    @GetMapping("/recipes/{id}")
    String onGetWithID(@PathVariable long id, Model model) {
        return "recipe";
    }
}
