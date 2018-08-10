package com.github.alekseyburger.YahooMonitor;

import java.util.ArrayList;
import java.util.List;

//import java.sql.*; 
import com.github.alekseyburger.yahoo_requests.Geo;
import com.github.alekseyburger.yahoo_requests.GeoResponse;
import com.github.alekseyburger.yahoo_requests.Weather;
import com.github.alekseyburger.yahoo_requests.WeatherResponse;

public class YahooMonitor {
	
	private static WeatherDAO weather_dao = new WeatherDAO();
	private static List<WeatherResponse> inputList = new ArrayList<>();
	
	public static List<WeatherResponse> getInputList() {
		return inputList;
	}
	
	public static void main(String[] args) {
		
		// start weather requesters
		new WeatherThread("London").start();
		new WeatherThread("Sankt Peterburg").start();
		new WeatherThread("Tel Aviv").start();
		new WeatherThread("New York").start();
		
		// wait responses an save
		try {
		while(true) {
			// wait for new data
			while(inputList.isEmpty()) {
				 Thread.sleep(100);
			}
			// remove data from the head
			WeatherResponse wresp = inputList.remove(0);
			// send data to DB
	    	weather_dao.Add(wresp.query.results.channel.location.city, wresp);
		}
		} catch(Exception e) {
			System.out.println("Exeption on main thread : " + e.toString());
		}
        //weather_dao.Show();
        weather_dao.Close();
	}
	
	@SuppressWarnings("unused")
	private static void GetNewForecast(String city) {
		
	    Geo geo = new Geo(city);
	    GeoResponse gresp = geo.request();
	    
	    if (gresp != null) {
	    	Weather w = new Weather(gresp.query.results.place[0].woeid);
	    	WeatherResponse wresp =  w.request();
	    	if (wresp != null) {
	    		weather_dao.Add(city, wresp);
	    	}
	    }
	}
}
