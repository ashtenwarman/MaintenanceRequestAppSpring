package com.promineotech.requestapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.promineotech.requestapp.entity.Property;
import com.promineotech.requestapp.entity.Request;
import com.promineotech.requestapp.entity.RequestType;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
//Speaks to database using data from controller and service layers
public class DefaultGetDao implements GetDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Request> fetchRequests(RequestType requestType) {
		log.debug("DAO: type={}", requestType);
		
		// @formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM request "
				+ "WHERE request_id = :request_id";
		// @formatter:on
		Map<String, Object> param = new HashMap<>();
		param.put("request_id", requestType.toString());
		
		return jdbcTemplate.query(sql, param, new RowMapper<>() {

			@Override
			public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Request.builder()
						.requestPk(rs.getLong("request_pk"))
						.propertyPk(rs.getLong("property_fk"))
						.employeePk(rs.getLong("employee_fk"))
						.requestType(RequestType.valueOf(rs.getString("request_id")))
						.requestDate(rs.getString("request_date"))
						.build();
			}});
	}

	@Override
	public List<Property> fetchProperty(String streetAddress) {
		String sql = ""
				+ "SELECT * "
				+ "FROM property "
				+ "WHERE street_address = :street_address";
		
		Map<String, Object> param = new HashMap<>();
		param.put("street_address", streetAddress);
		
		return jdbcTemplate.query(sql, param, new RowMapper<>() {

			@Override
			public Property mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Property.builder()
						.propertyPk(rs.getLong("property_pk"))
						.cityPk(rs.getLong("city_fk"))
						.streetAddress(rs.getString("street_address"))
						.isRented(rs.getBoolean("is_rented"))
						.build();
			}
		});
	}
}
