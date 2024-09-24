package com.jdc.mkt.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/info",displayName = "servlet info",description = "testing")
public class ServletInformation extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//servlet info
		System.out.println("Servlet info :"+getServletInfo());
		System.out.println("Servlet name :"+getServletName());
		System.out.println("Servlet context path:"+getServletContext().getContextPath());
		
		//Http protocol	
		System.out.println();
		System.out.println("req path info :"+req.getPathInfo());
		System.out.println("req servlet path :"+req.getServletPath());
		System.out.println("req context path :"+req.getContextPath());
		
		System.out.println();
		var headers = req.getHeaderNames();
		while(headers.hasMoreElements()) {
			var head = headers.nextElement();
			System.out.println(head+"\t"+req.getHeader(head));
		}
	}
}
