package com.promineotech.requestapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.requestapp.entity.MaintenanceRequest;
import com.promineotech.requestapp.service.CreateService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

//Create-interface implementing class
public class DefaultCreateController implements CreateController {

	@Autowired
	private CreateService createRequestService;
	
	@Override
	public MaintenanceRequest createRequest(MaintenanceRequest request) {
		log.debug("Request={}", request);
		return createRequestService.createRequest(request);
	}

	@Override
	public void createEmployee(String employeeName, String employeePhone) {
		createRequestService.createEmployee(employeeName, employeePhone);
	}

	@Override
	public void createCity(String cityName) {
		createRequestService.createCity(cityName);
	}

	@Override
	public void createRequestEmployee(Long requestId, Long employeeId) {
		createRequestService.createRequestEmployee(requestId, employeeId);
	}

	
	
}
