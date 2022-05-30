package com.example.sep_t3.entities;

import java.util.Collection;
import java.util.Date;

public class Trip
{
    private boolean oneWay;
    private Date returnDate;
    private int passengers;
    private String travelClass;
    private double grandTotal;
    private String currency;
    private Collection<Flight> flights;

    public Trip(boolean oneWay, Date returnDate, int passengers, String travelClass, double grandTotal, String currency, Collection<Flight> flights)
    {
        this.oneWay = oneWay;
        this.returnDate = returnDate;
        this.passengers = passengers;
        this.travelClass = travelClass;
        this.grandTotal = grandTotal;
        this.currency = currency;
        this.flights = flights;
    }

    public int getPassengers()
    {
        return passengers;
    }

    public void setPassengers(int passengers)
    {
        this.passengers = passengers;
    }

    public Collection<Flight> getFlights()
    {
        return flights;
    }

    public void setFlights(Collection<Flight> flights)
    {
        this.flights = flights;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public double getGrandTotal()
    {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal)
    {
        this.grandTotal = grandTotal;
    }

    public boolean isOneWay()
    {
        return oneWay;
    }

    public void setOneWay(boolean oneWay)
    {
        this.oneWay = oneWay;
    }

    public String getTravelClass()
    {
        return travelClass;
    }

    public void setTravelClass(String travelClass)
    {
        this.travelClass = travelClass;
    }

    public Date getReturnDate()
    {
        return returnDate;
    }

    public void setReturnDate(Date returnDate)
    {
        this.returnDate = returnDate;
    }
}
