package com.promineotech.requestapp.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
//Speaks to database using data from controller and service layers
public class DefaultDeleteDao implements DeleteDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public void deleteRequest(String streetAddress) {
		
		String sql = ""
				+ "DELETE FROM "
				+ "request WHERE"
				+ "property_fk = "
				+ "(SELECT property_pk FROM property "
				+ "WHERE street_address = :street_address)";
		
		Map<String, Object> param = new HashMap<>();
		param.put("street_address", streetAddress);
			
		jdbcTemplate.update(sql, param);
	}

}
