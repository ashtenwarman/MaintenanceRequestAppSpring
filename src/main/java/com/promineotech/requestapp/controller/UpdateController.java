package com.promineotech.requestapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.requestapp.entity.MaintenanceRequest;
import com.promineotech.requestapp.entity.RequestType;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/update")
@OpenAPIDefinition(info = @Info (title = "Maintenance Requests Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local Server")})

//Update interface; sets up UI for updating an object
public interface UpdateController {
	
	//@formatter:off
	  @Operation(
	      summary = "Updates a maintenance request",
	      description = "Updates a request given valid input",
	      responses = {
	          @ApiResponse(
	              responseCode = "200",
	              description = "A maintenance request has been updated",
	              content = @Content(
	                  mediaType = "application/json",
	                  schema = @Schema(implementation = MaintenanceRequest.class))),
	          @ApiResponse(
	              responseCode = "400",
	              description = "The request parameters are invalid",
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "404",
	              description = "An input was not found with the given criteria",
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "500",
	              description = "An unplanned error occurred",
	              content = @Content(mediaType = "application/json"))
	      },
	      parameters = {
	          @Parameter(
	              name = "property address",
	              allowEmptyValue = false,
	              required = true,
	              description = "The property where request is being made"),
	          @Parameter(
	              name = "request type",
	              allowEmptyValue = false,
	              required = true,
	              description = "Type of request (e.g. PLUMBING, ELECTRICAL"),
	          @Parameter(
	        		  name = "request date",
	        		  allowEmptyValue = false,
	        		  required = true,
	        		  description = "Date request was updated")
	      }
	   )
	  
	  @PutMapping("/request")
	  @ResponseStatus(code = HttpStatus.OK)
	  void updateRequest(
	      @RequestParam(required = true)
	      String streetAddress,
	      @RequestParam(required = true)
	      RequestType requestType,
	      @RequestParam(required = true)
	      String requestDate);
	//@formatter:on
}

