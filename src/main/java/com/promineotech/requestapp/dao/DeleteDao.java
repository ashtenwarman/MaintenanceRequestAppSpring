package com.promineotech.requestapp.dao;

//DAO interface; receives data from service layer to be sent to database
public interface DeleteDao {

	void deleteRequest(String streetAddress);

}
