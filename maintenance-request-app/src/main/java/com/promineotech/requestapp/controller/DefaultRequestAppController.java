package com.promineotech.requestapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.promineotech.requestapp.entity.Request;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultRequestAppController implements RequestAppController {

	@Override
	public List<Request> fetchRequests(String cityName) {
		log.debug("cityName={}", cityName);
		return null;
	}

	
}
