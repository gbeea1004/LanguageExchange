package languageExchange.service;

import languageExchange.domain.User;
import languageExchange.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public User add(User user) {
        return userRepository.save(user);
    }
}
