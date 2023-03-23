package com.promineotech.requestapp.dao;

import com.promineotech.requestapp.entity.RequestType;

//DAO interface; receives data from service layer to be sent to database
public interface UpdateDao {

	void updateRequest(String streetAddress, RequestType requestType, String requestDate);

}
