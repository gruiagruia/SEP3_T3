package com.example.sep_t3.dao;

import com.example.sep_t3.entities.User;

public interface UserDAO {
    void saveUser(User user);
    User getUserByEmail(String email);
    void updateUser(User user);
    boolean deleteUser(int id);
    boolean findEmail(String email);

    User getUserById(int id);
}
