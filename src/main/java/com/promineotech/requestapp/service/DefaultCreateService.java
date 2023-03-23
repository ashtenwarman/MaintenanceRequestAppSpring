package com.promineotech.requestapp.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.requestapp.dao.CreateDao;
import com.promineotech.requestapp.entity.Employee;
import com.promineotech.requestapp.entity.MaintenanceRequest;
import com.promineotech.requestapp.entity.Property;
import com.promineotech.requestapp.entity.RequestType;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultCreateService implements CreateService {

	@Autowired
	private CreateDao createRequestDao;
	
	@Transactional
	@Override
	public MaintenanceRequest createRequest(MaintenanceRequest request) {
		log.debug("Request={}", request);
		
		Property property = getProperty(request);
		Employee employee = getEmployee(request);
		RequestType requestType = getRequestType(request);
		String requestDate = getRequestDate(request);
		
		return createRequestDao.saveRequest(property, employee, requestType, requestDate);
	}

	private Property getProperty(MaintenanceRequest request) {
		return createRequestDao.fetchProperty(request.getProperty());
				
		}

	
	private Employee getEmployee(MaintenanceRequest request) {
		return createRequestDao.fetchEmployee(request.getEmployee());
		
	}
	
	private RequestType getRequestType(MaintenanceRequest request) {
		return createRequestDao.fetchRequestType(request.getRequestType());
		
	}
	
	private String getRequestDate(MaintenanceRequest request) {
		return createRequestDao.fetchRequestDate(request.getRequestDate());
				
	}

	@Override
	public void createEmployee(@Valid String employeeName, String employeePhone) {
		createRequestDao.createEmployee(employeeName, employeePhone);
	}

	@Override
	public void createCity(String cityName) {
		createRequestDao.createCity(cityName);
	}

	@Override
	public void createRequestEmployee(@Valid Long requestId, @Valid Long employeeId) {
		createRequestDao.createRequestEmployee(requestId, employeeId);
		
	}
	
}
