package com.tsiy.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.tsiy.dao.Booking;
import com.tsiy.dao.DAOFactory;
import com.tsiy.dao.Flight;
import com.tsiy.dao.FlightDAO;
import com.tsiy.dao.Passenger;

@Path("/Flight")
public class FlightResource implements FlightDAO {
	// Pour toute la liste des vols
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/All")
	public List<Flight> getAll() {
		return DAOFactory.getFlightDAO().getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Available")
	public List<Flight> getAvailableFlights() {
		List<Flight> all = DAOFactory.getFlightDAO().getAll();
		for (Flight f : all) {
			if (f.getAvailableseats() == 0) {
				all.remove(f);
			}
		}
		return all;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("FlightbyId/{name}")
	public Flight getElement(@PathParam("name") String id) {
		return DAOFactory.getFlightDAO().getElement(id);
	}

	// Ajouter un Flight
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addFlight")
	public void addElement(Flight f) {
		DAOFactory.getFlightDAO().addElement(f);
	}

	// Delete un Flight
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete/{name}")
	public void deleteElement(@PathParam("name") String name) {
		DAOFactory.getFlightDAO().deleteElement(name);
	}

	// Search flights from departure to arrival on date date
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/FlightsFromTo")
	public List<Flight> SearchFlight(@QueryParam("departure") String departure,
			@QueryParam("direction") String direction, @QueryParam("date") String date) {
		List<Flight> all = this.getAvailableFlights();
		List<Flight> a = new ArrayList<Flight>();
		for (Flight f : all) {
			if (f.getdeparture().equals(departure) && f.getDirection().equals(direction) && f.getDate().equals(date)) {
				a.add(f);
			}
		}
		return a;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Flight/Passenger/{name}")
	public List<Passenger> getPassengersList(@PathParam("name") String name) {
		List<Booking> books = DAOFactory.getBookingDAO().getAll();
		List<Passenger> pass = new ArrayList<Passenger>();
		for (Booking b : books) {
			if (b.getFlightId().equals(name)) {
				pass.add(DAOFactory.getPassengerDAO().getElement(b.getPassengerId()));

			}
		}

		return pass;

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/bookFlight")
	public void addeditedElement(@QueryParam("flightid") String flightid, @QueryParam("passengerid") String passengerid,
			@QueryParam("numberofseats") int seats) {
		DAOFactory.getFlightDAO().addeditedElement(flightid, passengerid, seats);
		Booking b = new Booking(flightid, passengerid, "En attente");
		DAOFactory.getBookingDAO().addElement(b);
	}

}
