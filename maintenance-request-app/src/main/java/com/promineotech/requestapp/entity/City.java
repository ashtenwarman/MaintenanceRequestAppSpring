package com.promineotech.requestapp.entity;

import java.util.Comparator;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class City implements Comparable<City> {
	private Integer cityPk;
	private String cityName;
	
	@Override
	public int compareTo(City that) {
		return Comparator
				.comparing(City::getCityPk)
				.thenComparing(City::getCityName)
				.compare(this, that);
	}
}
