package com.github.alekseyburger.YahooMonitor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.github.alekseyburger.yahoo_requests.WeatherResponse;

/*
mysql -u root -p
GRANT ALL PRIVILEGES ON *.* TO 'weather'@'localhost' IDENTIFIED BY 'Weather@22';
CREATE DATABASE weather;
use weather;
CREATE TABLE weather ( id smallint unsigned not null auto_increment,
 location varchar(20) not null,
 Atmosphere_humidity INT,
 Atmosphere_pressure FLOAT,
 Atmosphere_rising INT,
 Atmosphere_visibility FLOAT,
 forecast_date VARCHAR(20),
 forecast_day VARCHAR(5),
 forecast_high INT,
 forecast_low INT,
 constraint pk_weather primary key (id) );
*/

public class WeatherDAO {

    private Connection connection = null;

    public WeatherDAO() {

	    try{  
		    Class.forName("com.mysql.cj.jdbc.Driver");  
		    this.connection=DriverManager.getConnection(  
		    "jdbc:mysql://localhost:3306/weather?verifyServerCertificate=false&useSSL=true","weather","Weather@22");  
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

	public boolean Add(String location, WeatherResponse wresp) {
		int row = 0;
		try {
			Statement stmt= connection.createStatement();
			String sinsert =  "INSERT INTO weather (id, location, Atmosphere_humidity," +
				"Atmosphere_pressure, Atmosphere_rising, Atmosphere_visibility," +
				"forecast_date, forecast_day,  forecast_high, forecast_low)" +
				"VALUES (null, '" + location + "'," +
		    	wresp.query.results.channel.atmosphere.humidity + "," +
		    	wresp.query.results.channel.atmosphere.pressure + "," +
		    	wresp.query.results.channel.atmosphere.rising  + "," +
		    	wresp.query.results.channel.atmosphere.visibility + ",'" +
		    	wresp.query.results.channel.item.forecast[0].date + "','" +
		    	wresp.query.results.channel.item.forecast[0].day + "',"  + 
		    	wresp.query.results.channel.item.forecast[0].high + "," +
		    	wresp.query.results.channel.item.forecast[0].low + ")";
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
	    	ResultSet rs=stmt.executeQuery("select * from weather");  
	    	while(rs.next()) {
	    		System.out.print(rs.getInt(1) + " | ");
	    		System.out.print(rs.getString(2) + " | ");
	    		System.out.print(rs.getInt(3) + " | ");
	    		System.out.print(rs.getFloat(4) + " | ");
	    		System.out.print(rs.getInt(5) + " | ");
	    		System.out.print(rs.getFloat(6) + " | ");
	    		System.out.print(rs.getString(7) + " | ");
	    		System.out.print(rs.getString(8) + " | ");
	    		System.out.print(rs.getInt(9) + " | ");
	    		System.out.println(rs.getInt(10));
	    	} 
		}catch(Exception e){ System.out.println(e);} 
	}
}
