package com.example.sep_t3.entities;

import java.util.List;

public class Trip {
    private boolean oneWay;
    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private int passengers;
    private String travelClass;
    private double grandTotal;
    private String currency;
    private List<Flight> flights;

    public Trip(){

    }

    public Trip(boolean oneWay, String origin, String destination, String departureDate, String returnDate, int passengers, String travelClass, double grandTotal, String currency) {
        this.oneWay = oneWay;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.passengers = passengers;
        this.travelClass = travelClass;
        this.grandTotal = grandTotal;
        this.currency = currency;
    }

    public Trip(boolean oneWay, String origin, String destination, String departureDate, String returnDate, int passengers, String travelClass, double grandTotal, String currency, List<Flight> flights) {
        this.oneWay = oneWay;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.passengers = passengers;
        this.travelClass = travelClass;
        this.grandTotal = grandTotal;
        this.currency = currency;
        this.flights = flights;
    }

    public boolean isOneWay() {
        return oneWay;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public void setOneWay(boolean oneWay) {
        this.oneWay = oneWay;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "oneWay=" + oneWay +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", passengers=" + passengers +
                ", travelClass='" + travelClass + '\'' +
                ", grandTotal=" + grandTotal +
                ", currency='" + currency + '\'' +
                ", flights=" + flights +
                '}';
    }
}
