package com.example.sep_t3;

import com.example.sep_t3.model.UserModel;
import com.example.sep_t3.networking.UserHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

    private static int PORT = 2910;
    private ServerSocket welcomeSocket;
    private UserModel userModel;

    public Server(UserModel userModel) throws IOException {
        this.userModel = userModel;
        welcomeSocket = new ServerSocket(PORT);
    }

    @Override
    public void run() {
        while(true){
            try {
                Socket socket = welcomeSocket.accept();
                Thread th1 = new Thread(new UserHandler(socket, userModel));
                th1.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
