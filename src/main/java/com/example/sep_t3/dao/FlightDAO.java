package com.example.sep_t3.dao;

import com.example.sep_t3.entities.Flight;

import java.util.List;

public interface FlightDAO {
    Flight createFlight(Flight flight);
    boolean deleteFlight(int flightId);
    List<Flight> getAllFlights();
}
