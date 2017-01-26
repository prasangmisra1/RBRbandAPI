package com.rbrband.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

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
public class App {
/*	public static void main(String[] args) {
	      ApplicationContext context = 
	             new ClassPathXmlApplicationContext("Beans.xml");

	      MainController obj = (MainController) context.getBean("Main");
	      //obj.getMessage();
	   }*/
	


	@RequestMapping(value="/superapi",
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