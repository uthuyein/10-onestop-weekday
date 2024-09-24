package com.jdc.mkt.servlet.toCommunicate;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/toRedirect")
public class ToRedirectServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Using to redirect");
		req.getRequestDispatcher("./header").include(req, resp);
		
		var value = req.getParameter("value");
		
		resp.getWriter()
		.append("<h3>")
		.append("Using To Redirect Servlet with value :"+value)
		.append("</h3>")
		.append("</body>")
		.append("</html>")
		.flush();
	}
}
