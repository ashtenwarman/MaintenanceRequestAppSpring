package com.promineotech.requestapp.service;

import java.util.List;

import com.promineotech.requestapp.entity.Property;
import com.promineotech.requestapp.entity.Request;
import com.promineotech.requestapp.entity.RequestType;

public interface GetService {

	List<Request> fetchRequests(RequestType requestType);

	List<Property> fetchProperty(String streetAddress, String cityName); 

}
