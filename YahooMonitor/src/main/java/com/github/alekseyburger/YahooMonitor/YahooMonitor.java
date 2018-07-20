package com.github.alekseyburger.YahooMonitor;

import java.sql.*; 
import com.github.alekseyburger.yahoo_requests.Geo;
import com.github.alekseyburger.yahoo_requests.GeoResponse;
import com.github.alekseyburger.yahoo_requests.Weather;
import com.github.alekseyburger.yahoo_requests.WeatherResponse;

public class YahooMonitor {
	private static WeatherDAO weather_dao = new WeatherDAO();
	
	public static void main(String[] args) {
		GetNewForecast("London");
		GetNewForecast("Sankt Peterburg");
		GetNewForecast("Tel Aviv");
		GetNewForecast("New York");
        weather_dao.Show();
        weather_dao.Close();
	}
	
	private static void GetNewForecast(String city) {
	    Geo geo = new Geo(city);
	    GeoResponse gresp = geo.request();
	    
	    if (gresp != null) {
	    	Weather w = new Weather(gresp.query.results.place[0].woeid);
	    	WeatherResponse wresp =  w.request();
	    	if (wresp != null) {
	    		weather_dao.Add(wresp);
	    	}
	    }
	}
}
