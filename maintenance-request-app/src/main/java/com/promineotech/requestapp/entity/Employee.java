package com.promineotech.requestapp.entity;

import java.util.Comparator;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee implements Comparable<Employee> {

	private Long employeePk;
	private String employeeName;
	private String employeePhone;
	
	@Override
	public int compareTo(Employee that) {
		return Comparator
				.comparing(Employee::getEmployeeName)
				.thenComparing(Employee::getEmployeePhone)
				.compare(this, that);
				
	}
}
