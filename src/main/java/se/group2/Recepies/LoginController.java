package se.group2.Recepies;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @PostMapping("/login")
    public String loginPageInfo(@RequestParam(required = false,defaultValue = " ") String username, @RequestParam(required = false,defaultValue = " ") String password){
        if (username.equals("admin@hotmail.com") && password.equals("123")){
            return "";
        }
        return "login";
    }

    @GetMapping("/")
    public String startPage(){
        return "index";
    }

    @PostMapping("/")
    public String startPageInfo(@RequestParam(required = false,defaultValue = " ") String username, @RequestParam(required = false,defaultValue = " ") String password){
        if (username.equals("admin@hotmail.com") && password.equals("123")){
            return "";
        }
        return "redirect:/user";
    }

    @GetMapping("/profile")
    public String profilePage(){
        return "profile";
    }


}
