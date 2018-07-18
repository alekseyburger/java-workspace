package com.github.alekseyburger.yahoo_requests;

public class WeatherResponse {

	public class Units {
		public String distance;
		public String pressure;
		public String speed;
		public String temperature;
	}
	
	public class Location {
    	public String city;
        public String country;
    	public String region;
    }
    
	public class Wind {
    	public Integer chill;
    	public Integer direction;
    	public Integer speed;
    }
    
	public class Atmosphere {
    	public Integer humidity;
    	public float pressure;
    	public Integer rising;
    	public Float visibility;
    }
    
	public class Astronomy {
    	public String sunrise;
    	public String sunset;
    }
	
	public class Image {
    	public String title;
    	public Integer width;
    	public Integer height;
    	public String link;
    }
    
	public class Condition {
    	public Integer code;
    	public String date;
    	public Integer temp;
    	public String text;
    }
    
	public class Guid {
    	public boolean isPermaLink;
    }
    
	public class Forecast {
    	public Integer code;
    	public String date;
    	public String day;
    	public Integer high;
    	public Integer low;
    	public String text;
    }
    
    public class Item {
    	public String title;
    	public Float lat;
    	public Float Long;
    	public String link;
    	public String pubDate;
    	public Condition condition;
    	public String description;
    	public Guid guid;
		public Forecast forecast[];
    }
    		
    public class Channel {
		public Units units;
		public String title;
		public String link;
		public String description;
		public String language;
		public String lastBuildDate;
		public Integer ttl;
        public Location location;
        public Wind wind;
        public Atmosphere atmosphere;
        public Astronomy astronomy;
        public Image image;
        public Item item;

	}
	
    public class Results {
		public Channel channel;
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
    	System.out.println("Title: " + query.results.channel.title);
    	System.out.println("Description: " + query.results.channel.item.description );
    	System.out.println("Guig: " + query.results.channel.item.guid.isPermaLink);
    	System.out.println("Forecast: code: " + query.results.channel.item.forecast[0].code
    			                      + " date: " + query.results.channel.item.forecast[0].date
    			                      + " day: " + query.results.channel.item.forecast[0].day
    			                      + " high: " + query.results.channel.item.forecast[0].high
    			                      + " low: " + query.results.channel.item.forecast[0].low
    			                      + " text: " + query.results.channel.item.forecast[0].text);
    }
}
