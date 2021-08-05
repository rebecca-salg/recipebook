package se.group2.Recepies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FollowersController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FollowerCollectionRepository followerCollectionRepository;

    @GetMapping("/followers")
    String getFollowers(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        List<FollowerCollection> followerCollection = followerCollectionRepository.findAllByUserId(user.getId());
        List<User> followers = new ArrayList<>();

        for(FollowerCollection collection : followerCollection){
           followers.add(collection.getFollow());
        }

        model.addAttribute("followers", followers);
        return "followers";
    }

}
