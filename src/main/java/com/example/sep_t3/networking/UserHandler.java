package com.example.sep_t3.networking;

import com.example.sep_t3.model.UserModel;
import com.example.sep_t3.entities.User;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Gson gson;
    private UserModel userModel;

    List request = null;

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
                String requestAsJson = in.readLine();
                request = gson.fromJson(requestAsJson,List.class);
                String method =(String) request.get(0);
                pointToMethod(method);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pointToMethod(String req) throws IOException {
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
            case "find email":
                findEmail();
                break;
        }
    }

    private void saveUser() throws IOException {
        User user = gson.fromJson(request.get(1).toString(),User.class);
        userModel.saveUser(user);
        request = null;
    }


    private void updateUser() throws IOException {
        User user = gson.fromJson(request.get(1).toString(),User.class);
        userModel.updateUser(user);
        request = null;
    }

    private void deleteUser() throws IOException {
        String idAsString = gson.fromJson(request.get(1).toString(),String.class);
        int id = Integer.parseInt(idAsString);
        boolean result = userModel.deleteUser(id);
        String response = gson.toJson(result);
        out.println(response);
        request = null;
    }

    private void getUserByEmail() throws IOException {
        String email = gson.fromJson(request.get(1).toString(),String.class);
        User userFound = userModel.getUserByEmail(email);
        String userFoundAsJson = gson.toJson(userFound);
        out.println(userFoundAsJson);
        request = null;
    }

    private void getUserById() throws IOException {
        String idAsString = gson.fromJson(request.get(1).toString(),String.class);
        int id = Integer.parseInt(idAsString);
        User userFound = userModel.getUserById(id);
        String userFoundAsJson = gson.toJson(userFound);
        out.println(userFoundAsJson);
        request = null;
    }



    private void findEmail() throws IOException {
        String email = gson.fromJson(request.get(1).toString(),String.class);
        boolean result = userModel.findEmail(email);
        String resultAsJson = gson.toJson(result);
        out.println(resultAsJson);
        request = null;
    }

}
