package com.promineotech.requestapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.requestapp.entity.Property;
import com.promineotech.requestapp.entity.Request;
import com.promineotech.requestapp.entity.RequestType;
import com.promineotech.requestapp.service.GetService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

//Get-interface implementing class
public class DefaultGetController implements GetController {

	@Autowired
	private GetService requestAppService;
	
	@Override
	public List<Request> getRequests(RequestType requestType) {
		log.debug("type={}", requestType);
		return requestAppService.fetchRequests(requestType);
	}
	
	@Override
	public List<Property> fetchProperty(String streetAddress, String cityName) {
		return requestAppService.fetchProperty(streetAddress, cityName);
	}
}
