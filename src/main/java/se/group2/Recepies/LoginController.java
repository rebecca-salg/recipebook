package se.group2.Recepies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage(HttpSession session){
        return "loggedInStart";
    }

    @PostMapping("/login")
    public String loginPageInfo(HttpSession session,
                                @RequestParam(required = false,defaultValue = " ") String username,
                                @RequestParam(required = false,defaultValue = " ") String password,
                                Model model) {

        List<User> users = (List) userRepository.findAll();

        for (User user : users ) {
            if (username.equals(user.getEmail()) && password.equals(user.getPassword())) {
                session.setAttribute("user", username);
                return "redirect:/user";
            }
        }

        model.addAttribute("error", true);

        return "index";
    }

    @GetMapping("/logout")
    String logOut(HttpSession session) {
        session.removeAttribute("user");

        return "redirect:/";
    }

    @GetMapping("/register")
    public String registerPage(Model model){

        model.addAttribute("edit", false);
        return "registrationEdit";
    }

    @PostMapping("/register")
    public String userInfo(@ModelAttribute User username, HttpSession session) {

        userRepository.save(username);

        session.setAttribute("user", username);

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
