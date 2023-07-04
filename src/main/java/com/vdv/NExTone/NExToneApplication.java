package com.vdv.NExTone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class NExToneApplication {

	public static void main(String[] args) {
		SpringApplication.run(NExToneApplication.class, args);
	}

}
