package se.group2.Recepies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class addRecipeController {

    @Autowired
    RecipeRepository repository;

    @GetMapping("/add")
    String add(){
        return "addRecipeView";
    }

    @PostMapping("/add")
    String addRecipe(Model recipe, @RequestParam String title, @RequestParam String description, @RequestParam Category category){
        Recipe recipe1 = new Recipe();
        recipe1.setTitle(title);
        recipe1.setDescription(description);
        recipe1.setCategory(category);
        recipe1.setId(repository.getRecipes().size()+1);
        recipe.addAttribute("recipes", repository);
        return "addRecipeView";
    }
}
