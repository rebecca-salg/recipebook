package se.group2.Recepies;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/register")
    public String registerPage(Model model){

        model.addAttribute("edit", false);
        return "registrationEdit";
    }


    @PostMapping("/register")
    public String userInfo(HttpSession session,
                           Model model,
                           @RequestParam(required = false,defaultValue = "") String email,
                           @RequestParam(required = false,defaultValue = "") String password,
                           @RequestParam(required = false,defaultValue = "") String city,
                           @RequestParam(required = false,defaultValue = "") String county,
                           @RequestParam(required = false,defaultValue = "") String zipCode,
                           @RequestParam(required = false,defaultValue = "") String age,
                           @RequestParam(required = false,defaultValue = "") String fname,
                           @RequestParam(required = false,defaultValue = "") String lname,
                           @RequestParam(required = false,defaultValue = "") String description
                           ){

        User u = new User();
        u.setFirstName(fname);
        u.setSurName(lname);
        u.setCity(city);
        u.setCounty(county);
        u.setZipCode(zipCode);
        u.setAge(age);
        u.setDescription(description);
        u.setEmail(email);

        session.setAttribute("user", u);
        model.addAttribute("user", session.getAttribute("user"));

        return "redirect:/profile";
    }

    @GetMapping("/")
    public String startPage(){
        return "index";
    }

    @GetMapping("/profile")
    public String profilePage(Model model, HttpSession session){
    if(session.getAttribute("user")!= null) {
        model.addAttribute("user", session.getAttribute("user"));
    } else {
        model.addAttribute("user", new User());
    }
        return "profile";
    }

    @GetMapping("/edit")
    public String editUser(Model model)
    {
        model.addAttribute("edit", true);
        return "registrationEdit";
    }

    @PostMapping("/edit")
    public String userData(HttpSession session,
                           @RequestParam(required = false) String email,
                           @RequestParam(required = false) String city,
                           @RequestParam(required = false) String county,
                           @RequestParam(required = false) String zipCode,
                           @RequestParam(required = false) String age,
                           @RequestParam(required = false) String fname,
                           @RequestParam(required = false) String lname,
                          @RequestParam(required = false) String description
    ){
        User u;
        if(session.getAttribute("user") == null) {
            u = new User();
        } else {
            u = (User)session.getAttribute("user");
        }
        if(fname != "") {
            u.setFirstName(fname);
        }
        if(lname != "") {
            u.setSurName(lname);
        }
        if(city != "") {
            u.setCity(city);
        }
        if(county != "") {
            u.setCounty(county);
        }
        if(zipCode != "") {
            u.setZipCode(zipCode);
        }
        if(age != "") {
            u.setAge(age);
        }
        if(description != "") {
            u.setDescription(description);
        }
        if(email != "") {
            u.setEmail(email);
        }

        session.setAttribute("user", u);

        return "redirect:/profile";
    }


}
