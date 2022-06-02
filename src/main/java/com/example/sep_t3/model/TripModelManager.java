package com.example.sep_t3.model;

import com.example.sep_t3.dao.TripDAOImpl;
import com.example.sep_t3.dao.UserDAOImpl;
import com.example.sep_t3.entities.Trip;

import java.sql.SQLException;
import java.util.List;

public class TripModelManager implements TripModel{

    private TripDAOImpl tripDAO;{
        try {
            tripDAO = TripDAOImpl.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Trip> getTripsByParam(Trip trip) {
        return tripDAO.getTripsByParam(trip);
    }
}
