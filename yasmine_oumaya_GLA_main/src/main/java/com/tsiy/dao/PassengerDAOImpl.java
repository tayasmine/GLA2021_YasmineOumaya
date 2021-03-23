package com.tsiy.dao;


import java.util.List;

public class PassengerDAOImpl implements PassengerDAO {
	List<Passenger> passengers;
    public PassengerDAOImpl(){
        Passenger i1 = new Passenger("Julien");
		Passenger i2 = new Passenger("Nawal");
		this.passengers.add(i1);
		this.passengers.add(i2);
    }
	@Override
	public String getPassengerDetail(String id){
		for (Passenger p : this.passengers) {
			if (p.getPassengerid().equals(id)) {
				return p.toString();
			}
		}
		return "No passenger with this id found";

	}
	@Override
	public List<Passenger> getAllPassengers(){
		return this.passengers;
	}
	@Override
	public void ModifyPassengerPhoneNum(Passenger pass,int num){
		pass.setPhonenumber(num);
	}
	
    @Override
	public boolean Bookaflight(Passenger pass, Flight name) {
		if (name.availableseats > 0) {
			name.passengers.add(pass);
            name.availableseats--;
            pass.getBookedflights().add(name);
			
			return true;
		} else{
			return false;
		}
    }
	}