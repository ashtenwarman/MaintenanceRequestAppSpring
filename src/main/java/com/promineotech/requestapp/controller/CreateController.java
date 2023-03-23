package com.promineotech.requestapp.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.requestapp.entity.City;
import com.promineotech.requestapp.entity.Employee;
import com.promineotech.requestapp.entity.MaintenanceRequest;
import com.promineotech.requestapp.entity.Request;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/create")
@OpenAPIDefinition(info = @Info (title = "Maintenance Requests Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local Server")})
public interface CreateController {

	//@formatter:off
	  @Operation(
	      summary = "Create a maintenance request",
	      description = "Returns the created request",
	      responses = {
	          @ApiResponse(
	              responseCode = "201",
	              description = "The created request is returned",
	              content = @Content(
	                  mediaType = "application/json",
	                  schema = @Schema(implementation = MaintenanceRequest.class))),
	          @ApiResponse(
	              responseCode = "400",
	              description = "The request parameters are invalid",
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "404",
	              description = "A request component was not found with the input criteria",
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "500",
	              description = "An unplanned error occurred",
	              content = @Content(mediaType = "application/json"))
	      },
	      parameters = {
	          @Parameter(
	              name = "maintenanceRequest",
	              required = false,
	              description = "The request as JSON"),
	        }
	   )
	  
	  @PostMapping("/request")
	  @ResponseStatus(code = HttpStatus.CREATED)
	  MaintenanceRequest createRequest(@Valid @RequestBody MaintenanceRequest request);

	  
	  @Operation(
		      summary = "Hire a new employee",
		      description = "Creates a new employee",
		      responses = {
		          @ApiResponse(
		              responseCode = "201",
		              description = "The created employee is returned",
		              content = @Content(
		                  mediaType = "application/json",
		                  schema = @Schema(implementation = Employee.class))),
		          @ApiResponse(
		              responseCode = "400",
		              description = "The request parameters are invalid",
		              content = @Content(mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "404",
		              description = "A component was not found with the input criteria",
		              content = @Content(mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "500",
		              description = "An unplanned error occurred",
		              content = @Content(mediaType = "application/json"))
		      },
		      parameters = {
		          @Parameter(
		              name = "Name",
		              required = true,
		              description = "First and last name of new employee"),
		          @Parameter(
		          	name = "Phone number",
		          	required = false,
		          	allowEmptyValue = true,
		          	description = "Employee phone number (format:555-555-5555)"
		          	)
		        }
		   )
		  
		  @PostMapping("/employee")
		  @ResponseStatus(code = HttpStatus.CREATED)
		  void createEmployee(@Valid @RequestBody String employeeName,
				 @RequestParam String employeePhone);
	  
	  
	  @Operation(
		      summary = "Add a new city",
		      description = "Creates a new city",
		      responses = {
		          @ApiResponse(
		              responseCode = "201",
		              description = "The created city is returned",
		              content = @Content(
		                  mediaType = "application/json",
		                  schema = @Schema(implementation = City.class))),
		          @ApiResponse(
		              responseCode = "400",
		              description = "The request parameters are invalid",
		              content = @Content(mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "404",
		              description = "A component was not found with the input criteria",
		              content = @Content(mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "500",
		              description = "An unplanned error occurred",
		              content = @Content(mediaType = "application/json"))
		      },
		      parameters = {
		          @Parameter(
		              name = "City name",
		              required = true,
		              description = "Name of new city")
		        }
		   )
		  
		  @PostMapping("/city")
		  @ResponseStatus(code = HttpStatus.CREATED)
		  void createCity(@Valid @RequestBody String cityName);
	  
	  
	  @Operation(
		      summary = "Assigns an employee to a maintenance request",
		      description = "Creates an employee-request relationship given valid inputs",
		      responses = {
		          @ApiResponse(
		              responseCode = "201",
		              description = "The created assignment is returned",
		              content = @Content(
		                  mediaType = "application/json",
		                  schema = @Schema(implementation = Request.class))),
		          @ApiResponse(
		              responseCode = "400",
		              description = "The request parameters are invalid",
		              content = @Content(mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "404",
		              description = "A component was not found with the input criteria",
		              content = @Content(mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "500",
		              description = "An unplanned error occurred",
		              content = @Content(mediaType = "application/json"))
		      },
		      parameters = {
		          @Parameter(
		              name = "Request ID",
		              required = true,
		              allowEmptyValue = false,
		              description = "ID# of request"),
		          @Parameter(
		        		  name = "Employee ID",
		        		  required = true,
		        		  allowEmptyValue = false,
		        		  description = "ID# of employee"
		        		  )
		        }
		   )
		  
		  @PostMapping("/request_employee")
		  @ResponseStatus(code = HttpStatus.CREATED)
		  void createRequestEmployee(@RequestBody Long requestId,
				  @RequestBody Long employeeId);
	  
	  //@formatter:on
}
