package com.tsiy.dao;

public interface PassengerDAO extends DAO<Passenger> {
	Passenger getPassengerByEmailAndPassword(String email, String password);

}
