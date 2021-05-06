package com.tsiy.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.tsiy.dao.Booking;
import com.tsiy.dao.DAOFactory;
import com.tsiy.dao.Flight;
import com.tsiy.dao.Passenger;
import com.tsiy.dao.PassengerDAO;

@Path("/Passenger")
public class PassengerResource implements PassengerDAO {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/All")
	public List<Passenger> getAll() {
		return DAOFactory.getPassengerDAO().getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getPassenger/{name}")
	public Passenger getElement(@PathParam("name") String nom) {
		return DAOFactory.getPassengerDAO().getElement(nom);
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login")
	public Passenger getPassengerByEmailAndPassword(@QueryParam("email") String email,
			@QueryParam("password") String password) {
		return DAOFactory.getPassengerDAO().getPassengerByEmailAndPassword(email, password);
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/BookedFlights")
	public List<Flight> getBookedFlights(@QueryParam("passengerid") String passengerid) {
		List<Booking> books = DAOFactory.getBookingDAO().getAll();
		List<Flight> flights = new ArrayList<Flight>();
		for (Booking b : books) {
			if (b.getPassengerId().equals(passengerid)) {
				flights.add(DAOFactory.getFlightDAO().getElement(b.getFlightId()));

			}
		}
		return flights;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addPassenger")
	public void addElement(Passenger p) {
		DAOFactory.getPassengerDAO().addElement(p);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete/{name}")
	public void deleteElement(@PathParam("name") String name) {
		DAOFactory.getPassengerDAO().deleteElement(name);
	}

}