package com.example.sep_t3.networking;

import com.example.sep_t3.entities.Flight;
import com.example.sep_t3.model.FlightModel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;

public class FlightHandler implements Runnable
{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Gson gson;
    private FlightModel flightModel;

    public FlightHandler(Socket socket, FlightModel flightModel) throws IOException
    {
        this.socket = socket;
        this.flightModel = flightModel;
        gson = new Gson();
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run()
    {
        try
        {
            while(true)
            {
                String request = in.readLine();
                pointToMethod(request);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void pointToMethod(String req)
    {
        System.out.println("POINT TO METHOD >>>>"+req);
        if (req == null)
        {
            throw  new NullPointerException("Request is null");
        }
        switch (req)
        {
            case "create flight":
                createFlight();
                break;
            case "delete flight":
                deleteFlight();
                break;
            case "get all flights":
                getAllFlights();
                break;
            /*case "get flights by parameter":
                getFlightsByParam;
                break;*/
        }
    }

    private void createFlight()
    {
        try
        {
            String request = in.readLine();
            Flight flight = gson.fromJson(request, Flight.class);
            flightModel.createFlight(flight);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteFlight()
    {
        try
        {
            String request = in.readLine();
            int flightId = gson.fromJson(request, Integer.class);
            boolean result = flightModel.deleteFlight(flightId);
            out.print(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getAllFlights()
    {
        try
        {
            Collection<Flight> allFlights = flightModel.getAllFlights();
            out.print(allFlights);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
