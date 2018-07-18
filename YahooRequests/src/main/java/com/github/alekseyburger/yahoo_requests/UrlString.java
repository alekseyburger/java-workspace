package com.github.alekseyburger.yahoo_requests;

public final class UrlString {
    private String underlyingString;

    public UrlString(String str) {
    	char[] strChars = str.toCharArray();
    	int    length = str.length();
    	this.underlyingString = "";
    	for(int i = 0; i < length; i++){
    		if (strChars[i] < '1') {
                this.underlyingString += "%" + Integer.toHexString(strChars[i]);
    		} else {
    			this.underlyingString += strChars[i];
    		}
    	}
    }        

    public String get() {
    	return underlyingString;
    }
}