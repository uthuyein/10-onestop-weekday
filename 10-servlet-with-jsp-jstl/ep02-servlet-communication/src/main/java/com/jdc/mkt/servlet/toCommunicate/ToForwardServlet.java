package com.jdc.mkt.servlet.toCommunicate;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/toForward")
public class ToForwardServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Using To Forward servlet");
		req.getRequestDispatcher("./header").include(req, resp);
		var value = req.getParameter("value");
		
		resp.getWriter()
		.append("<h3>")
		.append("Using To Forward Servlet with value :"+value)
		.append("</h3>")
		.append("</body>")
		.append("</html>")
		.flush();
	}
}
