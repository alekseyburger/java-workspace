package com.github.alekseyburger.YahooMonitor;

import java.sql.*; 
import com.github.alekseyburger.yahoo_requests.Geo;
import com.github.alekseyburger.yahoo_requests.GeoResponse;
import com.github.alekseyburger.yahoo_requests.Weather;
import com.github.alekseyburger.yahoo_requests.WeatherResponse;

public class YahooMonitor {

	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/example?verifyServerCertificate=false&useSSL=true","example","Example@22");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();
			int row = stmt.executeUpdate("INSERT INTO example ( id, name ) VALUES ( null, 'Sample data' )");
			ResultSet rs=stmt.executeQuery("select * from example");  
			while(rs.next())  
			    System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
			    con.close();  
			}catch(Exception e){ System.out.println(e);}    
	}
	
	public static void waiting() {
	    Geo geo = new Geo("London");
	    GeoResponse gresp = geo.request();
	    
	    Weather w = new Weather(gresp.query.results.place[0].woeid);
        WeatherResponse wresp =  w.request();
        System.out.println(wresp.query.count);
	}

}
