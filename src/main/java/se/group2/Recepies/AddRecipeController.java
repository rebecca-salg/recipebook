package se.group2.Recepies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AddRecipeController {

    @Autowired
    RecipeRepository repository;

    @GetMapping("/add")
    String add(){
        return "addRecipeView";
    }

    @PostMapping("/add")
    String addRecipe(Model recipe, @RequestParam String title, @RequestParam String description, @RequestParam Category category,
                     @RequestParam("names") List<String> names, @RequestParam("units") String[] units, @RequestParam(value = "amount", defaultValue="0") int[] amount){
                Recipe recipe1 = new Recipe();
        List<Ingredient> ingredientList = new ArrayList<>();

        for(int i=0; i<names.size(); i++){
            ingredientList.add(new Ingredient(names.get(i), units[i], amount[i]));
        }

        recipe1.setIngredients(ingredientList);
        recipe1.setTitle(title);
        recipe1.setDescription(description);
        recipe1.setCategory(category);
        repository.addRecipe(recipe1);
        recipe1.setId(repository.getRecipes().size()+1);
        recipe.addAttribute("recipes", repository);
        return "addRecipeView";
    }
}
