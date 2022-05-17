package com.example.sep_t3.networking;

import com.example.sep_t3.entities.Flight;
import com.example.sep_t3.model.FlightModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class FlightHandler implements Runnable{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Gson gson;
    private FlightModel flightModel;

    public FlightHandler(Socket socket, FlightModel flightModel) throws IOException {
        this.socket = socket;
        this.flightModel = flightModel;
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
            case "create flight":
                createFlight();
                break;
            case "delete flight":
                deleteFlight();
                break;
            case "get all flights":
                getAllFlights();
                break;
        }
    }


    private void createFlight(){
        try {
            String request = in.readLine();
            Flight flight = gson.fromJson(request, Flight.class);
            Flight result = flightModel.createFlight(flight);
            System.out.println(result.toString());
            out.println(gson.toJson(result));
        } catch (Exception e) {
            out.println("Error: Could not create flight");
        }
    }
    private void deleteFlight() {
        try {
            String request = in.readLine();
            int flightId = gson.fromJson(request, Integer.class);
            boolean result = flightModel.deleteFlight(flightId);
            out.println(gson.toJson(result));
        } catch (Exception e) {
            out.println("Error: Could not delete flight");
        }
    }

    private void getAllFlights(){
        try {
            List<Flight> result = flightModel.getAllFlights();
            out.println(gson.toJson(result));
        } catch (Exception e) {
            out.println("Error: No flights found");
        }
    }

}
