package com.example.sep_t3.model;

import com.example.sep_t3.entities.Trip;

import java.util.List;

public class TripModelManager implements TripModel{
    @Override
    public List<Trip> getTripsByParam(Trip trip) {
        System.out.println(trip.toString());
        return null;
    }
}
