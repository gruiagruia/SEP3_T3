package com.example.sep_t3.entities;

import java.util.Collection;

public class Flight {
    private int flightId;
    private int aircraftCode;
    private String airline;
    private String origin;
    private String destination;
    private String departureDate;
    private String arrivalDate;
    private int duration;
    private int numberOfBookableSeats;
    private String status;
    private Collection<AdditionalServices> additionalServices;
    private Collection<Price> prices;

    public Flight()
    {
    }

    public Flight(int aircraftCode, String airline, String origin, String destination, String departureDate, String arrivalDate, int duration, int numberOfBookableSeats, String status)
    {
        this.aircraftCode = aircraftCode;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.duration = duration;
        this.numberOfBookableSeats = numberOfBookableSeats;
        this.status = status;
    }

    public Flight(int aircraftCode, String airline, String origin, String destination, String departureDate, String arrivalDate, int duration, int numberOfBookableSeats, String status, Collection<AdditionalServices> additionalServices, Collection<Price> prices)
    {
        this.aircraftCode = aircraftCode;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.duration = duration;
        this.numberOfBookableSeats = numberOfBookableSeats;
        this.status = status;
        this.additionalServices = additionalServices;
        this.prices = prices;
    }

    public Flight(int flightId, int aircraftCode, String airline, String origin, String destination, String departureDate, String arrivalDate, int duration, int numberOfBookableSeats, String status, Collection<AdditionalServices> additionalServices, Collection<Price> prices)
    {
        this.flightId = flightId;
        this.aircraftCode = aircraftCode;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.duration = duration;
        this.numberOfBookableSeats = numberOfBookableSeats;
        this.status = status;
        this.additionalServices = additionalServices;
        this.prices = prices;
    }

    public int getFlightId()
    {
        return flightId;
    }

    public void setFlightId(int flightId)
    {
        this.flightId = flightId;
    }

    public int getAircraftCode()
    {
        return aircraftCode;
    }

    public void setAircraftCode(int aircraftCode)
    {
        this.aircraftCode = aircraftCode;
    }

    public String getAirline()
    {
        return airline;
    }

    public void setAirline(String airline)
    {
        this.airline = airline;
    }

    public String getOrigin()
    {
        return origin;
    }

    public void setOrigin(String origin)
    {
        this.origin = origin;
    }

    public String getDestination()
    {
        return destination;
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public String getDepartureDate()
    {
        return departureDate;
    }

    public void setDepartureDate(String departureDate)
    {
        this.departureDate = departureDate;
    }

    public String getArrivalDate()
    {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate)
    {
        this.arrivalDate = arrivalDate;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public int getNumberOfBookableSeats()
    {
        return numberOfBookableSeats;
    }

    public void setNumberOfBookableSeats(int numberOfBookableSeats)
    {
        this.numberOfBookableSeats = numberOfBookableSeats;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Collection<AdditionalServices> getAdditionalServices()
    {
        return additionalServices;
    }

    public void setAdditionalServices(Collection<AdditionalServices> additionalServices)
    {
        this.additionalServices = additionalServices;
    }

    public Collection<Price> getPrices()
    {
        return prices;
    }

    public void setPrices(Collection<Price> prices)
    {
        this.prices = prices;
    }
}
