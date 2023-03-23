package com.promineotech.requestapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.promineotech.requestapp.entity.Employee;
import com.promineotech.requestapp.entity.MaintenanceRequest;
import com.promineotech.requestapp.entity.Property;
import com.promineotech.requestapp.entity.RequestType;

@Component
public class DefaultCreateDao implements CreateDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public Property fetchProperty(Property property) {
		 
		String sql = ""
				+ "SELECT * "
				+ "FROM property "
				+ "WHERE property_pk = :property_pk";
		Map<String, Object> params = new HashMap<>();
		params.put("property_pk", property.getPropertyPk());
		return jdbcTemplate.queryForObject(sql, params, new RowMapper<>() {
		@Override
		public Property mapRow(ResultSet rs, int rowNum) throws SQLException {
			// @formatter:off
			return Property.builder()
					.propertyPk(rs.getLong("property_pk"))
					.cityPk(rs.getLong("city_fk"))
					.streetAddress(rs.getString("street_address"))
					.isRented(rs.getBoolean("is_rented"))
					.build();
			// @formatter:on
		}
		});
	}

	@Override
	public Property fetchPropertyByAddress(String streetAddress) {
		String sql = ""
				+ "SELECT * "
				+ "FROM property "
				+ "WHERE street_address = :streetAddress";
		Map<String, Object> param = new HashMap<>();
		param.put("street_address", streetAddress);
		return jdbcTemplate.queryForObject(sql, param, new RowMapper<>() {

			@Override
			public Property mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Property.builder()
						.cityPk(rs.getLong("city_fk"))
						.streetAddress(rs.getString("street_address"))
						.isRented(rs.getBoolean("is_rented"))
						.build();
			}
		});
	}
	
	
	@Override
	public Employee fetchEmployee(Employee employee) {
		
		String sql = ""
				+ "SELECT * "
				+ "FROM employee "
				+ "WHERE employee_name = :employee_name";
		Map<String, Object> params = new HashMap<>();
		params.put("employee_name", employee.getEmployeeName());
		return jdbcTemplate.queryForObject(sql, params, new RowMapper<>() {
		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			// @formatter:off
			return Employee.builder()
					.employeePk(rs.getLong("employee_pk"))
					.employeeName(rs.getString("employee_name"))
					.employeePhone(rs.getString("employee_phone"))
					.build();
			// @formatter:on
		}
		});
	}

	@Override
	public RequestType fetchRequestType(RequestType requestType) {
		String sql = ""
				+ "SELECT request_id "
				+ "FROM request "
				+ "WHERE request_id = :request_id";
		
		Map<String, Object> params = new HashMap<>();
		params.put("request_id", requestType);
		return jdbcTemplate.query(sql, params, new ResultSetExtractor<>() {

			@SuppressWarnings("static-access")
			@Override
			public RequestType extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
				return requestType.valueOf(rs.getString("request_id"));
				
			}

			
		});
	}

	@Override
	public String fetchRequestDate(String requestDate) {
		String sql = ""
				+ "SELECT request_date "
				+ "FROM request "
				+ "WHERE request_date = :request_date";
		Map<String, Object> params = new HashMap<>();
		params.put("request_date", requestDate);
		
		return jdbcTemplate.query(sql, params, new ResultSetExtractor<>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				rs.next();
				return rs.getString("request_date");
			}
		});
	}

	@Override
	public MaintenanceRequest saveRequest(Property property, Employee employee, RequestType requestType, String requestDate) {
		SqlParams params = 
				generateInsertSql(property, employee, requestType, requestDate);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(params.sql, params.source, keyHolder);
		
		// @formatter:off
		return MaintenanceRequest.builder()
				.property(property)
				.employee(employee)
				.requestType(requestType)
				.requestDate(requestDate)
				.build();
	}
	
	private SqlParams generateInsertSql(Property property, Employee employee, RequestType requestType, String requestDate) {
		// @formatter:off
		String sql = ""
				+ "INSERT INTO request ("
				+ "property_fk, employee_fk, request_id, request_date"
				+ ") VALUES ("
				+ ":property_fk, :employee_fk, :request_id, :request_date)";
		// @formatter:on
		SqlParams params = new SqlParams();
		params.sql = sql;
		params.source.addValue("property_fk", property.getPropertyPk());
		params.source.addValue("employee_fk", employee.getEmployeePk());
		params.source.addValue("request_id", requestType);
		params.source.addValue("request_date", requestDate);
		
		return params;
	}

	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}

	@Override
	public void createEmployee(String employeeName, String employeePhone) {
		String sql = ""
				+ "INSERT INTO employee "
				+ "(employee_name, employee_phone) "
				+ "VALUES "
				+ "(:employee_name, :employee_phone)";
		
		Map<String, Object> param = new HashMap<>();
		param.put("employee_name", employeeName);
		param.put("employee_phone", employeePhone);
		
		jdbcTemplate.update(sql, param);
		
	}

	@Override
	public void createCity(String cityName) {
		String sql = ""
				+ "INSERT INTO city (city_name) "
				+ "VALUES (:city_name)";
		Map<String, Object> param = new HashMap<>();
		param.put("city_name", cityName);
		
		jdbcTemplate.update(sql, param);
		
	}

	@Override
	public void createRequestEmployee(@Valid Long requestId, @Valid Long employeeId) {
		String sql = ""
				+ "INSERT INTO request_employee "
				+ "(request_fk, employee_fk) "
				+ "VALUES "
				+ "(:request_fk, :employee_fk)";
		Map<String, Object> param = new HashMap<>();
		param.put("request_fk", requestId);
		param.put("employee_fk", employeeId);
		
		jdbcTemplate.update(sql, param);
		
	}
}
