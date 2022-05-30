package com.example.sep_t3.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "additionalServices")
public class AdditionalService implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int additionalServiceId;
    @Column(name="serviceType")
    private String serviceType;
    @Column(name="available")
    private boolean available;
    @Column(name="price")
    private double price;

    @JoinColumn(name = "flight_id", referencedColumnName = "flight_id")
    private int flight_id;

    public AdditionalService(){}

    public AdditionalService(String serviceType, boolean available, double price) {
        this.serviceType = serviceType;
        this.available = available;
        this.price = price;
    }

    public int getAdditionalServiceId() {
        return additionalServiceId;
    }

    public void setAdditionalServiceId(int additionalServiceId) {
        this.additionalServiceId = additionalServiceId;
    }

    public String getServiceType()
    {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }
}

