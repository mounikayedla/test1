package com.example;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//need a controller method to show initial html form
	
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
	}
		
	//need a controller method to process the html form
	
	@RequestMapping("processForm")
	public String processForm()
	{
		return "helloworld";
	}
	
	//need a controller method to read form data and add data to the model
	@RequestMapping("processFormVersionTwo")
	public String letsShout(HttpServletRequest request, Model model)
	{
		//read the request parameter from the html form
		String name = request.getParameter("studentName");
		
		//convert data to all caps
		name = name.toUpperCase();
		
		//create the message
		String result = "Yo! "+name;
		
		//add msg to the model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	@RequestMapping("processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName")String name, Model model)
	{
	
		//convert data to all caps
		name = name.toUpperCase();
		
		//create the message
		String result = "Hey my friend "+name;
		
		//add msg to the model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
}
