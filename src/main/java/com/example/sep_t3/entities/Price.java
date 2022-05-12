package com.example.sep_t3.entities;

public class Price {
    private String currency;
    private double pricePerSeat;
    private String travelClass;

    public Price()
    {
    }

    public Price(String currency, double pricePerSeat, String travelClass)
    {
        this.currency = currency;
        this.pricePerSeat = pricePerSeat;
        this.travelClass = travelClass;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public double getPricePerSeat()
    {
        return pricePerSeat;
    }

    public void setPricePerSeat(double pricePerSeat)
    {
        this.pricePerSeat = pricePerSeat;
    }

    public String getTravelClass()
    {
        return travelClass;
    }

    public void setTravelClass(String travelClass)
    {
        this.travelClass = travelClass;
    }
}
