package languageExchange.web.user;

import languageExchange.domain.User;
import languageExchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/form")
    public String userForm() {
        return "user/form";
    }

    @PostMapping("")
    public String create(User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("bindingResult 발생");
            return "redirect:/users/form";
        }
        userService.add(user);
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }
}
