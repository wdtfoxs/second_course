package ru.dz.labs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.api.model.User;
import ru.dz.labs.api.repository.UserRepository;

/**
 * Created by Nikita Prozorov on 20.05.2016.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Transactional
    public String autorization(String login, String password) {
        User userByLoginAndPass = userRepository.getUserByLoginAndPass(login, password);
        if (userByLoginAndPass != null) {
            return "{\"success\": \"true\" }";
        } else {
            return "{\"success\": \"false\"}";
        }
    }

    @Transactional
    public String registrationUser(User user){
        User userByLogin = userRepository.getUserByLogin(user.getLogin());
        System.out.println(user.getLogin() + " " + user.getPassword());
        if (userByLogin == null){
            userRepository.addUser(user);
            return "{\"success\": \"true\"}";
        }else {
            return "{\"success\": \"false\"," +
                    "\"message\": \"Account creation failed\"}";
        }
    }
}
