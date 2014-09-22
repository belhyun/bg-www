package com.bg.service;

import java.util.List;
import java.util.Map;

import com.bg.model.LocationDetail;

abstract public class LocationService {
	public abstract List<LocationDetail> getLocationDetailByUsingGoogleLocationSearchApi(String query);
	
	protected String getGoogleSearchUrl(){
		return "https://maps.googleapis.com/maps/api/place/textsearch/json?query={query}&sensor={sensor}&key={key}";
	}
	
	protected String getApiKey(){
		return "AIzaSyCT0fF-XHih9IP0Eyp11DsOnjNQp_CLY0Y";
	}
}
