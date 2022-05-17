package com.example.sep_t3.model;

import com.example.sep_t3.entities.Trip;

import java.util.List;


public interface TripModel {
    List<Trip> getTripsByParam(Trip trip);
}
