package com.promineotech.requestapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.requestapp.service.DeleteService;

@RestController

//Delete-controller implementing class
public class DefaultDeleteController implements DeleteController {

	@Autowired
	private DeleteService deleteService;
	
	@Override
	public void deleteRequest(String streetAddress) {
		deleteService.deleteRequest(streetAddress);
	}

}
