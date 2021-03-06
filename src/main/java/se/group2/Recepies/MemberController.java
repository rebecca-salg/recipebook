package se.group2.Recepies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MemberController {

    @Autowired
    UserRepository repository;


    @GetMapping("/members")
    String members(Model model, HttpSession session,Long userId) {
        User user;
        if (userId == null) {
            user = (User) session.getAttribute("user");
        } else {
            user = (User) repository.findById(userId).get();
            model.addAttribute("followUser", user);
        }


        List<User> users = new ArrayList<>();
        users = (List) repository.findAll();

        model.addAttribute("users",users);

        return "members";
    }
}
