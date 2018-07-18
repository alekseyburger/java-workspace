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
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	
	public Geo(String icity) {
		city = icity;
	}
	
	public Geo(String icity, String icountry) {
		city = icity;
		country = icountry;
	}
	
	public GeoResponse request() {

	    String inpString = null;
        URL url = null;
        URLConnection urlConn = null;
        
        // Join city name and country if defined
        String place_for_request = city;
        if (country != null) {
        	place_for_request += "," + country;
        }
        // Convert non-alfa-digit to %hex 
        UrlString u = new UrlString(place_for_request);
        place_for_request = u.get();
        
        // build link url
        String link = "https://query.yahooapis.com/v1/public/yql?q=select%20woeid%20from%20geo.places%20where%20text%3D%22" + 
                     place_for_request + "%22&format=json";

        try{
            url  = new URL(link);              
            urlConn = url.openConnection();
        } catch(IOException ioe){
 	        ioe.printStackTrace();
        }
    
        try(
        	InputStreamReader inStream =   new InputStreamReader(urlConn.getInputStream());
 	        BufferedReader buff  = new BufferedReader(inStream);)
        {
            // read the response
            inpString = buff.readLine();
            
       } catch(MalformedURLException e){
           System.out.println("Please check the spelling of " 
                           + "the URL: " + e.toString() );
       } catch(IOException  e1){
           System.out.println("Can't read from the Internet: " + 
                                        e1.toString() ); 
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
