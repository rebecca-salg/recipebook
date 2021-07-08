package se.group2.Recepies;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoggedInStartController {

    @GetMapping("/user/start")
    String start(){
        return "loggedInStart";
    }
}
