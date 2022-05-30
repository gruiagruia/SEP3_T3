package com.example.sep_t3.model;

import com.example.sep_t3.dao.FlightDAOImpl;
import com.example.sep_t3.entities.Flight;

import java.sql.SQLException;
import java.util.List;

public class FlightModelManager implements FlightModel
{
    private FlightDAOImpl flightDAO;
    {
        try
        {
            flightDAO = FlightDAOImpl.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Flight createFlight(Flight flight)
    {
        return flightDAO.createFlight(flight);
    }

    @Override
    public boolean deleteFlight(int flightId)
    {
        return flightDAO.deleteFlight(flightId);
    }

    @Override
    public List<Flight> getAllFlights()
    {
        return flightDAO.getAllFlights();
    }
}
