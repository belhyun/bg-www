package com.bg.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bg.model.Location;
import com.bg.model.LocationDetail;
import com.bg.service.LocationService;
import com.google.common.collect.Lists;

@Component
@Service
public class LocationServiceImpl extends LocationService{

	@Autowired
	private RestTemplate restTemplate;
	
	private Map<String, String> params;
	
	private Location locations;
	
	public LocationServiceImpl() {
		// TODO Auto-generated constructor stub
		super();
		params = new HashMap<String, String>();
		params.put("sensor", "false");
		params.put("key", getApiKey()); 
	}
	
	@Override
	public List<LocationDetail> getLocationDetailByUsingGoogleLocationSearchApi(String query) {
		// TODO Auto-generated method stub
		params.put("query", query);
		locations = restTemplate.getForObject(getGoogleSearchUrl(), Location.class, params);
		if(locations.getStatus().equals("OK") && hasResults()){
			return locations.getResults();
		}
		return Lists.newArrayList();
	}
	
	private boolean hasResults(){
		return locations.getResults().size() > 0 ? true : false;
	}
}
