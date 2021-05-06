package com.tsiy.dao;

public interface BookingDAO extends DAO<Booking> {
	public void cancel(String id);
	public void Validate(String id,String pilotid);
}
