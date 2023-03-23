package com.promineotech.requestapp.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MaintenanceRequest {
	private Property property;
	private Employee employee;
	private RequestType requestType;
	private String requestDate;
}
