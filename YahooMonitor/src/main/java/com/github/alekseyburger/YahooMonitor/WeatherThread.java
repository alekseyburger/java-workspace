package com.github.alekseyburger.YahooMonitor;

import java.util.List;

import com.github.alekseyburger.yahoo_requests.Geo;
import com.github.alekseyburger.yahoo_requests.GeoResponse;
import com.github.alekseyburger.yahoo_requests.Weather;
import com.github.alekseyburger.yahoo_requests.WeatherResponse;

public class WeatherThread extends Thread {
	private String city;
	
	public  WeatherThread(String city) {
		super(city);
		this.city = city;
	}
	
	public void run() {
		Geo geo = new Geo(city);
		GeoResponse gresp = geo.request();
		if (gresp == null) {
			System.out.println("Can't get geoposition for " + city);
			return;
		}
		
		List<WeatherResponse> inputList = YahooMonitor.getInputList();
		
		try {
		while(true) {
			Weather w = new Weather(gresp.query.results.place[0].woeid);
			WeatherResponse wresp =  w.request();

			if (wresp != null) {
				System.out.println(city + " : " + 
					wresp.query.results.channel.item.forecast[0].high);
				inputList.add(wresp);
			}
			sleep(1000);
		}
		} catch (InterruptedException e) {
			System.out.println("Exeption during waiting on thread " + city +
					" : " + e.toString());
		}
    }
}
