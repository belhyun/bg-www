package com.bg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bg.model.Guest;

@Controller
@RequestMapping("/form")
public class FormController {
	
	@ModelAttribute("guest")
	public Guest createGuest(){
		return new Guest();
	}
	
	@RequestMapping(value = "registerGuest", method=RequestMethod.GET)
	public ModelAndView index(Model model){
		return new ModelAndView("register_guest");
	}
}
