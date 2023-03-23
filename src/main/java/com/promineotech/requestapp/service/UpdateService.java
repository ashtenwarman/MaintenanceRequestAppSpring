package com.promineotech.requestapp.service;

import com.promineotech.requestapp.entity.RequestType;

public interface UpdateService {

	void updateRequest(String streetAddress, RequestType requestType, String requestDate);

}
