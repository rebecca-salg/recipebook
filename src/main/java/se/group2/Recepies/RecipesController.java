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
        model.addAttribute("recipes", repository.recipes);

        return "recipes";
    }

    @GetMapping("/recipes/{id}")
    String onGetWithID(@PathVariable long id, Model model) {
        model.addAttribute("recipe", repository.getRecipeById(id));

        return "recipe";
    }
}
