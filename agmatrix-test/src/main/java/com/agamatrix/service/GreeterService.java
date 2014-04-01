package com.agamatrix.service;

import com.agamatrix.configuration.GreeterConfiguration;
import com.agamatrix.controler.GreeterControler;
import com.agamatrix.controler.SayHelloControler;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class GreeterService extends Service<GreeterConfiguration> {

	
	
	public static void main(String[] args) throws Exception {
     new GreeterService().run(args);
    }
	
	@Override
	public void initialize(Bootstrap<GreeterConfiguration> bootstrap) {
		
		bootstrap.setName("test name");
		
	}

	@Override
	public void run(GreeterConfiguration configuration, Environment environment)
			throws Exception {
		// TODO Auto-generated method stub 
		//final ArrayList<Greeter> greetersList = configuration.getGreetersList(); 
		//final String name = configuration.getName();
		environment.addResource(new GreeterControler());
		environment.addResource(new SayHelloControler());
	}

}
