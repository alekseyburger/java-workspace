package com.github.alekseyburger.YahooMonitor;

import com.github.alekseyburger.yahoo_requests.Geo;
import com.github.alekseyburger.yahoo_requests.GeoResponse;
import com.github.alekseyburger.yahoo_requests.Weather;
import com.github.alekseyburger.yahoo_requests.WeatherResponse;

public class YahooMonitor {

	public static void main(String[] args) {
	    Geo geo = new Geo("London");
	    GeoResponse gresp = geo.request();
	    
	    Weather w = new Weather(gresp.query.results.place[0].woeid);
        WeatherResponse wresp =  w.request();
        System.out.println(wresp.query.count);
	}

}
