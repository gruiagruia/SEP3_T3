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

    public Seat(int seatId, String travelClass, double pricePerSeat, String currency, int numberOfBookableSeats, int flight_id) {
        this.seatId = seatId;
        this.travelClass = travelClass;
        this.pricePerSeat = pricePerSeat;
        this.currency = currency;
        this.numberOfBookableSeats = numberOfBookableSeats;
        this.flight_id = flight_id;
    }
}
