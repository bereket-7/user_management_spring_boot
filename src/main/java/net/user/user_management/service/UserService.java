package net.user.user_management.service;

//import org.springframework.stereotype.Service;

import net.user.user_management.model.User;

public interface UserService {
    public User createUser(User user);

    public boolean checkEmail(String email);

}
