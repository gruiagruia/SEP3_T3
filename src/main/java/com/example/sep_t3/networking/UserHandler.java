package com.example.sep_t3.networking;

import com.example.sep_t3.entities.User;
import com.example.sep_t3.model.UserModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UserHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Gson gson;
    private UserModel authModel;

    public UserHandler(Socket socket, UserModel authModel) throws IOException {
        this.socket = socket;
        this.authModel = authModel;
        gson = new GsonBuilder()
                .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
                .create();
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            while(true) {
                String request = in.readLine();
                pointToMethod(request);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pointToMethod(String req){
        switch(req) {
            case "save user":
                saveUser();
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

    private void saveUser() {
        try {
            String request = in.readLine();
            User user = gson.fromJson(request, User.class);
            User response = authModel.saveUser(user);
            out.println(response);
        } catch (IOException e) {
            out.println("Error: User not saved");
        }
    }

    private void updateUser(){
        try {
            String request = in.readLine();
            User user = gson.fromJson(request, User.class);
            boolean response = authModel.updateUser(user);
            out.println(response);
        } catch (Exception e) {
            out.println(false);
        }
    }

    private void deleteUser() {
        try {
            String request = in.readLine();
            int id = gson.fromJson(request, Integer.class);
            boolean result = authModel.deleteUser(id);
            out.println(result);
        } catch (IOException e) {
            out.println(false);
        }
    }

    private void getUserByEmail() {
        try {
            String request = in.readLine();
            String email = gson.fromJson(request, String.class);
            User result = authModel.getUserByEmail(email);
            out.println(gson.toJson(result));
        } catch (Exception e) {
            out.println();
        }
    }

    private void findEmail() {
        try {
            String request = in.readLine();
            String email = gson.fromJson(request, String.class);
            boolean result = authModel.findEmail(email);
            out.println(result);
        } catch (Exception e) {}
    }

}
