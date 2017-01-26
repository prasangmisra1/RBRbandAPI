package com.rbrband.main;

import javax.ws.rs.core.MediaType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rbrband.dao.User;
import com.rbrband.dao.UserJDBCTemplate;


@Controller
public class MainController {
	 
	@RequestMapping("/")
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ModelAndView modelAndView = new ModelAndView("homepage");
		modelAndView.addObject("Hi all, I am RBRband");
		request.setAttribute("message", "Hi,I am RBRband");
		return modelAndView;
	}
	
	@RequestMapping("/api")
	public ModelAndView handleRequestInternal1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("homepage");
		modelAndView.addObject("Hi all, I am RBRband");
		request.setAttribute("message", "This is the API is guess :p");
		return modelAndView;
	}
	
	@RequestMapping(value="/getuser",
			produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public String myreturnString(HttpServletRequest request, HttpServletResponse response)
	{
	      JSONObject obj = new JSONObject();

		String id=request.getParameter("id");
try{
		if (id!=null)
		{	System.out.println("Reached here");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		UserJDBCTemplate userJDBCTemplate = 
			      (UserJDBCTemplate)context.getBean("UserJDBCTemplate");
		System.out.println("----Listing Record with ID = "+id+" -----" );
	      User user = userJDBCTemplate.getUser(Integer.parseInt(id));
	      if (user!=null)
	      { 

	      obj.put("id", user.getId());
	      obj.put("name", user.getName());
	      obj.put("age", user.getAge());
	      obj.put("country", user.getCountry_id());
	      obj.put("state", user.getState_id());
	      obj.put("email", user.getEmail());
		return obj.toString();
	      }
	      else return obj.toString();
		}
		else return obj.toString();
}
catch (Exception e)
{
	return obj.toString();}
	}
	}