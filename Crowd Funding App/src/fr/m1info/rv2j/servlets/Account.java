package fr.m1info.rv2j.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Account extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public final static String view = "/WEB-INF/account.jsp";
	public final static String USER_SESSION = "user_session";
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(view).forward(req, resp);
	}
}