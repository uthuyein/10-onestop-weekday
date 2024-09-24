package com.jdc.mkt.servlet.toCommunicate;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/pathCount",name = "counter")
public class PathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		resp.getWriter()
		.append("Count :"+count)
		.flush();
		count ++;
	}
}
