package com.tsiy.dao;



import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

@PersistenceCapable
public class Booking {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	@Unique
	private String bookId;
	@Persistent
	private String passengerId;
	@Persistent
	private String flightId;
	@Persistent
	private String statut;
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getStatut() {
		return statut;
	}
	public Booking() {
	}
	public Booking(String bookId) {
		this.bookId = bookId;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Booking(String flightId, String passengerId, String statut) {
		this.passengerId = passengerId;
		this.flightId = flightId;
		this.statut = statut;
	}
}

