package com.promineotech.requestapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.requestapp.dao.UpdateDao;
import com.promineotech.requestapp.entity.RequestType;

@Service
public class DefaultUpdateService implements UpdateService {

	@Autowired
	private UpdateDao updateRequestDao;
	
	@Override
	public void updateRequest(String streetAddress, RequestType requestType, String requestDate) {
		updateRequestDao.updateRequest(streetAddress, requestType, requestDate);

	}

}
