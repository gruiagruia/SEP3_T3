package com.example.sep_t3.entities;

public class AdditionalServices {
    private String currency;
    private boolean available;
    private String type;
    private double price;

    public AdditionalServices()
    {
    }

    public AdditionalServices(boolean available, String type, double price)
    {
        this.available = available;
        this.type = type;
        this.price = price;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public boolean getAvailable()
    {
        return available;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
