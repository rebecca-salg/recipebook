package se.group2.Recepies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoggedInStartController {

    @Autowired
    RecipeRepository repository;

    @GetMapping("/user")
    String start(Model model){
        List<Recipe> recentRecipes = new ArrayList<>();
        for(int i = repository.getRecipes().size()-1; i >= 0; i--){
            recentRecipes.add(repository.getRecipes().get(i));
        }
        model.addAttribute("recipes", recentRecipes);
        return "loggedInStart";
    }
}
