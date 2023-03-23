package com.promineotech.requestapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.promineotech.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class RequestApp {

	public static void main(String[] args) {
		SpringApplication.run(RequestApp.class, args);
	}

}
