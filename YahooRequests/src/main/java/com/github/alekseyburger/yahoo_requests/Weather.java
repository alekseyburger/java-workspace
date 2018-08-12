package com.github.alekseyburger.yahoo_requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Weather {
	
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private String link = null;
	
	public Weather(int geo) {
        // Build geo-position string. convert non-alfa-digit to %hex save result as element
        String geo_list = new UrlString("(" + Integer.toString(geo) + ")").get();
        
        // construct the url with request
        link = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20" +
        		geo_list + "&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
	}
	
	public WeatherResponse request() {
		
		// launch the request
	    String inpString = null;
        URL url = null;
        URLConnection urlConn = null;
        
        for (boolean retry=true; retry; ) {
        	try{
        		url  = new URL(link);
        		urlConn = url.openConnection();

        	} catch(IOException ioe){

        		System.out.println("Can't create connection :" + ioe.toString());
        		ioe.printStackTrace();

        		// wait 5 sec and repeat
        		try {Thread.sleep(5000); } catch(InterruptedException e) { return null;	}
        	}
        
        	try (
        		InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        		BufferedReader buff = new BufferedReader(inStream);)
        	{
            	// get the response from the Yahoo
            	inpString = buff.readLine();  
            	retry=false;
            	
        	} catch(MalformedURLException e){
        		System.out.println("Please check the spelling of " 
                           + "the URL: " + e.toString() );
        		retry=false;
        	} catch(IOException  e1){
        		System.out.println("Can't read from the Internet: " + 
                                        e1.toString() );
        		// wait 5 sec and repeat
        		try { Thread.sleep(5000); } catch(InterruptedException e) { return null;	}
        	}
        }

       // if it got the information - parse Json
       if (inpString != null) {
           WeatherResponse  resp = GSON.fromJson(inpString, WeatherResponse.class);
           return resp;
       } else {
    	   return null;
       }
    }
}

