package com.tsiy.jetty_jersey;

import java.util.ArrayList;
import java.util.List;

import com.tsiy.dao.Aircraft;
import com.tsiy.dao.DAOFactory;
import com.tsiy.dao.Flight;
import com.tsiy.dao.Passenger;
import com.tsiy.dao.Pilot;

public class DataGenerator {

	public static void init() {
		List<String> flights = new ArrayList<String>();
		List<Aircraft> aircrafts = new ArrayList<Aircraft>();
		List<Pilot> pilots = new ArrayList<Pilot>();

		Aircraft a1 = new Aircraft("TSIY01", "Airbus", 6);
		Aircraft a2 = new Aircraft("TSIY02", "Piper", 8);
		Aircraft a3 = new Aircraft("TSIY03", "Cessna", 4);
		Aircraft a4 = new Aircraft("TSIY04", "Cirrus", 4);

		DAOFactory.getAircraftDAO().addElement(a1);
		aircrafts.add(a1);
		DAOFactory.getAircraftDAO().addElement(a2);
		aircrafts.add(a2);
		DAOFactory.getAircraftDAO().addElement(a3);
		aircrafts.add(a3);
		DAOFactory.getAircraftDAO().addElement(a4);
		aircrafts.add(a4);
		Pilot p1 = new Pilot("1", "tati", "amateur", "mail@look.fr", "hhgtrd", "+33758954789", "23-05-2021", 75);
		Pilot p2 = new Pilot("2", "tazati", "amateurs", "mailouk@look.fr", "hhgjhtrd", "+33898954789", "23-05-2021",
				75);
		;
		DAOFactory.getPilotDAO().addElement(p1);
		DAOFactory.getPilotDAO().addElement(p2);
		pilots.add(p1);
		pilots.add(p2);

		Passenger pa1 = new Passenger("Julien", "Garcia", "julien@monmail.fr", "Lavie1563", "+33699857412",
				"18/05/1996");
		Passenger pa2 = new Passenger("Tiago", "Loloux", "titilol@monmail.fr", "Monalisaa15", "+33653527982",
				"19/05/1989");
		Passenger pa3 = new Passenger("Titi", "Louiloux", "timaol@monmail.fr", "Monia58", "+3367514982", "29/05/1979");
		DAOFactory.getPassengerDAO().addElement(pa1);
		DAOFactory.getPassengerDAO().addElement(pa2);
		DAOFactory.getPassengerDAO().addElement(pa3);

		Flight f1 = new Flight("AB789", "Paris", "Milan", "2021-05-04", "9h30", "2h30min", 50, "allersimple",
				"Aeroport CDG", 4, "Vous voulez allez à Milan mais tout les vols sont pris, voici la solution",
				p1.getPilotid(), a1.getAircrafttype());

		Flight f2 = new Flight("12345", "Nice", "Monaco", "2021-05-03", "8h30", "1h30", 65, "Promenade aérienne",
				"Nice Airport", 6, "Venez survolez la côte d'azur", p2.getPilotid(), a2.getAircrafttype());
		DAOFactory.getFlightDAO().addElement(f1);
		flights.add(f1.getId());
		DAOFactory.getFlightDAO().addElement(f2);
		flights.add(f2.getId());

	}

}
