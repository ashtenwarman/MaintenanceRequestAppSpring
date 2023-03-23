package com.promineotech.requestapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.requestapp.entity.RequestType;
import com.promineotech.requestapp.service.UpdateService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultUpdateController implements UpdateController {
	
	@Autowired
	private UpdateService updateRequestService;
	
	@Override
	public void updateRequest(String streetAddress, RequestType requestType, String requestDate) {
		log.debug("Update Service");
		updateRequestService.updateRequest(streetAddress, requestType, requestDate);
		;
	}

}
