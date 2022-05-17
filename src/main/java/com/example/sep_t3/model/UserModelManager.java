package com.example.sep_t3.model;

import com.example.sep_t3.dao.UserDAOImpl;
import com.example.sep_t3.entities.User;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Transactional
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
  public User saveUser(User user) {
    return userDAO.saveUser(user);
  }


  @Override
  public boolean updateUser(User user) {
    return userDAO.updateUser(user);
  }

  @Override
  public boolean deleteUser(int id) {
    return userDAO.deleteUser(id);
  }

  @Override
  public User getUserByEmail(String email) {
    return userDAO.getUserByEmail(email);
  }


  @Override
  public boolean findEmail(String email) {
    return userDAO.findEmail(email);
  }
}
