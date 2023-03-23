package com.promineotech.requestapp.dao;

import com.promineotech.requestapp.entity.RequestType;

public interface UpdateDao {

	void updateRequest(String streetAddress, RequestType requestType, String requestDate);

}
