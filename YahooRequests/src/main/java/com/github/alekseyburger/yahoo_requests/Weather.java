package com.github.alekseyburger.yahoo_requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class WeatherResponse {
	class Query {
		public Integer count;
		public String  created;
		public String  lang;
	}
	
	private Query query;
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
		                 "link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968212/","description":"Yahoo! Weather for Tel Aviv, Tel Aviv, IL","language":"en-us","lastBuildDate":"Tue, 17 Jul 2018 08:00 PM IDT","ttl":"60","location":{"city":"Tel Aviv","country":"Israel","region":" Tel Aviv"},"wind":{"chill":"82","direction":"315","speed":"7"},"atmosphere":{"humidity":"70","pressure":"1002.0","rising":"0","visibility":"16.1"},"astronomy":{"sunrise":"5:47 am","sunset":"7:47 pm"},"image":{"title":"Yahoo! Weather","width":"142","height":"18","link":"http://weather.yahoo.com","url":"http://l.yimg.com/a/i/brand/purplelogo//uh/us/news-wea.gif"},"item":{"title":"Conditions for Tel Aviv, Tel Aviv, IL at 07:00 PM IDT","lat":"32.045101","long":"34.769711","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968212/","pubDate":"Tue, 17 Jul 2018 07:00 PM IDT","condition":{"code":"32","date":"Tue, 17 Jul 2018 07:00 PM IDT","temp":"82","text":"Sunny"},"forecast":[{"code":"34","date":"17 Jul 2018","day":"Tue","high":"84","low":"78","text":"Mostly Sunny"},{"code":"32","date":"18 Jul 2018","day":"Wed","high":"85","low":"74","text":"Sunny"},{"code":"34","date":"19 Jul 2018","day":"Thu","high":"85","low":"76","text":"Mostly Sunny"},{"code":"34","date":"20 Jul 2018","day":"Fri","high":"85","low":"78","text":"Mostly Sunny"},{"code":"34","date":"21 Jul 2018","day":"Sat","high":"85","low":"78","text":"Mostly Sunny"},{"code":"34","date":"22 Jul 2018","day":"Sun","high":"85","low":"78","text":"Mostly Sunny"},{"code":"34","date":"23 Jul 2018","day":"Mon","high":"85","low":"78","text":"Mostly Sunny"},{"code":"34","date":"24 Jul 2018","day":"Tue","high":"86","low":"79","text":"Mostly Sunny"},{"code":"32","date":"25 Jul 2018","day":"Wed","high":"89","low":"76","text":"Sunny"},{"code":"32","date":"26 Jul 2018","day":"Thu","high":"87","low":"79","text":"Sunny"}],"description":"<![CDATA[<img src=\"http://l.yimg.com/a/i/us/we/52/32.gif\"/>\n<BR />\n<b>Current Conditions:</b>\n<BR />Sunny\n<BR />\n<BR />\n<b>Forecast:</b>\n<BR /> Tue - Mostly Sunny. High: 84Low: 78\n<BR /> Wed - Sunny. High: 85Low: 74\n<BR /> Thu - Mostly Sunny. High: 85Low: 76\n<BR /> Fri - Mostly Sunny. High: 85Low: 78\n<BR /> Sat - Mostly Sunny. High: 85Low: 78\n<BR />\n<BR />\n<a href=\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968212/\">Full Forecast at Yahoo! Weather</a>\n<BR />\n<BR />\n<BR />\n]]>","guid":{"isPermaLink":"false"}}},{"units":{"distance":"mi","pressure":"in","speed":"mph","temperature":"F"},"title":"Yahoo! Weather - Tel Aviv-Yafo, Tel Aviv, IL","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968018/","description":"Yahoo! Weather for Tel Aviv-Yafo, Tel Aviv, IL","language":"en-us","lastBuildDate":"Tue, 17 Jul 2018 08:00 PM IDT","ttl":"60","location":{"city":"Tel Aviv-Yafo","country":"Israel","region":" Tel Aviv"},"wind":{"chill":"82","direction":"315","speed":"7"},"atmosphere":{"humidity":"70","pressure":"1002.0","rising":"0","visibility":"16.1"},"astronomy":{"sunrise":"5:47 am","sunset":"7:47 pm"},"image":{"title":"Yahoo! Weather","width":"142","height":"18","link":"http://weather.yahoo.com","url":"http://l.yimg.com/a/i/brand/purplelogo//uh/us/news-wea.gif"},"item":{"title":"Conditions for Tel Aviv-Yafo, Tel Aviv, IL at 07:00 PM IDT","lat":"32.067799","long":"34.764702","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968018/","pubDate":"Tue, 17 Jul 2018 07:00 PM IDT","condition":{"code":"32","date":"Tue, 17 Jul 2018 07:00 PM IDT","temp":"82","text":"Sunny"},"forecast":[{"code":"34","date":"17 Jul 2018","day":"Tue","high":"84","low":"78","text":"Mostly Sunny"},{"code":"32","date":"18 Jul 2018","day":"Wed","high":"85","low":"74","text":"Sunny"},{"code":"34","date":"19 Jul 2018","day":"Thu","high":"85","low":"76","text":"Mostly Sunny"},{"code":"34","date":"20 Jul 2018","day":"Fri","high":"85","low":"78","text":"Mostly Sunny"},{"code":"34","date":"21 Jul 2018","day":"Sat","high":"85","low":"78","text":"Mostly Sunny"},{"code":"34","date":"22 Jul 2018","day":"Sun","high":"85","low":"78","text":"Mostly Sunny"},{"code":"34","date":"23 Jul 2018","day":"Mon","high":"85","low":"78","text":"Mostly Sunny"},{"code":"34","date":"24 Jul 2018","day":"Tue","high":"86","low":"79","text":"Mostly Sunny"},{"code":"32","date":"25 Jul 2018","day":"Wed","high":"89","low":"76","text":"Sunny"},{"code":"32","date":"26 Jul 2018","day":"Thu","high":"87","low":"79","text":"Sunny"}],"description":"<![CDATA[<img src=\"http://l.yimg.com/a/i/us/we/52/32.gif\"/>\n<BR />\n<b>Current Conditions:</b>\n<BR />Sunny\n<BR />\n<BR />\n<b>Forecast:</b>\n<BR /> Tue - Mostly Sunny. High: 84Low: 78\n<BR /> Wed - Sunny. High: 85Low: 74\n<BR /> Thu - Mostly Sunny. High: 85Low: 76\n<BR /> Fri - Mostly Sunny. High: 85Low: 78\n<BR /> Sat - Mostly Sunny. High: 85Low: 78\n<BR />\n<BR />\n<a href=\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968018/\">Full Forecast at Yahoo! Weather</a>\n<BR />\n<BR />\n<BR />\n]]>","guid":{"isPermaLink":"false"}}}]}}}*/
    void Debug() {
    	System.out.println("count: " + query.count);
    	System.out.println("created: " + query.created);
    	System.out.println("lang: " + query.lang);
    }
}
public class Weather {
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	
	public void request() {

	    String inpString;
        URL url = null;
        URLConnection urlConn = null;
        //select * from weather.forecast where woeid in (select woeid from geo.places where text="Tel Aviv, Israel")
        try{
            url  = new              
            URL("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places%20where%20text%3D%22Tel%20Aviv%2C%20Israel%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys" );
            //URL("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places%20where%20text%3D%22Israel%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys" );

            urlConn = url.openConnection();
        } catch(IOException ioe){
 	        ioe.printStackTrace();
        }
    
        try(
        	InputStreamReader inStream =   new InputStreamReader(urlConn.getInputStream());
 	        BufferedReader buff  = new BufferedReader(inStream);)
        {

            // get the quote as a csv string
            inpString = buff.readLine();  
            while (inpString != null) {
            // parse the csv string
           //StringTokenizer tokenizer = new StringTokenizer(csvString, ",");
           //String ticker = tokenizer.nextToken();
           //String price  = tokenizer.nextToken();
           //String tradeDate = tokenizer.nextToken();  
           //String tradeTime = tokenizer.nextToken();  
               //WeatherResponse  resp = GSON.fromJson("{\"query\":\"test\"}", WeatherResponse.class);
               WeatherResponse  resp = GSON.fromJson(inpString, WeatherResponse.class);
               resp.Debug();

               //System.out.println(inpString + "\n");
               inpString = buff.readLine();
            }
       } catch(MalformedURLException e){
           System.out.println("Please check the spelling of " 
                           + "the URL: " + e.toString() );
       } catch(IOException  e1){
           System.out.println("Can't read from the Internet: " + 
                                        e1.toString() ); 
       }
    }
}
