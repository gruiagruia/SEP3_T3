package com.example.sep_t3.model;

import com.example.sep_t3.entities.User;

import javax.transaction.Transactional;

@Transactional
public interface UserModel
{
  void saveUser(User user);
  void updateUser(User user);
  boolean deleteUser(int id);
  User getUserByEmail(String email);

  User getUserById(int id);

  boolean findEmail(String email);


}
