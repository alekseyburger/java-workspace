package com.github.alekseyburger.yahoo_requests;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeatherUTest {

	@Test
	public void test() {
		Weather w = new Weather();
		w.request();
	}

}
