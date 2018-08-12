package com.github.alekseyburger.yahoo_requests;


public class GeoResponse {
	
	public class Place {
		public Integer woeid;
	}
	
	public class Results {
		public Place place[];
	}
	
	public class Query {
		public Integer count;
		public String  created;
		public String  lang;
		public Results results;
	}
	
	public Query query;
	
	public void Debug() {
		
    	System.out.println("count: " + query.count);
    	System.out.println("created: " + query.created);
    	System.out.println("lang: " + query.lang);
    	System.out.println("Woeid: " + query.results.place[0].woeid);
	}
}