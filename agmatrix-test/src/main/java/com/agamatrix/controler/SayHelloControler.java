package com.agamatrix.controler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.agamatrix.core.Greeter;
import com.agamatrix.dao.JdbcDaoImpl;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.yammer.metrics.annotation.Timed;

@Path("/sayhello")
@Produces(MediaType.APPLICATION_JSON)
@JsonAutoDetect
public class SayHelloControler {
	
	@GET
	@Timed
	public String sayHello(@QueryParam("id") String id, @QueryParam("name") String name){
		
		String returnmessage = null;
		
		if((id== null || id == " ") && (name == null || name == "" ) ){
			returnmessage = "Hello World, I am the server";
		}else
			if((id == null || id == " ") && name != null ){
			returnmessage = "Hello "+name+", I am the server";
		}else if((id != null || id != " ") && (name == null || name == "") ) {
			long idnew = Long.parseLong(id, 10);
			Greeter greeter = null;
			greeter = new JdbcDaoImpl().getGreeter(idnew);			
			returnmessage = "Hello "+greeter.getName()+", I am the server";
		}else if((id != null || id != " ") && name != null ){
			long idnew = Long.parseLong(id, 10);
			Greeter greeter = null;
			greeter = new JdbcDaoImpl().getGreeter(idnew);			
			returnmessage = "Hello "+name+", I am the "+greeter.getName()+"";
		}
		return returnmessage;
	}
}
