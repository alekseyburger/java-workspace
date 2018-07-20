package com.github.alekseyburger.YahooMonitor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class WeatherDAO {

    private final Connection connection = null;

    public WeatherDAO(Connection connection) {

	    try{  
		    Class.forName("com.mysql.cj.jdbc.Driver");  
		    connection=DriverManager.getConnection(  
		    "jdbc:mysql://localhost:3306/example?verifyServerCertificate=false&useSSL=true","example","Example@22");  
		    //here sonoo is database name, root is username and password  
		}catch(Exception e){
			System.out.println(e);
		} 
    }
    
	public boolean Add() {
		int row = 0;
		try {
			Statement stmt= connection.createStatement();
			row = stmt.executeUpdate("INSERT INTO example ( id, name ) VALUES ( null, 'Sample data' )");
			stmt.close();
		} catch(Exception e){ 
			System.out.println(e);
		} 
        return (row == 1);
	}
	
	public void Show() {
	    try{
	    	Statement stmt= connection.createStatement();
	    	ResultSet rs=stmt.executeQuery("select * from example");  
	    	while(rs.next()) {
	    		System.out.println(rs.getInt(1)+"  "+rs.getString(2));
	    	}
		    connection.close();  
		}catch(Exception e){ System.out.println(e);} 
	}
}
