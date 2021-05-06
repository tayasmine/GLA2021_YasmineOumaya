package com.tsiy.ws;

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
import com.tsiy.dao.BookingDAO;
import com.tsiy.dao.DAOFactory;

@Path("/Booking")
public class BookingResource implements BookingDAO {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/All")
	public List<Booking> getAll() {
		return DAOFactory.getBookingDAO().getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBooking/{name}")
	public Booking getElement(@PathParam("name") String tailNum) {
		return DAOFactory.getBookingDAO().getElement(tailNum);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addBooking")
	public void addElement(Booking a) {
		DAOFactory.getBookingDAO().addElement(a);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete/{id}")
	public void deleteElement(@PathParam("id") String id) {
		DAOFactory.getBookingDAO().deleteElement(id);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cancel/{id}")
	public void cancel(@PathParam("id") String id) {
		DAOFactory.getBookingDAO().cancel(DAOFactory.getBookingDAO().getElement(id).getFlightId());
		DAOFactory.getBookingDAO().deleteElement(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Pilot/validate/{id}")
	public void Validate(@PathParam("id") String id, @QueryParam("pilotid") String pilotid) {
		Booking b = DAOFactory.getBookingDAO().getElement(id);
		if (DAOFactory.getFlightDAO().getElement(b.getFlightId()).getPilotid().equals(pilotid)) {
			DAOFactory.getBookingDAO().Validate(id, pilotid);
		}

	}

}
