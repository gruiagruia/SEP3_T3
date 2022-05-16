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
        return DriverManager.getConnection("jdbc:postgresql://dumbo.db.elephantsql.com/dlipccbr?currentSchema=\"AirlineBooking\"", "dlipccbr", "dyaVKFWkG-yOT4LR07Eydu6QtTEjcDtu");
    }

    @Override
    public List<Flight> getFlightsByParam(String origin, String destination, String departureDate)
    {
        return null;
    }

    @Override
    public Flight createFlight(Flight flight)
    {
        Flight result = new Flight();
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO flights (flightId, aircraftCode, airline, origin, destination, departureDate, arrivalDate, duration, numberOfBookableSeats, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, flight.getFlightId());
            statement.setInt(2, flight.getAircraftCode());
            statement.setString(3, flight.getAirline());
            statement.setString(4, flight.getOrigin());
            statement.setString(5, flight.getDestination());
            statement.setString(6, flight.getDepartureDate());
            statement.setString(7, flight.getArrivalDate());
            statement.setInt(8, flight.getDuration());
            statement.setInt(9, flight.getNumberOfBookableSeats());
            statement.setString(10, flight.getStatus());
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
                Flight flight = new Flight(flightId, aircraftCode, airline, origin, destination, departureDate, arrivalDate, duration, numberOfBookableSeats, status, new ArrayList<>());
                result.add(flight);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
