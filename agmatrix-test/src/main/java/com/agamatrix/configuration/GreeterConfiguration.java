package com.agamatrix.configuration;

import java.util.ArrayList;

import org.hibernate.validator.constraints.NotEmpty;

import com.agamatrix.core.Greeter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

public class GreeterConfiguration extends Configuration {

	@NotEmpty
    @JsonProperty
    private String name;
	
	
    @JsonProperty
	ArrayList<Greeter> greetersList;
    
    @JsonProperty
    Greeter greeter;
	
	public Greeter getGreeter() {
		return greeter;
	}

	public ArrayList<Greeter> getGreetersList() {
		return greetersList;
	}

	public String getName() {
		return name;
	}
}
