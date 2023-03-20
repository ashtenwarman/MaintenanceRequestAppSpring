package com.promineotech.requestapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.requestapp.entity.Request;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@RequestMapping("/get")
@OpenAPIDefinition(info = @Info (title = "Maintenance Requests Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local Server")})
public interface RequestAppController {
	//READ requests
	// @formatter:off
	 @Operation(
		summary = "Returns a list of requests",
		description = "Returns a list of requests given an optional request type",
		responses = {
				@ApiResponse(
					responseCode = "200",
					description = "A list of requests are returned",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = Request.class))),
					
				@ApiResponse(
						responseCode = "400",
						description = "Invalid Parameters",
						content = @Content(
							mediaType = "application/json")),
				
				@ApiResponse(
						responseCode = "404",
						description = "No requests were found with the input criteria",
						content = @Content(
							mediaType = "application/json")),
				
				@ApiResponse(
						responseCode = "500",
						description = "An unplanned error occurred",
						content = @Content(
							mediaType = "application/json"))
		},
		parameters = {
				@Parameter(
					name = "request type",
					allowEmptyValue = false,
					required = false,
					description = "The request type (options: "
								+ "PLUMBING, ELECTRICAL, APPLIANCE, "
								+ "AC_HEATING, GENERAL_REPAIR, LAWN_SNOW, OTHER)")
		}
	)				
		
	
		@GetMapping("/requests")
		@ResponseStatus(code = HttpStatus.OK)
		List<Request> fetchRequests(
				@RequestParam(required = false)
				String cityName);
		// @formatter:on
			 
	
	 
}
