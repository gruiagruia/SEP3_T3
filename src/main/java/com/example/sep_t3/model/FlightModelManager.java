package com.example.sep_t3.model;

import com.example.sep_t3.dao.FlightDAOImpl;
import com.example.sep_t3.dao.UserDAOImpl;
import com.example.sep_t3.entities.Flight;
import com.example.sep_t3.entities.Trip;

import java.sql.SQLException;
import java.util.List;

public class FlightModelManager implements FlightModel {

    private FlightDAOImpl flightDAO;
    {
        try {
            flightDAO = FlightDAOImpl.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Flight createFlight(Flight flight) {
        return flightDAO.createFlight(flight);
    }

    @Override
    public boolean deleteFlight(int id) {
        return flightDAO.deleteFlight(id);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightDAO.getAllFlights();
    }
}
