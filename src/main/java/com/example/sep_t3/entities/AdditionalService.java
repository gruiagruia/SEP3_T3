package com.example.sep_t3.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "additionalServices")
public class AdditionalService implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int additionalServiceId;
    @Column(name="type")
    private String type;
    @Column(name="available")
    private boolean available;
    @Column(name="price")
    private double price;

    @JoinColumn(name = "flight_id", referencedColumnName = "flight_id")
    private int flight_id;

    public AdditionalService(){}

    public AdditionalService(String type, boolean available, double price) {
        this.type = type;
        this.available = available;
        this.price = price;
    }
}
