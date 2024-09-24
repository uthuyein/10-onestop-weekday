package com.jdc.mkt.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/greet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public HelloServlet() {
		System.out.println("========================= Constructor starting =================");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("========================= Init method starting =================");
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("========================= Service method starting =================");
		super.service(arg0, arg1);
	}
	
	@Override
	public void destroy() {
		System.out.println("========================= Destroy method starting =================");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello Servlet test");
		resp.getWriter().append("""
				<!DOCTYPE html>
					<html>
					<head>
					<meta charset="UTF-8">
					<title>Insert title here</title>
					</head>
					<body>
						<h1>Hello Client</h1>	
						<a href="/"> go to home page</a>
					</body>
				</html>
				""");
	}
	
}
