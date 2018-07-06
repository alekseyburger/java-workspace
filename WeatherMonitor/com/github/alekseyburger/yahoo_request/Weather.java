package com.github.alekseyburger.yahoo_request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Weather {

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
    
        try(InputStreamReader inStream = 
 		    new InputStreamReader(urlConn.getInputStream());

 	        BufferedReader buff  = new BufferedReader(inStream);){

            // get the quote as a csv string
            inpString =buff.readLine();  
            while (inpString != null) {
            // parse the csv string
           //StringTokenizer tokenizer = new StringTokenizer(csvString, ",");
           //String ticker = tokenizer.nextToken();
           //String price  = tokenizer.nextToken();
           //String tradeDate = tokenizer.nextToken();  
           //String tradeTime = tokenizer.nextToken();  

               System.out.println(inpString + "\n");
               inpString =buff.readLine();
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

/*
 {
 "query": {
  "count": 2,
  "created": "2018-07-06T20:16:35Z",
  "lang": "en-US",
  "results": {
   "channel": [
    {
     "units": {
      "distance": "mi",
      "pressure": "in",
      "speed": "mph",
      "temperature": "F"
     },
     "title": "Yahoo! Weather - Tel Aviv, Tel Aviv, IL",
     "link": "http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968212/",
     "description": "Yahoo! Weather for Tel Aviv, Tel Aviv, IL",
     "language": "en-us",
     "lastBuildDate": "Fri, 06 Jul 2018 11:16 PM IDT",
     "ttl": "60",
     "location": {
      "city": "Tel Aviv",
      "country": "Israel",
      "region": " Tel Aviv"
     },
     "wind": {
      "chill": "79",
      "direction": "203",
      "speed": "7"
     },
     "atmosphere": {
      "humidity": "89",
      "pressure": "1002.0",
      "rising": "0",
      "visibility": "16.1"
     },
     "astronomy": {
      "sunrise": "5:41 am",
      "sunset": "7:51 pm"
     },
     "image": {
      "title": "Yahoo! Weather",
      "width": "142",
      "height": "18",
      "link": "http://weather.yahoo.com",
      "url": "http://l.yimg.com/a/i/brand/purplelogo//uh/us/news-wea.gif"
     },
     "item": {
      "title": "Conditions for Tel Aviv, Tel Aviv, IL at 10:00 PM IDT",
      "lat": "32.045101",
      "long": "34.769711",
      "link": "http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968212/",
      "pubDate": "Fri, 06 Jul 2018 10:00 PM IDT",
      "condition": {
       "code": "31",
       "date": "Fri, 06 Jul 2018 10:00 PM IDT",
       "temp": "79",
       "text": "Clear"
      },
      "forecast": [
       {
        "code": "32",
        "date": "06 Jul 2018",
        "day": "Fri",
        "high": "85",
        "low": "76",
        "text": "Sunny"
       },
       {
        "code": "32",
        "date": "07 Jul 2018",
        "day": "Sat",
        "high": "86",
        "low": "76",
        "text": "Sunny"
       },
       {
        "code": "32",
        "date": "08 Jul 2018",
        "day": "Sun",
        "high": "85",
        "low": "73",
        "text": "Sunny"
       },
       {
        "code": "34",
        "date": "09 Jul 2018",
        "day": "Mon",
        "high": "84",
        "low": "74",
        "text": "Mostly Sunny"
       },
       {
        "code": "34",
        "date": "10 Jul 2018",
        "day": "Tue",
        "high": "84",
        "low": "76",
        "text": "Mostly Sunny"
       },
       {
        "code": "34",
        "date": "11 Jul 2018",
        "day": "Wed",
        "high": "83",
        "low": "77",
        "text": "Mostly Sunny"
       },
       {
        "code": "34",
        "date": "12 Jul 2018",
        "day": "Thu",
        "high": "83",
        "low": "77",
        "text": "Mostly Sunny"
       },
       {
        "code": "34",
        "date": "13 Jul 2018",
        "day": "Fri",
        "high": "83",
        "low": "77",
        "text": "Mostly Sunny"
       },
       {
        "code": "34",
        "date": "14 Jul 2018",
        "day": "Sat",
        "high": "84",
        "low": "77",
        "text": "Mostly Sunny"
       },
       {
        "code": "30",
        "date": "15 Jul 2018",
        "day": "Sun",
        "high": "84",
        "low": "78",
        "text": "Partly Cloudy"
       }
      ],
      "description": "<![CDATA[<img src=\"http://l.yimg.com/a/i/us/we/52/31.gif\"/>\n<BR />\n<b>Current Conditions:</b>\n<BR />Clear\n<BR />\n<BR />\n<b>Forecast:</b>\n<BR /> Fri - Sunny. High: 85Low: 76\n<BR /> Sat - Sunny. High: 86Low: 76\n<BR /> Sun - Sunny. High: 85Low: 73\n<BR /> Mon - Mostly Sunny. High: 84Low: 74\n<BR /> Tue - Mostly Sunny. High: 84Low: 76\n<BR />\n<BR />\n<a href=\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968212/\">Full Forecast at Yahoo! Weather</a>\n<BR />\n<BR />\n<BR />\n]]>",
      "guid": {
       "isPermaLink": "false"
      }
     }
    },
    {
     "units": {
      "distance": "mi",
      "pressure": "in",
      "speed": "mph",
      "temperature": "F"
     },
     "title": "Yahoo! Weather - Tel Aviv-Yafo, Tel Aviv, IL",
     "link": "http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968018/",
     "description": "Yahoo! Weather for Tel Aviv-Yafo, Tel Aviv, IL",
     "language": "en-us",
     "lastBuildDate": "Fri, 06 Jul 2018 11:16 PM IDT",
     "ttl": "60",
     "location": {
      "city": "Tel Aviv-Yafo",
      "country": "Israel",
      "region": " Tel Aviv"
     },
     "wind": {
      "chill": "79",
      "direction": "203",
      "speed": "7"
     },
     "atmosphere": {
      "humidity": "89",
      "pressure": "1002.0",
      "rising": "0",
      "visibility": "16.1"
     },
     "astronomy": {
      "sunrise": "5:41 am",
      "sunset": "7:51 pm"
     },
     "image": {
      "title": "Yahoo! Weather",
      "width": "142",
      "height": "18",
      "link": "http://weather.yahoo.com",
      "url": "http://l.yimg.com/a/i/brand/purplelogo//uh/us/news-wea.gif"
     },
     "item": {
      "title": "Conditions for Tel Aviv-Yafo, Tel Aviv, IL at 10:00 PM IDT",
      "lat": "32.067799",
      "long": "34.764702",
      "link": "http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968018/",
      "pubDate": "Fri, 06 Jul 2018 10:00 PM IDT",
      "condition": {
       "code": "31",
       "date": "Fri, 06 Jul 2018 10:00 PM IDT",
       "temp": "79",
       "text": "Clear"
      },
      "forecast": [
       {
        "code": "32",
        "date": "06 Jul 2018",
        "day": "Fri",
        "high": "85",
        "low": "76",
        "text": "Sunny"
       },
       {
        "code": "32",
        "date": "07 Jul 2018",
        "day": "Sat",
        "high": "86",
        "low": "76",
        "text": "Sunny"
       },
       {
        "code": "32",
        "date": "08 Jul 2018",
        "day": "Sun",
        "high": "85",
        "low": "73",
        "text": "Sunny"
       },
       {
        "code": "34",
        "date": "09 Jul 2018",
        "day": "Mon",
        "high": "84",
        "low": "74",
        "text": "Mostly Sunny"
       },
       {
        "code": "34",
        "date": "10 Jul 2018",
        "day": "Tue",
        "high": "84",
        "low": "76",
        "text": "Mostly Sunny"
       },
       {
        "code": "34",
        "date": "11 Jul 2018",
        "day": "Wed",
        "high": "83",
        "low": "77",
        "text": "Mostly Sunny"
       },
       {
        "code": "34",
        "date": "12 Jul 2018",
        "day": "Thu",
        "high": "83",
        "low": "77",
        "text": "Mostly Sunny"
       },
       {
        "code": "34",
        "date": "13 Jul 2018",
        "day": "Fri",
        "high": "83",
        "low": "77",
        "text": "Mostly Sunny"
       },
       {
        "code": "34",
        "date": "14 Jul 2018",
        "day": "Sat",
        "high": "84",
        "low": "77",
        "text": "Mostly Sunny"
       },
       {
        "code": "30",
        "date": "15 Jul 2018",
        "day": "Sun",
        "high": "84",
        "low": "78",
        "text": "Partly Cloudy"
       }
      ],
      "description": "<![CDATA[<img src=\"http://l.yimg.com/a/i/us/we/52/31.gif\"/>\n<BR />\n<b>Current Conditions:</b>\n<BR />Clear\n<BR />\n<BR />\n<b>Forecast:</b>\n<BR /> Fri - Sunny. High: 85Low: 76\n<BR /> Sat - Sunny. High: 86Low: 76\n<BR /> Sun - Sunny. High: 85Low: 73\n<BR /> Mon - Mostly Sunny. High: 84Low: 74\n<BR /> Tue - Mostly Sunny. High: 84Low: 76\n<BR />\n<BR />\n<a href=\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-1968018/\">Full Forecast at Yahoo! Weather</a>\n<BR />\n<BR />\n<BR />\n]]>",
      "guid": {
       "isPermaLink": "false"
      }
     }
    }
   ]
  }
 }
}
 */
