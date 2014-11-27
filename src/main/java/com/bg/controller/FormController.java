package com.bg.controller;

import com.bg.model.Recruitment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/form")
public class FormController {
	
	@ModelAttribute("guest")
	public Recruitment createGuest(){
		return new Recruitment();
	}
	
	@RequestMapping(value = "registerGuest", method=RequestMethod.GET)
	public ModelAndView index(Model model){
		return new ModelAndView("register_guest");
	}
}
