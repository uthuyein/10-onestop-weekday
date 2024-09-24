package com.jdc.mkt.communicate;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/include")
public class IncludeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Using include servlet");
		
		req.getRequestDispatcher("./header").include(req, resp);
		
		System.out.println("Value :"+req.getParameter("value"));
		
		resp.getWriter()
		.append("<h3>")
		.append("Include Servlet")
		.append("</h3>")
		.flush();
	}
}
