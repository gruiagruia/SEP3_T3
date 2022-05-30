package com.example.sep_t3.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "seats")
public class Seat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatId;
    @Column(name="travelClass")
    private String travelClass;
    @Column(name="pricePerSeat")
    private double pricePerSeat;
    @Column(name="currency")
    private String currency;
    @Column(name="numberOfBookableSeats")
    private int numberOfBookableSeats;

    @JoinColumn(name = "flight_id", referencedColumnName = "flight_id")
    private int flight_id;

    public Seat(){}

    public Seat(String travelClass, double pricePerSeat, String currency, int numberOfBookableSeats) {
        this.travelClass = travelClass;
        this.pricePerSeat = pricePerSeat;
        this.currency = currency;
        this.numberOfBookableSeats = numberOfBookableSeats;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getTravelClass()
    {
        return travelClass;
    }

    public void setTravelClass(String travelClass)
    {
        this.travelClass = travelClass;
    }

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    public void setPricePerSeat(double pricePerSeat) {
        this.pricePerSeat = pricePerSeat;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getNumberOfBookableSeats() {
        return numberOfBookableSeats;
    }

    public void setNumberOfBookableSeats(int numberOfBookableSeats) {
        this.numberOfBookableSeats = numberOfBookableSeats;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }
}
