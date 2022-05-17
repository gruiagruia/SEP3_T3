package com.example.sep_t3;

import com.example.sep_t3.model.FlightModel;
import com.example.sep_t3.model.TripModel;
import com.example.sep_t3.model.UserModel;
import com.example.sep_t3.networking.FlightHandler;
import com.example.sep_t3.networking.TripHandler;
import com.example.sep_t3.networking.UserHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

    private static int USERPORT = 2910;
    private static int FLIGHTPORT = 2911;
    private static int TRIPPORT = 2912;

    private ServerSocket userServerSocket;
    private ServerSocket flightServerSocket;
    private ServerSocket tripServerSocket;

    private UserModel userModel;
    private FlightModel flightModel;
    private TripModel tripModel;

    public Server(UserModel userModel, FlightModel flightModel, TripModel tripModel){
        this.userModel = userModel;
        this.flightModel = flightModel;
        this.tripModel = tripModel;
        try {
            userServerSocket = new ServerSocket(USERPORT);
            flightServerSocket = new ServerSocket(FLIGHTPORT);
            tripServerSocket = new ServerSocket(TRIPPORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                Socket userSocket = userServerSocket.accept();
                Socket flightSocket = flightServerSocket.accept();
                Socket tripSocket = tripServerSocket.accept();
                Thread userTh = new Thread(new UserHandler(userSocket, userModel));
                Thread flightTh = new Thread(new FlightHandler(flightSocket, flightModel));
                Thread tripTh = new Thread(new TripHandler(tripSocket, tripModel));
                userTh.start();
                flightTh.start();
                tripTh.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
