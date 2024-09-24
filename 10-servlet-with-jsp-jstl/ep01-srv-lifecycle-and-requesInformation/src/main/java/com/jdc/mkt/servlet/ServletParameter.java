package com.jdc.mkt.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/gotoParam",
initParams = {
		@WebInitParam(name = "name",value = "Su Su"),
		@WebInitParam(name = "age",value = "12")
})
public class ServletParameter extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Get parameter from request
		var name = req.getParameter("name");
		var age = req.getParameter("age");
		System.out.println("Name :%s\tAge :%s\n".formatted(name,age));
		
		//Get init parameter	
		var names = getInitParameterNames();
		while(names.hasMoreElements()) {
			var na = names.nextElement();	
			System.out.println("Param Name :%s\tParam Value :%s".formatted(na,getInitParameter(na)));
		}
	}

}
