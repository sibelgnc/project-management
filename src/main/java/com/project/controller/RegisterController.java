package com.project.controller;

import java.util.Iterator;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.form.UserLoginForm;
import com.project.model.Project;
import com.project.model.User;
import com.project.service.UserService;




@Controller
@RequestMapping("/")
public class RegisterController 
{

	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/","/registration"},method=RequestMethod.GET)
	public String getHome(ModelMap model)
	{
		model.addAttribute("registerUser", new User());
		return "register";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLogin(ModelMap model)
	{
		model.addAttribute("loginUser",new UserLoginForm());
		return "login";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("registerUser")User user, BindingResult result,ModelMap model)
	{
		System.out.println("res girdi");
      System.out.println("gelenus:"+user.getUserName());
	
	    User us=userService.arrangeUser(user);
	    System.out.println("res:"+us.getUserName());
		userService.saveUser(us);
		
		return "redirect:/login";

	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@Valid @ModelAttribute("loginUser")UserLoginForm userLoginForm, BindingResult result,ModelMap model)
	{ 
        //System.out.println("controller:"+userLoginForm.getUserName());
		boolean control=userService.loginControl(userLoginForm);
		System.out.println("control:"+control);
		if(control==true)
		{
			return "home";
		}
		else
		{
			return "login";
		}
		
	

	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String loginUser()
	{ 
        
		User user=userService.findUserById(1);
		 for (Iterator<Project> it = user.getProjects().iterator(); it.hasNext(); ) 
		 {
		     Project pro=it.next();
		     System.out.println("userProject:"+pro.getProjectName());
		        
		 }
	  
		return "home";
	}
}
