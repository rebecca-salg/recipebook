package se.group2.Recepies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class searchController {

    @Autowired
    RecipeRepository repository;

    @GetMapping("/search")
    String searching(){
        return "search";
    }

    @PostMapping("/search")
    String search(Model model, @RequestParam String title){
        List<Recipe> recipes = new ArrayList<>();
        for(Recipe r : repository.getRecipes()) {
            if(r.getTitle().toLowerCase().contains(title.toLowerCase())) {
                recipes.add(r);
            }
        }
        model.addAttribute("searchResult", recipes);
        model.addAttribute("title", title);
        return "search";
    }

    /*@PostMapping("/searchedRecipe")
    public String set(@ModelAttribute Recipe recipe) {
        return "redirect:/searchedRecipe";
    }*/

}
