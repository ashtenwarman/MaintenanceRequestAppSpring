package com.promineotech.requestapp.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.promineotech.requestapp.entity.Request;
import com.promineotech.requestapp.entity.RequestType;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
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
		//Given: a valid request type
		RequestType requestType = RequestType.PLUMBING;
		
		String uri = 
				String.format("http://localhost:%d/requests?requestType=%s", serverPort ,requestType);
		//When: a connection is made to the uri
		ResponseEntity<List<Request>> response = 
				restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		//Then: a 200 response is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		//And: the actual list returned is the same as the expected list
		List<Request> actual = response.getBody();
		List<Request> expected = buildExpected();
		
		assertThat(actual).isEqualTo(expected);
	}

	protected List<Request> buildExpected() {
		List<Request> list = new LinkedList<>();
		// @formatter:off
		Request request1 = Request.builder()
				.requestType(RequestType.PLUMBING)
				.requestDate("2023-03-12")
				.build();
		
//		Request request2 = Request.builder()
//				.requestType(RequestType.ELECTRICAL)
//				.requestDate("2023-03-13")
//				.build();
		// @formatter:on
		list.add(request1);
//		list.add(request2);
		Collections.sort(list);
		return list;
	}
}
