package com.example.sep_t3.core;

import com.example.sep_t3.model.*;

public class ModelFactory {
    private UserModel userModel;
    private FlightModel flightModel;
    private TripModel tripModel;

    public ModelFactory() {

    }

    public UserModel getUserModel()
    {
        if(userModel == null)
        {
            userModel = new UserModelManager();
        }
        return userModel;
    }

    public FlightModel getFlightModel()
    {
        if(flightModel == null)
        {
            flightModel = new FlightModelManager();
        }
        return flightModel;
    }

    public TripModel getTripModel()
    {
        if(tripModel == null)
        {
            tripModel = new TripModelManager();
        }
        return tripModel;
    }
}
