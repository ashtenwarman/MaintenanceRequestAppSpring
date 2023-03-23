package com.promineotech.requestapp.dao;

import javax.validation.Valid;

import com.promineotech.requestapp.entity.Employee;
import com.promineotech.requestapp.entity.MaintenanceRequest;
import com.promineotech.requestapp.entity.Property;
import com.promineotech.requestapp.entity.RequestType;

public interface CreateDao {

	Property fetchProperty(Property property);
	Property fetchPropertyByAddress(String streetAddress);
	Employee fetchEmployee(Employee employee);
	RequestType fetchRequestType(RequestType requestType);
	String fetchRequestDate(String requestDate);
	
	MaintenanceRequest saveRequest(Property property, Employee employee,
			RequestType requestType, String requestDate);
	
	void createEmployee(String employeeName, String employeePhone);
	
	void createCity(String cityName);
	
	void createRequestEmployee(@Valid Long requestId, @Valid Long employeeId);
}
