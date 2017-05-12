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
		return "/home/indexPage";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "/loginPage";
	}
	
	@RequestMapping("/login-error")
	public String loginError(Model model)
	{
		model.addAttribute("loginError", true);
	    return "/loginPage";
	}
	@RequestMapping("/access-denied")
	public String accessDenied()
	{
		return "accesDeniedPage";
	}
}
