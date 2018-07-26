package com.github.alekseyburger.yahoo_requests;

//import static org.junit.Assert.*;

import org.junit.Test;

public class GeoUTest {

	@Test
	public void test() {
		Geo gta = new Geo("Tel Aviv","Israel");
		GeoResponse rsp = gta.request();
		rsp.Debug();
		Geo gl = new Geo("London");
		rsp = gl.request();
		rsp.Debug();
		Geo gsp = new Geo("Sankt Peterburg");
		rsp = gsp.request();
		rsp.Debug();
	}

}
