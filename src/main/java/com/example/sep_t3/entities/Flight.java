package com.example.sep_t3.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "flights")
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightId;
    @Column(name="aircraftCode")
    private int aircraftCode;
    @Column(name="airline")
    private String airline;
    @Column(name="origin")
    private String origin;
    @Column(name="destination")
    private String destination;
    @Column(name="departure_date")
    private String departureDate;
    @Column(name="arrival_date")
    private String arrivalDate;
    @Column(name="duration")
    private String duration;
    @Column(name="status")
    private String status;

    @OneToMany
    private ArrayList<AdditionalService> additionalServices;

    @OneToMany
    private ArrayList<Seat> seats;

    public Flight(){}

    public Flight(int aircraftCode, String airline, String origin, String destination, String departureDate, String arrivalDate, String duration, String status) {
        this.aircraftCode = aircraftCode;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.duration = duration;
        this.status = status;
    }

    public Flight(int flightId, int aircraftCode, String airline, String origin, String destination, String departureDate, String arrivalDate, String duration) {
        this.flightId = flightId;
        this.aircraftCode = aircraftCode;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.duration = duration;
    }

    public Flight(int flightId, int aircraftCode, String airline, String origin, String destination, String departureDate, String arrivalDate, String duration, String status, ArrayList<AdditionalService> additionalServices, ArrayList<Seat> seats) {
        this.flightId = flightId;
        this.aircraftCode = aircraftCode;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.duration = duration;
        this.status = status;
        this.additionalServices = additionalServices;
        this.seats = seats;
    }

    public int getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(int aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
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

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public List<AdditionalService> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(ArrayList<AdditionalService> additionalServices) {
        this.additionalServices = additionalServices;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "aircraftCode=" + aircraftCode +
                ", airline='" + airline + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", duration=" + duration +
                ", status='" + status + '\'' +
                '}';
    }
}
