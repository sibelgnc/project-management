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
		/*Burada web.xml içinde configuration 
		dosyasýnýn ne olduðunu nasýl belirtiyorsak burada ayný þekilde belirtiyoruz*/
		
		AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		
		ctx.setServletContext(arg0);
		//Dispatherýn tanýmlanmasý 
		ServletRegistration.Dynamic servlet=arg0.addServlet("dispatcher",new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

}
