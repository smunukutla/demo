package com.agamatrix.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.agamatrix.core.Greeter;
import com.mysql.jdbc.PreparedStatement;

public class JdbcDaoImpl {

	
public Greeter getGreeter(Long greeterId){
		
		Connection conn = null;
		try {
		String driver ="com.mysql.jdbc.Driver";
		Class.forName(driver).newInstance();
		String connectionUrl = "jdbc:mysql://localhost:3306/mydatabase?user=root&password=";
		//String connectionUser = "root";
		//String connectionPassword = "";
		conn = DriverManager.getConnection(connectionUrl);
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from greeter where uniqueID= ?");
		ps.setFloat(1, greeterId);
		Greeter greeter = null;
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			greeter = new Greeter(greeterId, rs.getString("USER"));
			
		}
		rs.close();
		ps.close();
		return greeter;
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


public ArrayList<Greeter> getAllGreeters(){
	ArrayList <Greeter> AllGreetersArray = new ArrayList<Greeter>();
	
	Connection conn = null;
	try {
	String driver ="com.mysql.jdbc.Driver";
	Class.forName(driver).newInstance();
	String connectionUrl = "jdbc:mysql://localhost:3306/mydatabase?user=root&password=";
	//String connectionUser = "root";
	//String connectionPassword = "";
	conn = DriverManager.getConnection(connectionUrl);
	PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from greeter");
	Greeter greeter = null;
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()){
		greeter = new Greeter(rs.getLong("uniqueID"),rs.getString("USER"));
		AllGreetersArray.add(greeter);
	}
	rs.close();
	ps.close();
	return AllGreetersArray;
	}
	catch(Exception e){
		throw new RuntimeException(e);
	}
	
	finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


public Greeter insertGreeter(String greeterName){
	
	Connection conn = null;
	try {
		long greeterId=0;
	String driver ="com.mysql.jdbc.Driver";
	Class.forName(driver).newInstance();
	String connectionUrl = "jdbc:mysql://localhost:3306/mydatabase?user=root&password=";
	//String connectionUser = "root";
	//String connectionPassword = "";
	conn = DriverManager.getConnection(connectionUrl);
	
	PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement("select MAX(uniqueID) FROM greeter");
    ResultSet rs = ps2.executeQuery();
	
	if(rs.next()){
		greeterId = rs.getLong(1);
		
	}
	rs.close();
	ps2.close();
	greeterId = greeterId +1;
	PreparedStatement ps = (PreparedStatement) conn.prepareStatement("INSERT INTO greeter (uniqueID,USER) VALUES (?,?)");
	
	ps.setFloat(1, greeterId);
	ps.setString(2, greeterName);
	ps.executeUpdate();
	
	Greeter greeter1 = null;
	greeter1 = new Greeter(greeterId, greeterName);

	ps.close();
	return greeter1;
	}
	catch(Exception e){
		throw new RuntimeException(e);
	}
	
	finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

public Greeter updatGreeter(Long id,String greeterName){
	
	Connection conn = null;
	try {
		String driver ="com.mysql.jdbc.Driver";
	Class.forName(driver).newInstance();
	String connectionUrl = "jdbc:mysql://localhost:3306/mydatabase?user=root&password=";
	//String connectionUser = "root";
	//String connectionPassword = "";
	conn = DriverManager.getConnection(connectionUrl);
	PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement("update greeter set USER = ? where uniqueID= ?");
	ps2.setString(1, greeterName);
	ps2.setFloat(2, id);
    ps2.executeUpdate();
    
	Greeter greeter = null;
	greeter = new Greeter(id, greeterName);
	ps2.close();
	return greeter;
	}
	catch(Exception e){
		throw new RuntimeException(e);
	}
	
	finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}


public Greeter DeleteGreeter(){
	
	Connection conn = null;
	try {
		String driver ="com.mysql.jdbc.Driver";
	Class.forName(driver).newInstance();
	String connectionUrl = "jdbc:mysql://localhost:3306/mydatabase?user=root&password=";
	//String connectionUser = "root";
	//String connectionPassword = "";
	conn = DriverManager.getConnection(connectionUrl);
	PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from greeter");
	ResultSet rs = ps.executeQuery();
	Greeter greeter = null;
	if(rs.next()){
		greeter = new Greeter(rs.getLong("uniqueID"), rs.getString("USER"));
	}
	rs.close();
	ps.close();
	
	PreparedStatement ps1 = (PreparedStatement) conn.prepareStatement("DELETE from greeter where uniqueID= ?");
	ps1.setFloat(1, greeter.getUniqueID());
	ps1.executeUpdate();
	ps1.close();
	return greeter;
	}
	catch(Exception e){
		throw new RuntimeException(e);
	}
	
	finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}




}
