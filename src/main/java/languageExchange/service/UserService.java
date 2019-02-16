package languageExchange.service;

import languageExchange.UnAuthenticationException;
import languageExchange.domain.User;
import languageExchange.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public User add(User user) {
        return userRepository.save(user);
    }

    public User login(String userId, String password) {
        Optional<User> maybeUser = userRepository.findByUserId(userId);
        if (!maybeUser.isPresent()) {
            throw new UnAuthenticationException();
        }
        User user = maybeUser.get();
        if (!user.checkPassword(password)) {
            throw new UnAuthenticationException();
        }
        return user;
    }
}
