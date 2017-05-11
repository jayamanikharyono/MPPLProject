package com.mppl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	@RequestMapping(value="/")
	public String home()
	{
		return "home/index";
	}
	
	@RequestMapping("/login.html")
	public String login()
	{
		return "/login";
	}
	
	@RequestMapping("/login-error.html")
	public String loginError(Model model)
	{
		model.addAttribute("loginError", true);
	    return "/login";
	}
}
