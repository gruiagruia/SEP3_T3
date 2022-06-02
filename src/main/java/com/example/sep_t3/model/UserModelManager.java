package com.example.sep_t3.model;

import com.example.sep_t3.dao.UserDAOImpl;
import com.example.sep_t3.entities.User;

import java.sql.SQLException;


public class UserModelManager implements UserModel {
  private UserDAOImpl userDAO;
  {
    try {
      userDAO = UserDAOImpl.getInstance();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  @Override
  public void saveUser(User user) {
     userDAO.saveUser(user);
  }
  @Override
  public void updateUser(User user) {
      userDAO.updateUser(user);
  }
  @Override
  public boolean deleteUser(int id) {
    return userDAO.deleteUser(id);
  }
  @Override
  public User getUserById(int id) {
    return userDAO.getUserById(id);
  }
  @Override
  public boolean findEmail(String email) {
    return userDAO.findEmail(email);
  }
  @Override
  public User getUserByEmail(String email) {
    return userDAO.getUserByEmail(email);
  }
}
