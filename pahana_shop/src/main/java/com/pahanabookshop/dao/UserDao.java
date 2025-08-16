package com.pahanabookshop.dao;

import com.pahanabookshop.model.User;
import java.util.List;

public interface UserDao {
    boolean addUser(User user);
    User getUserById(int id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    boolean updateUser(User user);
    boolean deleteUser(int id);
}
