package com.project.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.project.configuration.AppConfig;

public class AppInitialize implements WebApplicationInitializer 
{

	
	public void onStartup(ServletContext arg0) throws ServletException 
	{
		/*Burada web.xml i�inde configuration 
		dosyas�n�n ne oldu�unu nas�l belirtiyorsak burada ayn� �ekilde belirtiyoruz*/
		
		AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		
		ctx.setServletContext(arg0);
		//Dispather�n tan�mlanmas� 
		ServletRegistration.Dynamic servlet=arg0.addServlet("dispatcher",new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

}
