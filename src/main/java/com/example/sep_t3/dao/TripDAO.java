package com.example.sep_t3.dao;

import com.example.sep_t3.entities.Trip;
import java.util.List;

public interface TripDAO {
    List<Trip> getTripsByParam(Trip trip);
}
