package com.bg.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.bg.model.Location;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/spring/config/servlet-context.xml")
public class FormControllerTest {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Test
	public void 구글맵API에_장소정보_요청하기_성공(){
		String searchQuery = "신림고등학교";
		
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("query",searchQuery);
		vars.put("sensor", "false");
		vars.put("key",getApiKey());
		Location location = restTemplate.getForObject(getGoogleSearchUrl(), Location.class, vars);
		
		Assert.assertEquals(location.getStatus(), "OK");
		Assert.assertTrue(location.getResults().size() > 0);
		Assert.assertTrue(location.getResults().get(0).getName().equals("신림고등학교"));
	}
	
	private String getGoogleSearchUrl(){
		return "https://maps.googleapis.com/maps/api/place/textsearch/json?query={query}&sensor={sensor}&key={key}";
	}
	
	private String getApiKey(){
		return "AIzaSyCd8g41gqlpEGM2lchBKI_1mcH2MYqcXPY";
	}
}
