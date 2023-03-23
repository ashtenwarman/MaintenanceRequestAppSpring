package com.promineotech.requestapp.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.requestapp.entity.RequestType;

@Component
//Speaks to database using data from controller and service layers
public class DefaultUpdateDao implements UpdateDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public void updateRequest(String streetAddress, RequestType requestType, String requestDate) {
		String sql = ""
				+ "UPDATE request "
				+ "SET property_fk = "
				+ "(SELECT property_pk FROM property "
				+ "WHERE street_address = :street_address), "
				+ "request_id = :request_id, "
				+ "request_date = :request_date";
		Map<String, Object> param = new HashMap<>();
		param.put("street_address", streetAddress);
		param.put("request_id", requestType);
		param.put("request_date", requestDate);
		
		jdbcTemplate.update(sql, param);

	}

}
