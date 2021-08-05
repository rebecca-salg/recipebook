package se.group2.Recepies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoggedInStartController {

    @Autowired
    RecipeRepository repository;

    @Autowired
    RecipeCollectionRepository recipeCollectionRepository;

    @GetMapping("/user")
    String start(HttpSession session, Model model, @RequestParam(required = false) boolean added) {
        List<Recipe> recentRecipes = new ArrayList<>();

        if (added) {
            model.addAttribute("added", added);
        }

        if(session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            List<RecipeCollection> collections = recipeCollectionRepository.findAllByUserId(user.getId());
            List<Recipe> recipes = new ArrayList<>();

            for(RecipeCollection collection : collections){
                recipes.add(collection.getRecipe());
            }

            for(int i = recipes.size() - 1; i >= 0; i--) {
                recentRecipes.add(recipes.get(i));
            }
            model.addAttribute("recipes", recentRecipes);
            return "loggedInStart";
        }
            return "redirect:/";

    }
}
