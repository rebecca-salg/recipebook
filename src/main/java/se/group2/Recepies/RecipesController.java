package se.group2.Recepies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RecipesController {

    @Autowired
    RecipeRepository repository;
    @Autowired
    RecipeCollectionRepository recipeCollectionRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/recipes")
    String onGet(Model model, HttpSession session, @RequestParam(required = false) Long userId) {
        User user;
        if (userId == null) {
            user = (User) session.getAttribute("user");
        } else {
            user = (User) userRepository.findById(userId).get();
            model.addAttribute("followUser", user);
        }

        List<RecipeCollection> collections = recipeCollectionRepository.findAllByUserId(user.getId());
        List<Recipe> recipes = new ArrayList<>();

        for(RecipeCollection collection : collections){
            recipes.add(collection.getRecipe());
        }
        model.addAttribute("recipes",recipes);

        return "recipes";
    }

    @GetMapping("/recipes/{id}")
    String onGetWithID(@PathVariable long id, Model model) {
        model.addAttribute("recipe", repository.findById(id).orElse(null));

        return "recipe";
    }
}
