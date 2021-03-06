package fr.m1info.rv2j.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.m1info.rv2j.beans.User;
import fr.m1info.rv2j.beans.Project;
import fr.m1info.rv2j.dao.DAOFactory;
import fr.m1info.rv2j.dao.ProjectDAO;
import fr.m1info.rv2j.dao.UserDAO;

public class Projects extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public final static String CONF_DAO_FACTORY = "daofactory";
	
	public final static String view = "/WEB-INF/projects.jsp";
	
	public final static String SESSION = "session_user";
	
	public final static String USERS = "users";
	public final static String PROJECTS = "projects";
	public final static String PROJECT = "project";
	
	
	private ProjectDAO projectDAO;
	private UserDAO userDAO;
	
	private List<Project> projects;
	private Map<Integer, User> users;
	
	@Override
	public void init() throws ServletException {
		this.projectDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getProjectDao();
		this.userDAO = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getUserDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user_session = (User) session.getAttribute(SESSION);
		
		if(user_session == null || user_session.getRightLevel() == 0) {
			resp.sendError(401);
		} else {
			projects = projectDAO.getAllProjects();
			users = userDAO.mapUsers();
			req.setAttribute(PROJECTS, projects);
			req.setAttribute(USERS, users);
			this.getServletContext().getRequestDispatcher(view).forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
