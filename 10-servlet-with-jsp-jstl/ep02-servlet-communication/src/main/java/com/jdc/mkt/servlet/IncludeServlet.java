package com.jdc.mkt.servlet;

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
		resp.getWriter()
		.append("<p>")
		.append("Include Servlet")
		.append("</p>")
		.append("</body>")
		.append("</html>")
		.flush();
	}
}
