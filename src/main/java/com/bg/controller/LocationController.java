package com.bg.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bg.model.LocationDetail;
import com.bg.service.LocationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = "search", method=RequestMethod.POST)
	public @ResponseBody String search(Model model, @RequestParam(value="query",required=true,defaultValue="") String query,
			HttpServletResponse response) throws JsonProcessingException{
		List<LocationDetail> locationDetailResults = locationService.getLocationDetailByUsingGoogleLocationSearchApi(query);
		ObjectMapper mapper = new ObjectMapper();
		response.setHeader("content-type", "application/json");
		return mapper.writeValueAsString(locationDetailResults);
	}
}
