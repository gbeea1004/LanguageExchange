package languageExchange.web.user;

import languageExchange.domain.User;
import languageExchange.security.HttpSessionUtils;
import languageExchange.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static languageExchange.security.HttpSessionUtils.LOGINED_USER;
import static org.slf4j.LoggerFactory.getLogger;

@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger log = getLogger(UserController.class);

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
    public String loginForm() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(String userId, String password, HttpSession httpSession) {
        User user = userService.login(userId, password);
        httpSession.setAttribute(LOGINED_USER, user);
        return "redirect:/";
    }
    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute(LOGINED_USER);
        return "redirect:/";
    }
}
