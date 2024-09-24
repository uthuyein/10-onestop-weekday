package com.jdc.mkt.servlet.util;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/header")
public class HeaderServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static final String HEADER ="""
			<!DOCTYPE html>
				<html>
				<head>
					<meta charset="UTF-8">
					<title>Communication Servlet</title>
				</head>
				<body>
			""";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Using header include ");
		resp.getWriter()
		.append(HEADER)
		.flush();
	}
}
