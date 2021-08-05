package se.group2.Recepies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FollowersController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FollowerCollectionRepository followerCollectionRepository;

    @GetMapping("/followers")
    String getFollowers(Model model, HttpSession session, @RequestParam(required = false) boolean removed){
        if(removed){
            model.addAttribute("removed", true);
        }
        User user = (User)session.getAttribute("user");
        List<FollowerCollection> followerCollection = followerCollectionRepository.findAllByUserId(user.getId());
        List<User> followers = new ArrayList<>();

        for(FollowerCollection collection : followerCollection){
           followers.add(collection.getFollow());
        }

        model.addAttribute("followers", followers);
        return "followers";
    }

    @GetMapping("/unfollowUser/{id}")
    String removeFollow(Model model, HttpSession session, @PathVariable Long id) {
        User user = (User)session.getAttribute("user");
        List<FollowerCollection> followerCollection = followerCollectionRepository.findAllByUserId(user.getId());
        for(FollowerCollection followers: followerCollection){
            if(followers.getFollow().getId() == id){
                followerCollectionRepository.deleteById(followers.getId());
            }
        }

        return "redirect:/followers?removed=true";
    }

}
