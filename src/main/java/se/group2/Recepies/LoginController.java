package se.group2.Recepies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String startPage(Model model){
        model.addAttribute("login", new Login());
        return "index";
    }

    @PostMapping("/login")
    public String loginPageInfo(HttpSession session, Model model,
                                @Valid @ModelAttribute("login") Login login,
                                BindingResult result) {

        if(result.hasErrors()) {
            return "index";
        }

        User user = userRepository.findByEmail(login.getEmail());

            if (user != null && login.getPassword().equals(user.getPassword())) {
                session.setAttribute("user", user);
                return "redirect:/user";
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
    public String userInfo(@ModelAttribute User user, HttpSession session) {

        userRepository.save(user);
        session.setAttribute("user", user);

        return "redirect:/profile";
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
    public String editUser(Model model, HttpSession session)
    {
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("edit", true);
        return "registrationEdit";
    }

    @PostMapping("/edit")
    public String userData(Model model, @Valid User user, BindingResult result, HttpSession session) {
        User currentUser = (User)session.getAttribute("user");
        if(result.hasErrors()){
            model.addAttribute("edit", true);
            return "registrationEdit";
        }

        user.setId(currentUser.getId());
        userRepository.save(user);

        session.setAttribute("user", user);
        return "redirect:/profile";
    }


}
