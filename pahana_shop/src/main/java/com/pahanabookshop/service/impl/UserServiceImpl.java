package com.pahanabookshop.service.impl;

import com.pahanabookshop.dao.UserDao;
import com.pahanabookshop.dao.impl.UserDaoImpl;
import com.pahanabookshop.model.User;
import com.pahanabookshop.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean addUser(User user) {
        // Business logic / validation can be added here
        return userDao.addUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(int id) {
        return userDao.deleteUser(id);
    }
}
