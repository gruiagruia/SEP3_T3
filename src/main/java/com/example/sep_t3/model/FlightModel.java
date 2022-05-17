package com.example.sep_t3.model;

import com.example.sep_t3.entities.Flight;

import java.util.List;

public interface FlightModel {
    Flight createFlight(Flight flight);
    boolean deleteFlight(int id);
    List<Flight> getAllFlights();
}
