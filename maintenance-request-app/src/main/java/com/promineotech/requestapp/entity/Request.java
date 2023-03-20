package com.promineotech.requestapp.entity;

import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Request {

	private Integer requestPk;
	private Integer propertyPk;
	private Integer employeePk;
	private RequestType requestType;
	private String requestDate;
	
	@JsonIgnore
	public Integer getRequestPk() {
		return requestPk;
	}
	
	public int compareTo(Request that) {
		return Comparator
				.comparing(Request::getPropertyPk)
				.thenComparing(Request::getEmployeePk)
				.thenComparing(Request::getRequestType)
				.thenComparing(Request::getRequestDate)
				.compare(this, that);
	}
	
}
