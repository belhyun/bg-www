package com.bg.filter;

import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.bg.model.Member;

@Component("memberAuthFilter")
public class MemberAuthFilter implements Filter{
	
	private static String PATH = "/bg-www";

	@SuppressWarnings("unused")
	private boolean isIndexAccess(String path){
		Pattern pattern = Pattern.compile("^[\\/\\w+\\-]+\\/index$");
		Matcher matcher = pattern.matcher(path);
		return matcher.matches();
	}
	
	private boolean isSessionValid(Object object){
		Member member = (Member) object;
		if(object != null && !member.isEmpty()){
			return true;
		}else{
			return false;
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		StringBuilder builder = new StringBuilder(PATH);
		if(session != null){
			Object object = session.getAttribute("member");
			if(isSessionValid(object)){
				httpResponse.sendRedirect(builder.append("/home").toString());
			}
		}
		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
