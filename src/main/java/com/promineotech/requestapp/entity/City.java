package com.promineotech.requestapp.entity;

import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class City implements Comparable<City> {
	private Long cityPk;
	private String cityName;
	
	@JsonIgnore
	public Long getCityPk() {
		return cityPk;
	}
	
	@Override
	public int compareTo(City that) {
		return Comparator
				.comparing(City::getCityName)
				.compare(this, that);
	}
}
