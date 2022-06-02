package com.example.sep_t3.dao;

import com.example.sep_t3.entities.AdditionalService;
import com.example.sep_t3.entities.Flight;
import com.example.sep_t3.entities.Seat;

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
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "0420");
    }

    @Override
    public Flight createFlight(Flight flight)
    {
        Flight result = null;
        int flightId = 0;
        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO flights (aircraftCode, airline, origin, destination, departure_date, arrival_date, duration, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, flight.getAircraftCode());
            statement.setString(2, flight.getAirline());
            statement.setString(3, flight.getOrigin());
            statement.setString(4, flight.getDestination());
            statement.setString(5, flight.getDepartureDate());
            statement.setString(6, flight.getArrivalDate());
            statement.setString(7, flight.getDuration());
            statement.setString(8, flight.getStatus());
            statement.executeQuery();

            ResultSet key = statement.getGeneratedKeys();
            if (key.next())
            {
                flightId = key.getInt(1);
            }

            for (int i = 0; i<flight.getSeats().size(); i++)
            {
                PreparedStatement statement1 = connection.prepareStatement("INSERT INTO seats (travelClass, pricePerSeat, currency, numberOfBookableSeats, flight_id) VALUES (?, ?, ?, ?, ?)");
//                statement1.setString(1, flight.getSeats().get(i).getTravelClass());
//                statement1.setDouble(2, flight.getSeats().get(i).getPricePerSeat());
//                statement1.setString(3, flight.getSeats().get(i).getCurrency());
//                statement1.setInt(4, flight.getSeats().get(i).getNumberOfBookableSeats());
                statement1.setInt(5, flightId);
                statement1.executeQuery();
            }

            for (int i = 0; i<flight.getAdditionalServices().size(); i++)
            {
                PreparedStatement statement2 = connection.prepareStatement("INSERT INTO additionalServices (serviceType, available, price, flight_id) VALUES (?, ?, ?, ?)");
                statement2.setString(1, flight.getAdditionalServices().get(i).getServiceType());
                statement2.setBoolean(2, flight.getAdditionalServices().get(i).isAvailable());
                statement2.setDouble(3, flight.getAdditionalServices().get(i).getPrice());
                statement2.setInt(4, flightId);
                statement2.executeQuery();
            }

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

            PreparedStatement statement1 = connection.prepareStatement("DELETE FROM seats WHERE flight_id = ?");
            statement1.setInt(1, flightId);
            statement1.executeQuery();

            PreparedStatement statement2 = connection.prepareStatement("DELETE FROM additionalServices WHERE flight_id = ?");
            statement1.setInt(1, flightId);
            statement1.executeQuery();

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
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM flights JOIN seats s ON s.flight_id = flights.seats JOIN additionalServices a ON a.flight_id = flights.additionalServices");
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
                String duration = resultSet.getString("duration");
                String status = resultSet.getString("status");
                ArrayList<AdditionalService> additionalServices = (ArrayList<AdditionalService>) resultSet.getArray("flight_id");
                ArrayList<Seat> seats = (ArrayList<Seat>) resultSet.getArray("flight_id");
                Flight flight = new Flight(flightId, aircraftCode, airline, origin, destination, departureDate, arrivalDate, duration, status, additionalServices, seats);
                result.add(flight);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
