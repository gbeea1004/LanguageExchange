package languageExchange.domain.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/form")
    public String userForm() {
        return "user/form";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }
}
