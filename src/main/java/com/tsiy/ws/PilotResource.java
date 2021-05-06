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
import javax.ws.rs.core.MediaType;

import com.tsiy.dao.Booking;
import com.tsiy.dao.DAOFactory;
import com.tsiy.dao.Flight;
import com.tsiy.dao.Pilot;
import com.tsiy.dao.PilotDAO;

@Path("/Pilot")
public class PilotResource implements PilotDAO {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/All")
	public List<Pilot> getAll() {
		return DAOFactory.getPilotDAO().getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPilot/{name}")
	public Pilot getElement(@PathParam("name") String name) {
		return DAOFactory.getPilotDAO().getElement(name);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Request/{pilotid}")
	public List<Flight> getRequests(@PathParam("pilotid") String pilotid) {
		List<Booking> books = DAOFactory.getBookingDAO().getAll();
		List<Flight> flights = new ArrayList<Flight>();
		for (Booking b : books) {
			if (DAOFactory.getFlightDAO().getElement(b.getFlightId()).getPilotid().equals(pilotid)
					&& b.getStatut().equals("En attente")) {
				flights.add(DAOFactory.getFlightDAO().getElement(b.getFlightId()));
			}
		}
		return flights;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/PlannedFlights/{pilotid}")
	public List<Flight> getPlannedFlights(@PathParam("pilotid") String pilotid) {
		List<Flight> books = DAOFactory.getFlightDAO().getAll();
		List<Flight> flights = new ArrayList<Flight>();
		for (Flight b : books) {
			if (b.getPilotid().equals(pilotid)) {
				flights.add(b);
			}
		}
		return flights;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addPilot")
	public void addElement(Pilot p) {
		DAOFactory.getPilotDAO().addElement(p);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete/{name}")
	public void deleteElement(@PathParam("name") String name) {
		DAOFactory.getPilotDAO().deleteElement(name);
	}

}