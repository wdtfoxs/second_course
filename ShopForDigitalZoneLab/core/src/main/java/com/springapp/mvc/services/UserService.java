package com.springapp.mvc.services;

import com.springapp.mvc.entity.User;
import com.springapp.mvc.repositories.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Mail mail;

    @Transactional
    public void addUser(User user) {
        user.setHashPassword(DigestUtils.md5Hex(user.getHashPassword()));
        user.setRole("ROLE_USER");
        user.setEnabled(false);
        String key = UUID.randomUUID().toString();
        user.setKey(key);
        try {
            mail.sendActivation(user.getName(), key, user.getEmail());
            System.out.println("Отправляю на ящик");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        userRepository.add(user);
    }

    @Transactional
    public boolean exsistEmail(String email){
        if (userRepository.getEmail(email) == null){
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    public User getUserByEmail(String email){
        return userRepository.getEmail(email);
    }
    @Transactional
    public boolean getLogin(String login){
        if (userRepository.getUserByLogin(login) == null){
            return true;
        }else {
            return false;
        }
    }



    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Transactional
    public void updateUser(User user){
        userRepository.update(user);
    }

}
