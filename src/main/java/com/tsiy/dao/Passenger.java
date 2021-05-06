package com.tsiy.dao;




import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Passenger {
	@PrimaryKey
	@Persistent
	protected String passengerid;
	
	protected String passengerName;
	protected String passengerMail;
	protected String password;
	protected String phonenumber;
	protected String birthdate;


	public Passenger() {

	}

	

	public Passenger(String passengerid, String passengerName, String passengerMail,String password, String phonenumber,
			String birthdate) {
		// super();
		this.passengerid = passengerid;
		this.passengerName = passengerName;
		this.passengerMail = passengerMail;
		this.password=password;
		this.phonenumber = phonenumber;
		this.birthdate = birthdate;
	
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassengerid() {
		return passengerid;
	}

	public void setPassengerid(String passengerid) {
		this.passengerid = passengerid;
		

	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerMail() {
		return passengerMail;
	}

	public void setPassengerMail(String passengerMail) {
		this.passengerMail = passengerMail;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}



	@Override
	public String toString() {
		return "Passenger [passengerid=" + passengerid + ", passengerName=" + passengerName + ", passengerMail="
				+ passengerMail + ", phonenumber=" + phonenumber + "]";
	}

}
