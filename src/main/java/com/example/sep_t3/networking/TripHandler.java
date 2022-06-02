package com.example.sep_t3.networking;

import com.example.sep_t3.entities.Trip;
import com.example.sep_t3.model.TripModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class TripHandler implements Runnable{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Gson gson;
    private TripModel tripModel;

    public TripHandler(Socket socket, TripModel tripModel) throws IOException {
        this.socket = socket;
        this.tripModel = tripModel;
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
        if ("get trips by param".equals(req)) {
            getTripsByParam();
        }
    }

    private void getTripsByParam() {
        try {
            String request = in.readLine();
            Trip trip = gson.fromJson(request, Trip.class);
            List<Trip> result = tripModel.getTripsByParam(trip);
            out.println(gson.toJson(result));
        } catch (Exception e) {
            out.println("Error: Could not find user");
        }
    }
}
