package com.promineotech.requestapp.entity;

import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee implements Comparable<Employee> {

	private Long employeePk;
	private String employeeName;
	private String employeePhone;
	
	@JsonIgnore
	public Long getEmployeePk() {
		return employeePk;
	}
	
	@Override
	public int compareTo(Employee that) {
		return Comparator
				.comparing(Employee::getEmployeeName)
				.thenComparing(Employee::getEmployeePhone)
				.compare(this, that);
				
	}
}
