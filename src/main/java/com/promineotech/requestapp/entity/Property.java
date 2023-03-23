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
public class Property implements Comparable<Property> {

	private Long propertyPk;
	private Long cityPk;
	private String streetAddress;
	private Boolean isRented;
	
	@JsonIgnore
	public Long getPropertyPk() {
		return propertyPk;
	}
	@JsonIgnore
	public Long getCityPk() {
		return cityPk;
	}
	
	@Override
	public int compareTo(Property that) {
		return Comparator
				.comparing(Property::getCityPk)
				.thenComparing(Property::getStreetAddress)
				.compare(this, that);
				
	}
}
