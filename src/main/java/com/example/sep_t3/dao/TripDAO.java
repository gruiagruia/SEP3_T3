package com.example.sep_t3.dao;

import com.example.sep_t3.entities.Trip;

import java.util.Collection;
import java.util.List;

public interface TripDAO {
    List<Trip> getTripsByParam(Trip trip);
    Collection<Trip> getTripByParam(String origin, String destination, String departureDate, boolean oneWay, String travelClass, int passengers, String returnDate);
}
