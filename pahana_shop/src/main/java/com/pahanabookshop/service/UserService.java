package com.pahanabookshop.service;

import com.pahanabookshop.model.User;
import java.util.List;

public interface UserService {
    boolean addUser(User user);
    User getUserById(int id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    boolean updateUser(User user);
    boolean deleteUser(int id);
}
