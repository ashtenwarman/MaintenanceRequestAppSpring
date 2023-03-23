package com.promineotech.requestapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.requestapp.dao.DeleteDao;

@Service
public class DefaultDeleteService implements DeleteService {

	@Autowired
	private DeleteDao deleteDao;
	
	@Transactional(readOnly = true)
	@Override
	public void deleteRequest(String streetAddress) {
		deleteDao.deleteRequest(streetAddress);

	}

}
