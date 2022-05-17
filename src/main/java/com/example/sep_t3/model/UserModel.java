package com.example.sep_t3.model;

import com.example.sep_t3.entities.User;

import javax.transaction.Transactional;

@Transactional
public interface UserModel
{
  User saveUser(User user);
  boolean updateUser(User user);
  boolean deleteUser(int id);
  User getUserByEmail(String email);
  boolean findEmail(String email);
}
