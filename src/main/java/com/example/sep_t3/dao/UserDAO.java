package com.example.sep_t3.dao;

import com.example.sep_t3.entities.User;

import java.util.Collection;

public interface UserDAO {
    User saveUser(User user);
    User getUserById(int id);
    User getUserByEmail(String email);
    boolean updateUser(User user);
    boolean deleteUser(int id);
    Collection<User> getAllUsers();
    boolean findEmail(String email);
}
