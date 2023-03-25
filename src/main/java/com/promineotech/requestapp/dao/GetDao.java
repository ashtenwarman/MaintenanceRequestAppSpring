package com.promineotech.requestapp.dao;

import java.util.List;

import com.promineotech.requestapp.entity.Property;
import com.promineotech.requestapp.entity.Request;
import com.promineotech.requestapp.entity.RequestType;

//DAO interface; receives data from service layer to be sent to database
public interface GetDao {

	List<Request> fetchRequests(RequestType requestType);

	List<Property> fetchProperty(String streetAddress, String cityName);
}
