package com.example.sep_t3.networking;

import com.example.sep_t3.model.UserModel;
import com.example.sep_t3.entities.User;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;

public class UserHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Gson gson;
    private UserModel userModel;

    public UserHandler(Socket socket, UserModel userModel) throws IOException {
        this.socket = socket;
        this.userModel = userModel;
        gson = new Gson();
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String request = in.readLine();
                pointToMethod(request);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pointToMethod(String req){
        System.out.println("POINT TO METHOD >>>>"+req);
        if(req == null)
        {
            throw new NullPointerException("Request is null");
        }
        switch(req) {
            case "save user":
                saveUser();
                break;
            case "get user by id":
                getUserById();
                break;
            case "get user by email":
                getUserByEmail();
                break;
            case "update user":
                updateUser();
                break;
            case "delete user":
                deleteUser();
                break;
            case "get all users":
                getAllUsers();
                break;
            case "find email":
                findEmail();
                break;
        }
    }

    private void getUserByEmail() {
        try {
            String request = in.readLine();
            String email = gson.fromJson(request, String.class);
            User result = userModel.getUserByEmail(email);
            out.println(result);
        } catch (Exception e) {
            out.println("Error: Could not find user by given email");
        }
    }


    private void saveUser() {
        System.out.println("HI");
        try {
            String request = in.readLine();
            User user = gson.fromJson(request, User.class);
            userModel.saveUser(user);

        } catch (IOException e) {
            System.out.println("Error");
            out.println("false");

        }
    }


    private void updateUser(){
        try {
            String request = in.readLine();
            User user = gson.fromJson(request, User.class);
            boolean response = userModel.updateUser(user);
            out.println(response);
        } catch (Exception e) {
            out.println("Error: User not updated");
        }
    }

    private void deleteUser() {
        try {
            String request = in.readLine();
            int id = gson.fromJson(request, Integer.class);
            boolean result = userModel.deleteUser(id);
            out.println(result);
        } catch (IOException e) {
            out.println("Error: User not deleted");
        }
    }

    private void getUserById() {
        try {
            String request = in.readLine();
            int id = gson.fromJson(request, Integer.class);
            User result = userModel.getUserById(id);
            out.println(result);
        } catch (Exception e) {
            out.println("Error: Could not find user");
        }
    }

    private void getAllUsers(){
        try {
            Collection<User> allUsers = userModel.getAllUsers();
            out.println(allUsers);
        } catch (Exception e) {
            out.println("Error: Could not find user");
        }
    }

    private void findEmail() {
        System.out.println("find email");
        try {
            String request = in.readLine();
            String email = gson.fromJson(request, String.class);
            boolean result = userModel.findEmail(email);
            out.println(result);
        } catch (Exception e) {
            out.println("Error: Could not find user");
        }
    }

}
