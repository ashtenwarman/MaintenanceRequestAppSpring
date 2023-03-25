package com.promineotech.requestapp.entity;

import java.util.Comparator;

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
	
	@Override
	public int compareTo(Property that) {
		return Comparator
				.comparing(Property::getCityPk)
				.thenComparing(Property::getStreetAddress)
				.compare(this, that);
				
	}
}
