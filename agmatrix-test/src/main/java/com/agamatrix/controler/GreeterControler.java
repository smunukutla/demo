package com.agamatrix.controler;



import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.jetty.util.ajax.JSON;

import com.agamatrix.core.Greeter;
import com.agamatrix.dao.JdbcDaoImpl;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.jaxrs.json.annotation.JSONP;
import com.yammer.metrics.annotation.Timed;

@Path("/greeter")
@Produces(MediaType.APPLICATION_JSON)
@JsonAutoDetect
public class GreeterControler {
	  
	private final AtomicLong counter;

	 public GreeterControler() {
		this.counter =  new AtomicLong();
	}

	@GET
	@Timed
	public ArrayList<Greeter> getGreeters(@QueryParam("id") String id) {
		
		ArrayList <Greeter> greetersArray = new ArrayList<Greeter>();
		
		Greeter greeter = null;
		
		try {
			//greeter = new JdbcDaoImpl().getAllGreeters();
			if(id == null  ){
				//ArrayList <Greeter> greetersArray1 = new JdbcDaoImpl().getAllGreeters();
				//greetersArray = new ArrayList<Greeter>();
				greetersArray.addAll(new JdbcDaoImpl().getAllGreeters()); 
				
			}else{
				long idnew = Long.parseLong(id, 10);
				greeter = new JdbcDaoImpl().getGreeter(idnew);	
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		greetersArray.add(greeter);
		
		return greetersArray;
		
	    }
	
	
	
	@POST
	@Timed
	public Greeter putGreeter(@QueryParam("name") String name){
		
		Greeter greeter = new JdbcDaoImpl().insertGreeter(name);
		return greeter;
	}
	
	
	@PUT
	@Timed
	@Consumes(MediaType.APPLICATION_JSON)
	public Greeter postGreeter(@QueryParam("id") Long id,@QueryParam("newName") String newName){
		//String myName= myname.toString();
		//Greeter greeter = null; 
		Greeter greeter = new JdbcDaoImpl().updatGreeter(id,newName);
		return greeter;
		 
	} 
	
	@DELETE
	@Timed
	@Path("/DELETE")
	public Greeter DeleteGreeter(){
		Greeter greeter = new JdbcDaoImpl().DeleteGreeter();
		return greeter;
		
	}
	
	
	
}