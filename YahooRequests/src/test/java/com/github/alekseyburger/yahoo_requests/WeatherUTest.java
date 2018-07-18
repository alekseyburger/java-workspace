package com.github.alekseyburger.yahoo_requests;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeatherUTest {

	@Test
	public void test() {
		Geo gta = new Geo("Tel Aviv","Israel");
		GeoResponse rsp = gta.request();
		
		if (rsp!=null) {
		    Weather w = new Weather(rsp.query.results.place[0].woeid);
		    WeatherResponse resp = w.request();
		    System.out.println("\nOK: " + resp.query.created);
		    resp.Debug();
		}
	}

}
