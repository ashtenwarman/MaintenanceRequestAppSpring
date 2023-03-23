package com.promineotech.requestapp.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.requestapp.dao.GetDao;
import com.promineotech.requestapp.entity.Property;
import com.promineotech.requestapp.entity.Request;
import com.promineotech.requestapp.entity.RequestType;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultGetService implements GetService {
	
	@Autowired
	GetDao fetchRequestDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Request> fetchRequests(RequestType requestType) {
		log.debug("type={}", requestType);
		List<Request> requests = fetchRequestDao.fetchRequests(requestType);
		
		if(requests.isEmpty()) {
			String msg = String.format("No maintenance requests were found with type={}",
					requestType);
			throw new NoSuchElementException(msg);
		}
		Collections.sort(requests);
		return requests;
	}

	@Transactional
	@Override
	public List<Property> fetchProperty(String streetAddress) {
		List<Property> property = fetchRequestDao.fetchProperty(streetAddress);
		
		if(Objects.isNull(property)) {
			throw new NoSuchElementException();
		}
		return property;
	}

}
