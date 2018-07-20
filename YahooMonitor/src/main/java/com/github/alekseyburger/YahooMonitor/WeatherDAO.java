package com.github.alekseyburger.YahooMonitor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.github.alekseyburger.yahoo_requests.WeatherResponse;


public class WeatherDAO {

    private Connection connection = null;

    public WeatherDAO() {

	    try{  
		    Class.forName("com.mysql.cj.jdbc.Driver");  
		    this.connection=DriverManager.getConnection(  
		    "jdbc:mysql://localhost:3306/example?verifyServerCertificate=false&useSSL=true","example","Example@22");  
		    //here sonoo is database name, root is username and password  
		}catch(Exception e){
			System.out.println(e);
		} 
    }
    
    public void Close() {
    	try{ 
    		this.connection.close();
		}catch(Exception e){
			System.out.println(e);
		} 
    }
    
	public boolean Add(WeatherResponse wresp) {
		int row = 0;
		try {
			Statement stmt= connection.createStatement();
			String sinsert = "INSERT INTO example ( id, name ) VALUES ( null, '" +
				wresp.query.results.channel.location.city + "," +
				//wresp.query.results.channel.location.country + "," +
				//wresp.query.results.channel.location.region + 
				"' )";
			row = stmt.executeUpdate(sinsert);
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
		}catch(Exception e){ System.out.println(e);} 
	}
}
