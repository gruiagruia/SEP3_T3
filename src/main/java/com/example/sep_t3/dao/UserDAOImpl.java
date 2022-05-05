package com.example.sep_t3.dao;

import com.example.sep_t3.entities.User;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class UserDAOImpl implements UserDAO, Serializable {

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
        return DriverManager.getConnection("jdbc:postgresql://dumbo.db.elephantsql.com/dlipccbr", "dlipccbr", "dyaVKFWkG-yOT4LR07Eydu6QtTEjcDtu");
    }


    @Override
    public User saveUser(User user) {
        User result = new User();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.users (firstname, lastname, email, password) VALUES (?, ?, ?, ?)",  PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, (user.getPassword()));
            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                result = new User (keys.getInt(1), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), new ArrayList<>());
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
            PreparedStatement statement = connection.prepareStatement("UPDATE public.users SET firstname = ?, lastname = ?, email = ?, password = ? WHERE email = ?");
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getEmail());
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
            PreparedStatement statement = connection.prepareStatement("DELETE FROM public.users WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User getUserById(int id) {
        User result = null;
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.users WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.isBeforeFirst()){
                if (resultSet.next()) {
                    String firstname = resultSet.getString("firstname");
                    String lastname = resultSet.getString("lastname");
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("password");
                    result = new User(id, firstname, lastname, email, password, new ArrayList<>()); //CHANGE ROLES
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    @Override
    public User getUserByEmail(String email) {
        User result = null;
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.users WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.isBeforeFirst()){
                if (resultSet.next()) {
                    String firstname = resultSet.getString("firstname");
                    String lastname = resultSet.getString("lastname");
                    String password = resultSet.getString("password");
                    result = new User(firstname, lastname, email, password, new ArrayList<>()); //CHANGE ROLES
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Collection<User> getAllUsers() {
        ArrayList<User> result = new ArrayList<>();
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.users");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                User user = new User(id, firstname, lastname, email, password, new ArrayList<>());
                result.add(user);
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
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.users WHERE email = ?");
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
