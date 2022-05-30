package com.example.sep_t3.dao;

import com.example.sep_t3.entities.User;

import java.sql.*;

public class UserDAOImpl implements UserDAO {

    private static UserDAOImpl instance;

    private UserDAOImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized UserDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }

    private Connection getConnection() throws SQLException {
        //return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        return DriverManager.getConnection("jdbc:postgresql://dumbo.db.elephantsql.com/dlipccbr", "dlipccbr", "dyaVKFWkG-yOT4LR07Eydu6QtTEjcDtu");
    }

    @Override
    public User saveUser(User user) {
        User result = null;
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (first_name, last_name, email, password, role) VALUES (?, ?, ?, ?, ?)",  PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getRole());
            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                result = new User (keys.getInt(1), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getRole());
            } else {
                throw new SQLException("No keys generated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUser(User user) {
        boolean result = false;
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET first_name = ?, last_name = ?, email = ?, password = ? WHERE id = ?");
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setInt(5, Math.toIntExact(user.getId()));
            statement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean result = false;
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User getUserByEmail(String email) {
        User result = null;
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.isBeforeFirst()){
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String firstname = resultSet.getString("firstname");
                    String lastname = resultSet.getString("lastname");
                    String password = resultSet.getString("password");
                    String role = resultSet.getString("role");
                    result = new User(id, firstname, lastname, email, password, role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean findEmail(String email) {
        boolean result = false;
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.isBeforeFirst()){
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
