package com.bg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bg.model.Member;
import com.bg.service.MemberService;

@Controller
@SessionAttributes("member")
public class IndexController {
	
	@ModelAttribute("member")
	public Member createMember(Member member, SessionStatus status){
		if(member.isEmpty()){
			status.setComplete();
			return new Member();
		}else{
			return member;
		}
	}
	
	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public ModelAndView index(Model model){
		return new ModelAndView("/index");
	}
	
	@RequestMapping(value = "/signup", method=RequestMethod.POST)
	public ModelAndView signup(Model model){
		return new ModelAndView("/home");
	}
	
	@RequestMapping(value = "/signin", method=RequestMethod.POST)
	public ModelAndView signin(Model model){
		return new ModelAndView("/home");
	}
}
