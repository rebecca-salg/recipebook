package se.group2.Recepies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AddRecipeController {

    @Autowired
    RecipeRepository repository;

    @Autowired
    RecipeCollectionRepository collectionRepository;

    @GetMapping("/add")
    String add(){
        return "addRecipeView";
    }

    @PostMapping("/add")
    String addRecipe(HttpSession httpSession, Model recipe, @RequestParam String title, @RequestParam String description, @RequestParam Category category,
                     @RequestParam("names") List<String> names, @RequestParam("units") String[] units, @RequestParam(value = "amount", defaultValue="0") int[] amount) {
        Recipe recipe1 = new Recipe();
        recipe1.setTitle(title);
        recipe1.setDescription(description);
        recipe1.setCategory(category);
        repository.save(recipe1);

        List<Ingredient> ingredientList = recipe1.getIngredients();

        for(int i=0; i<names.size(); i++){
            ingredientList.add(new Ingredient(names.get(i), units[i], amount[i], recipe1));
        }

        repository.save(recipe1);
        recipe.addAttribute("recipes", repository);

        User user = (User) httpSession.getAttribute("user");
        collectionRepository.save(new RecipeCollection(user, recipe1));

        return "addRecipeView";
    }
}
