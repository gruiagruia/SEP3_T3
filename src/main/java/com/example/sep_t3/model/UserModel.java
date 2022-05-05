package com.example.sep_t3.model;

import com.example.sep_t3.entities.User;

import java.util.Collection;

public interface UserModel
{
  User saveUser(User user);
  boolean updateUser(User user);
  boolean deleteUser(int id);
  User getUserById(int id);
  User getUserByEmail(String email);
  Collection<User> getAllUsers();
  boolean findEmail(String email);
}
