package com.promineotech.requestapp.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.promineotech.requestapp.entity.Request;
import com.promineotech.requestapp.entity.RequestType;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql(scripts = 
		{"classpath:flyway/migrations/V1.0__Request_Schema.sql",
		 "classpath:flyway/migrations/V1.1__Request_Data.sql"},
		 config = @SqlConfig(encoding = "utf-8"))
class FetchRequestTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int serverPort;
	
	@Test
	void testThatPreviouslyCreatedRequestsAreReturned() {
		//Given: a valid request
		RequestType requestType = RequestType.ELECTRICAL;
		
		
		String uri = 
				String.format("http://localhost:%d/requests?requestType=%s", serverPort ,requestType);
		//When: a connection is made to the uri
		ResponseEntity<Request> response = 
				restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		//Then: a 200 response is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		//And: the actual list returned is the same as the expected list
		Request actual = response.getBody();
		Request expected = buildExpected();
		
		assertThat(actual).isEqualTo(expected);
	}

	private Request buildExpected() {
		// @formatter:off
		Request request1 = Request.builder()
				.requestType(RequestType.PLUMBING)
				.build();
		// @formatter:on

		return request1;
	}

}
