package com.jdc.mkt.servlet;

import java.io.IOException;

import com.jdc.mkt.model.Counter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private static final String COUNTER = "COUNTER";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Counter c1 = (Counter) req.getAttribute(COUNTER);
		if(null == c1) {
			c1 = new Counter();
		}
		c1.countUp();
		req.setAttribute(COUNTER, c1);
		
		var session = req.getSession(true);
		Counter c2 = (Counter) session.getAttribute(COUNTER);
		
		if(null == c2) {
			c2 = new Counter();
		}
		c2.countUp();
		session.setAttribute(COUNTER, c2);
		
		var context = getServletContext();
		Counter c3 = (Counter) context.getAttribute(COUNTER);
		
		if(null == c3) {
			c3 = new Counter();
		}
		c3.countUp();
		context.setAttribute(COUNTER, c3);
		
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}
}
