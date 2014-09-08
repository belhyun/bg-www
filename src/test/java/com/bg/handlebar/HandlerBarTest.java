package com.bg.handlebar;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/spring/config/servlet-context.xml")
public class HandlerBarTest {
	
	@Test
	public void 기본출력() throws IOException{
		Handlebars handlebars = new Handlebars();
		Template template = handlebars.compileInline("Hello {{this}}!");
		Assert.assertEquals(template.apply("Handlebars.java"), "Hello Handlebars.java!");
	}
}
