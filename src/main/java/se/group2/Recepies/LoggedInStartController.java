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

    @GetMapping("/user")
    String start(HttpSession session, Model model){
        List<Recipe> recentRecipes = new ArrayList<>();
        if(session.getAttribute("username") != null){
            for(int i = repository.getRecipes().size()-1; i >= 0; i--){
                recentRecipes.add(repository.getRecipes().get(i));
            }
            model.addAttribute("recipes", recentRecipes);
            return "loggedInStart";
        }
            return "redirect:/login";

    }
}
