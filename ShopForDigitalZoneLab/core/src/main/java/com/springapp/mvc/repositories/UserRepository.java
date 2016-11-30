package com.springapp.mvc.repositories;
import com.springapp.mvc.entity.User;


public interface UserRepository{

    void add(User user);

    void update(User user);

    User getEmail(String email);

    User getUserByLogin(String login);

}
