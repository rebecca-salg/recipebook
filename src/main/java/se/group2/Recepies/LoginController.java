package se.group2.Recepies;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPageInfo(HttpSession session, @RequestParam String username, @RequestParam String password){
        if (username.equals("admin") && password.equals("123")){
            session.setAttribute("username", username);

            return "redirect:/user";
        }

        return "login";
    }
}
