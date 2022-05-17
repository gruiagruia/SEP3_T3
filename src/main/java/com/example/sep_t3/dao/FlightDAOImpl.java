package com.example.sep_t3.dao;

import com.example.sep_t3.entities.Flight;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDAOImpl implements FlightDAO, Serializable
{

    private static FlightDAOImpl instance;

    private FlightDAOImpl() throws SQLException
    {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized FlightDAOImpl getInstance() throws SQLException
    {
        if (instance == null)
        {
            instance = new FlightDAOImpl();
        }
        return instance;
    }

    private Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
    }


    @Override
    public Flight createFlight(Flight flight)
    {
        Flight result = null;
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO flights (flightId, aircraftCode, airline, origin, destination, departureDate, arrivalDate, duration, numberOfBookableSeats, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public boolean deleteFlight(int flightId)
    {
        boolean result = false;
        try(Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM flights WHERE flightId = ?");
            statement.setInt(1, flightId);
            statement.executeQuery();
            result = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<Flight> getAllFlights()
    {
        ArrayList<Flight> result = new ArrayList<>();
        try(Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM flights");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next())
            {
                int flightId = resultSet.getInt("flightId");
                int aircraftCode = resultSet.getInt("aircraftCode");
                String airline = resultSet.getString("airline");
                String origin = resultSet.getString("origin");
                String destination = resultSet.getString("destination");
                String departureDate = resultSet.getString("departureDate");
                String arrivalDate = resultSet.getString("arrivalDate");
                int duration = resultSet.getInt("duration");
                int numberOfBookableSeats = resultSet.getInt("numberOfBookableSeats");
                String status = resultSet.getString("status");
                //Flight flight = new Flight(flightId, aircraftCode, airline, origin, destination, departureDate, arrivalDate, duration, status, new ArrayList<>());
                //result.add(flight);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
