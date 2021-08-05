package se.group2.Recepies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    FollowerCollectionRepository followerCollectionRepository;

    @GetMapping("/")
    public String startPage(Model model){
        model.addAttribute("login", new Login());
        return "index";
    }

    @PostMapping("/login")
    public String loginPageInfo(HttpSession session, Model model, @Valid Login login, BindingResult result) {

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

        model.addAttribute("user", new User());
        model.addAttribute("edit", false);
        return "registrationEdit";
    }

    @PostMapping("/register")
    public String userInfo(Model model, @Valid User user, BindingResult result, HttpSession session) {

        if(result.hasErrors()){
            model.addAttribute("edit", false);
            return "registrationEdit";
        }
        userRepository.save(user);
        session.setAttribute("user", user);

        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String profilePage(Model model, HttpSession session, @RequestParam(required = false) Long userId) {
        if (session.getAttribute("user")== null) {
            return "redirect:/";
        }

        if (userId == null) {
            if(session.getAttribute("user")!= null) {
                model.addAttribute("user", session.getAttribute("user"));
            } else {
                model.addAttribute("user", new User());
            }
        } else {
            User user = (User) userRepository.findById(userId).get();
            model.addAttribute("foreignUser", user);
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

    @GetMapping("/followUser/{id}")
    public String followUser(HttpSession session, @PathVariable Long id) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }

        User foreignUser = (User) userRepository.findById(id).get();
        followerCollectionRepository.save(new FollowerCollection(user, foreignUser));

        return "redirect:/user?added=true";
    }
}
