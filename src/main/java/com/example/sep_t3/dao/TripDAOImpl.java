package com.example.sep_t3.dao;

import com.example.sep_t3.entities.Flight;
import com.example.sep_t3.entities.Seat;
import com.example.sep_t3.entities.Trip;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TripDAOImpl implements TripDAO{

    private static TripDAOImpl instance;

    private TripDAOImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized TripDAOImpl getInstance() throws SQLException {
        if (instance == null) {
            instance = new TripDAOImpl();
        }
        return instance;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
    }

    @Override
    public List<Trip> getTripsByParam(Trip trip) {
        List<Trip> result = null;
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM public.flights INNER JOIN public.seats ON public.flights.flight_id = public.seats.flight_id " +
                            "WHERE origin = ? AND destination = ? AND departure_date LIKE ? AND travel_class = ? AND number_of_bookable_seats > 0");
            statement.setString(1, trip.getOrigin());
            statement.setString(2, trip.getDestination());
            statement.setString(3, trip.getDepartureDate()+"%");
            statement.setString(4, trip.getTravelClass());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.isBeforeFirst()){
                if (resultSet.next()) {

                    //Flight Info
                    int id = resultSet.getInt("flight_id");
                    int aircraftCode = resultSet.getInt("aircraft_code");
                    String airline = resultSet.getString("airline");
                    String arrivalDate = resultSet.getString("arrival_date");
                    String departureDate = resultSet.getString("departure_date");
                    String duration = resultSet.getString("duration");
                    Flight flight = new Flight(id, aircraftCode, airline, trip.getOrigin(), trip.getDestination(), departureDate, arrivalDate, duration);

                    //Seats Info
                    int seat_id = resultSet.getInt("seat_id");
                    int numberOfBookableSeats = resultSet.getInt("number_of_bookable_seats");
                    double pricePerSeat = resultSet.getDouble("price_per_seat");
                    String currency = resultSet.getString("currency");
                    Seat seat = new Seat(seat_id, trip.getTravelClass(), pricePerSeat, currency, numberOfBookableSeats, flight.getFlightId());
                    List<Seat> seats = new ArrayList<>();
                    seats.add(seat);
                    flight.setSeats(seats);
                    List<Flight> flights = new ArrayList<>();
                    flights.add(flight);
                    trip.setFlights(flights);

                    result = new ArrayList<>();
                    result.add(trip);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
