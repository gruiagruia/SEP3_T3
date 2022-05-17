package com.example.sep_t3.dao;

import com.example.sep_t3.entities.User;

public interface UserDAO {
    User saveUser(User user);
    User getUserByEmail(String email);
    boolean updateUser(User user);
    boolean deleteUser(int id);
    boolean findEmail(String email);
}
