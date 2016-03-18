package fr.m1info.rv2j.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogIn extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public final static String view = "/WEB-INF/login.jsp";
	public static String username;
	public static String password;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(view).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap<String, String> errors = new HashMap<String, String>();
		username = req.getParameter("username");
		password = req.getParameter("password");
		
		if (username.trim().equals("a") || password.trim().equals("a")) {
			errors.put("error_login", "Identifiant ou mot de passe incorrect!");
		}
		
		req.setAttribute("errors", errors);
		this.getServletContext().getRequestDispatcher(view).forward( req, resp );
		//super.doPost(req, resp);
	}
	
}
