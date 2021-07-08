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
    public String loginPageInfo(HttpSession session,
                                @RequestParam(required = false,defaultValue = " ") String username,
                                @RequestParam(required = false,defaultValue = " ") String password) {

        if (username.equals("admin@hotmail.com") && password.equals("123")) {
            session.setAttribute("username", username);
            return "redirect:/user";
        }
        return "login";
    }

    @GetMapping("/logout")
    String logOut(HttpSession session) {
        session.removeAttribute("username");

        return "redirect:/";
    }


=========
    @GetMapping("/register")
    public String registerPage(){
        return "registration";
    }


    @PostMapping("/register")
    public String userInfo(@RequestParam(required = false,defaultValue = "") String email,
                           @RequestParam(required = false,defaultValue = "") String password,
                           @RequestParam(required = false,defaultValue = "") String adress,
                           @RequestParam(required = false,defaultValue = "") String stad,
                           @RequestParam(required = false,defaultValue = "") String kommun,
                           @RequestParam(required = false,defaultValue = "") String postkod){

        return "registration";
    }

    @GetMapping("/")
    public String startPage(){
        return "index";
    }

    @GetMapping("/profile")
    public String profilePage(){
        return "profile";
    }


}
