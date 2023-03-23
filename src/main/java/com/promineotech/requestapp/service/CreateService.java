package com.promineotech.requestapp.service;

import javax.validation.Valid;

import com.promineotech.requestapp.entity.MaintenanceRequest;

public interface CreateService {

	MaintenanceRequest createRequest(MaintenanceRequest request);

	void createEmployee(@Valid String employeeName, String employeePhone);
	
	void createCity(String cityName);

	void createRequestEmployee(@Valid Long requestId, @Valid Long employeeId);
}
