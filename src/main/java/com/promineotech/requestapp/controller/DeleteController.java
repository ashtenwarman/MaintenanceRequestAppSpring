package com.promineotech.requestapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.requestapp.entity.MaintenanceRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/delete")
public interface DeleteController {

	//@formatter:off
	  @Operation(
	      summary = "Deletes a maintenance request",
	      description = "Deletes a request given a valid address",
	      responses = {
	          @ApiResponse(
	              responseCode = "200",
	              description = "A maintenance request has been deleted",
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
	              description = "The property where request is being deleted")
	      })
	  @DeleteMapping("/request")
	  @ResponseStatus(code = HttpStatus.OK)
	  void deleteRequest(String streetAddress);

}
