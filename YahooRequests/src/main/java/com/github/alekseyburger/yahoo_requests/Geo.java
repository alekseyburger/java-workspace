package com.github.alekseyburger.yahoo_requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Geo {
	private String city;
	private String country;
	private String link = null;
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	
	private void buildUrl() {
		
        // Join city name and country if defined
        String place_for_request = city;
        if (country != null) {
        	place_for_request += "," + country;
        }
        // Convert non-alfa-digit to %hex 
        String plase_ustr = new UrlString(place_for_request).get();
        
        // build link url
        link = "https://query.yahooapis.com/v1/public/yql?q=select%20woeid%20from%20geo.places%20where%20text%3D%22" + 
        		plase_ustr + "%22&format=json";
	}
	
	public Geo(String icity) {
		city = icity;
		buildUrl();
	}
	
	public Geo(String icity, String icountry) {
		
		city = icity;
		country = icountry;
		buildUrl();
	}
	
	public GeoResponse request() {

        URL url = null;
        URLConnection urlConn = null;
	    String inpString = null;
	    
        for (boolean retry=true; retry; ) {
        	try{
        		url  = new URL(link);              
        		urlConn = url.openConnection();
   
        	} catch(IOException ioe){
        		
        		System.out.println("Can't get url:" + link);
        		System.out.println("Can't create connection :" + ioe.toString());
        		ioe.printStackTrace();
        		
        		// wait 5 sec and repeat
        		try {Thread.sleep(5000); } catch(InterruptedException e) { return null;	}
        	}

        	try(
        			InputStreamReader inStream =   new InputStreamReader(urlConn.getInputStream());
        			BufferedReader buff  = new BufferedReader(inStream);)
        	{
        		// read the response
            	inpString = buff.readLine();
            	retry=false;
            
        	} catch(MalformedURLException e){
        		System.out.println("Please check the spelling of " 
        		   + "the URL: " + e.toString() );
        		return null;
        	} catch(IOException  e1){
        		System.out.println("Can't read from the Internet: " + 
                                        e1.toString() );
        		// wait 5 sec and repeat
        		try {Thread.sleep(5000); } catch(InterruptedException e) { return null;	}
        	}
        }
              
        // parse Json if it got the response 
        if (inpString != null) {
           GeoResponse  resp = GSON.fromJson(inpString, GeoResponse.class);
           return resp;
        } else {
    	   return null;
        }
    }
}
