package com.github.alekseyburger.yahoo_requests;


public class WeatherBundleResponse {
	class Units {
		public String distance;
		public String pressure;
		public String speed;
		public String temperature;
	}
	
    class Location {
    	public String city;
        public String country;
    	public String region;
    }
    
    class Wind {
    	public Integer chill;
    	public Integer direction;
    	public Integer speed;
    }
    
    class Atmosphere {
    	public Integer humidity;
    	public float pressure;
    	public Integer rising;
    	public Float visibility;
    }
    
    class Astronomy {
    	public String sunrise;
    	public String sunset;
    }
    class Image {
    	public String title;
    	public Integer width;
    	public Integer height;
    	public String link;
    }
    
    class Condition {
    	public Integer code;
    	public String date;
    	public Integer temp;
    	public String text;
    }
    
    class Guid {
    	public boolean isPermaLink;
    }
    
    class Forecast {
    	public Integer code;
    	public String date;
    	public String day;
    	public Integer high;
    	public Integer low;
    	public String text;
    }
    
    class Item {
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
    		
	class Channel {
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
	
	class Results {
		public Channel channel[];
	}
	
	class Query {
		public Integer count;
		public String  created;
		public String  lang;
		public Results results;
	}
	
	public Query query;
	
	/*{"query":{
		"count":2,
		"created":"2018-07-17T17:00:18Z",
		"lang":"en-US",
		"results":{
		     "channel":[
		                {"units":
		                    {"distance":"mi",
		                	"pressure":"in",
		                	"speed":"mph",
		                	"temperature":"F"},
		                 "title":"Yahoo! Weather - Tel Aviv, Tel Aviv, IL",
		                 "link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968212/",
		                 "description":"Yahoo! Weather for Tel Aviv, Tel Aviv, IL",
		                 "language":"en-us",
		                 "lastBuildDate":"Tue, 17 Jul 2018 08:00 PM IDT",
		                 "ttl":"60",
		                 "location":{"city":"Tel Aviv","country":"Israel","region":" Tel Aviv"},
		                 "wind":{"chill":"82","direction":"315","speed":"7"},
		                 "atmosphere":{"humidity":"70","pressure":"1002.0","rising":"0","visibility":"16.1"},
		                 "astronomy":{"sunrise":"5:47 am","sunset":"7:47 pm"},
		                 "image":{"title":"Yahoo! Weather","width":"142","height":"18","link":"http://weather.yahoo.com","url":"http://l.yimg.com/a/i/brand/purplelogo//uh/us/news-wea.gif"},
		                 "item":{"title":"Conditions for Tel Aviv, Tel Aviv, IL at 07:00 PM IDT",
		                         "lat":"32.045101",
		                         "long":"34.769711",
		                         "link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968212/",
		                         "pubDate":"Tue, 17 Jul 2018 07:00 PM IDT",
		                         "condition":{"code":"32","date":"Tue, 17 Jul 2018 07:00 PM IDT","temp":"82","text":"Sunny"},
		                         "forecast":[
		                              {"code":"34","date":"17 Jul 2018","day":"Tue","high":"84","low":"78","text":"Mostly Sunny"},
		                              {"code":"32","date":"18 Jul 2018","day":"Wed","high":"85","low":"74","text":"Sunny"},
		                              {"code":"34","date":"19 Jul 2018","day":"Thu","high":"85","low":"76","text":"Mostly Sunny"},
		                              {"code":"34","date":"20 Jul 2018","day":"Fri","high":"85","low":"78","text":"Mostly Sunny"},
		                              {"code":"34","date":"21 Jul 2018","day":"Sat","high":"85","low":"78","text":"Mostly Sunny"},
		                              {"code":"34","date":"22 Jul 2018","day":"Sun","high":"85","low":"78","text":"Mostly Sunny"},
		                              {"code":"34","date":"23 Jul 2018","day":"Mon","high":"85","low":"78","text":"Mostly Sunny"},
		                              {"code":"34","date":"24 Jul 2018","day":"Tue","high":"86","low":"79","text":"Mostly Sunny"},
		                              {"code":"32","date":"25 Jul 2018","day":"Wed","high":"89","low":"76","text":"Sunny"},
		                              {"code":"32","date":"26 Jul 2018","day":"Thu","high":"87","low":"79","text":"Sunny"}],
		                         "description":"<![CDATA[<img src=\"http://l.yimg.com/a/i/us/we/52/32.gif\"/>\n<BR />\n<b>Current Conditions:</b>\n<BR />Sunny\n<BR />\n<BR />\n<b>Forecast:</b>\n<BR /> Tue - Mostly Sunny. High: 84Low: 78\n<BR /> Wed - Sunny. High: 85Low: 74\n<BR /> Thu - Mostly Sunny. High: 85Low: 76\n<BR /> Fri - Mostly Sunny. High: 85Low: 78\n<BR /> Sat - Mostly Sunny. High: 85Low: 78\n<BR />\n<BR />\n<a href=\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968212/\">Full Forecast at Yahoo! Weather</a>\n<BR />\n<BR />\n<BR />\n]]>",
		                         "guid":{"isPermaLink":"false"}
		                         }
		                   },
		                   {"units":{"distance":"mi","pressure":"in","speed":"mph","temperature":"F"},"title":"Yahoo! Weather - Tel Aviv-Yafo, Tel Aviv, IL","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968018/","description":"Yahoo! Weather for Tel Aviv-Yafo, Tel Aviv, IL","language":"en-us","lastBuildDate":"Tue, 17 Jul 2018 08:00 PM IDT","ttl":"60","location":{"city":"Tel Aviv-Yafo","country":"Israel","region":" Tel Aviv"},"wind":{"chill":"82","direction":"315","speed":"7"},"atmosphere":{"humidity":"70","pressure":"1002.0","rising":"0","visibility":"16.1"},"astronomy":{"sunrise":"5:47 am","sunset":"7:47 pm"},"image":{"title":"Yahoo! Weather","width":"142","height":"18","link":"http://weather.yahoo.com","url":"http://l.yimg.com/a/i/brand/purplelogo//uh/us/news-wea.gif"},"item":{"title":"Conditions for Tel Aviv-Yafo, Tel Aviv, IL at 07:00 PM IDT","lat":"32.067799","long":"34.764702","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968018/","pubDate":"Tue, 17 Jul 2018 07:00 PM IDT","condition":{"code":"32","date":"Tue, 17 Jul 2018 07:00 PM IDT","temp":"82","text":"Sunny"},"forecast":[{"code":"34","date":"17 Jul 2018","day":"Tue","high":"84","low":"78","text":"Mostly Sunny"},{"code":"32","date":"18 Jul 2018","day":"Wed","high":"85","low":"74","text":"Sunny"},{"code":"34","date":"19 Jul 2018","day":"Thu","high":"85","low":"76","text":"Mostly Sunny"},{"code":"34","date":"20 Jul 2018","day":"Fri","high":"85","low":"78","text":"Mostly Sunny"},{"code":"34","date":"21 Jul 2018","day":"Sat","high":"85","low":"78","text":"Mostly Sunny"},{"code":"34","date":"22 Jul 2018","day":"Sun","high":"85","low":"78","text":"Mostly Sunny"},{"code":"34","date":"23 Jul 2018","day":"Mon","high":"85","low":"78","text":"Mostly Sunny"},{"code":"34","date":"24 Jul 2018","day":"Tue","high":"86","low":"79","text":"Mostly Sunny"},{"code":"32","date":"25 Jul 2018","day":"Wed","high":"89","low":"76","text":"Sunny"},{"code":"32","date":"26 Jul 2018","day":"Thu","high":"87","low":"79","text":"Sunny"}],"description":"<![CDATA[<img src=\"http://l.yimg.com/a/i/us/we/52/32.gif\"/>\n<BR />\n<b>Current Conditions:</b>\n<BR />Sunny\n<BR />\n<BR />\n<b>Forecast:</b>\n<BR /> Tue - Mostly Sunny. High: 84Low: 78\n<BR /> Wed - Sunny. High: 85Low: 74\n<BR /> Thu - Mostly Sunny. High: 85Low: 76\n<BR /> Fri - Mostly Sunny. High: 85Low: 78\n<BR /> Sat - Mostly Sunny. High: 85Low: 78\n<BR />\n<BR />\n<a href=\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968018/\">Full Forecast at Yahoo! Weather</a>\n<BR />\n<BR />\n<BR />\n]]>","guid":{"isPermaLink":"false"}}}
		                   ]}}}*/
    public void Debug() {
    	System.out.println("count: " + query.count);
    	System.out.println("created: " + query.created);
    	System.out.println("lang: " + query.lang);
    	System.out.println("Title: " + query.results.channel[0].title);
    	System.out.println("Description: " + query.results.channel[0].item.description );
    	System.out.println("Guig: " + query.results.channel[0].item.guid.isPermaLink);
    	System.out.println("Forecast: code: " + query.results.channel[0].item.forecast[0].code
    			                      + " date: " + query.results.channel[0].item.forecast[0].date
    			                      + " day: " + query.results.channel[0].item.forecast[0].day
    			                      + " high: " + query.results.channel[0].item.forecast[0].high
    			                      + " low: " + query.results.channel[0].item.forecast[0].low
    			                      + " text: " + query.results.channel[0].item.forecast[0].text);
    }
}
