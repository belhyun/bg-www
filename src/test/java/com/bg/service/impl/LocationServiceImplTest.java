package com.bg.service.impl;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bg.service.LocationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/spring/config/servlet-context.xml")
public class LocationServiceImplTest {
	
	@Autowired
	private LocationService locationService;
	
	@Test
	public void 구글맵API에_장소정보가_있을경우() throws JsonGenerationException, JsonMappingException, IOException{
		Assert.assertTrue(locationService.getLocationDetailByUsingGoogleLocationSearchApi("신림고등학교").size() > 1);
	}
	
	@Test
	public void 구글맵API에_장소정보가_없을경우(){
		Assert.assertNotNull(locationService.getLocationDetailByUsingGoogleLocationSearchApi(""));
	}
	
	@Test
	public void 위치상세정보_정상출력(){
		
	}
}
