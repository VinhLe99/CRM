package com.cybersoft.crm.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybersoft.crm.common.Common;
import com.cybersoft.crm.models.Project;
import com.cybersoft.crm.models.Task;
import com.cybersoft.crm.models.User;
import com.cybersoft.crm.services.ProjectService;
import com.cybersoft.crm.services.TaskService;
import com.cybersoft.crm.services.UserService;

@WebServlet(name = "urlProject", urlPatterns = {Common.PROJECT,Common.PROJECT_CREATE,Common.PROJECT_UPDATE,Common.PROJECT_DELETE,Common.PROJECT_DETAIL})
public class ProjectController extends HttpServlet{

	private ProjectService projectService = new ProjectService();
	private UserService userService = new UserService();
	private TaskService taskService = new TaskService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		List<Project> list = projectService.getListProjects();
		req.setAttribute("list", list);
		
		
		String path = req.getServletPath();
		HttpSession session = req.getSession();
		String role = (String) session.getAttribute("Role").toString();
		switch (path) {
		case Common.LOGOUT:
			req.getSession().invalidate();
			resp.sendRedirect(req.getContextPath()	+ Common.LOGIN);
			break;
		case Common.PROJECT:
			if(role.equalsIgnoreCase("1") || role.equalsIgnoreCase("2")) {
				req.getRequestDispatcher("project-table.jsp").forward(req, resp);				
			}else {		
				System.out.println("Dont have a auth!!");
				resp.sendRedirect(req.getContextPath()	+ Common.HOMEPAGE);
			}
			break;
		case Common.PROJECT_DELETE:
			int idxoa = Integer.parseInt(req.getParameter("project_id"));
			projectService.deleteProject(idxoa);
			resp.sendRedirect(req.getContextPath()	+ Common.PROJECT);
			break;
		case Common.PROJECT_CREATE:
			List<User> listuser = userService.getListUserByRole();
			req.setAttribute("listuser", listuser);
			req.getRequestDispatcher("project-add.jsp").forward(req, resp);
			break;
		case Common.PROJECT_DETAIL:
			int idxem = Integer.parseInt(req.getParameter("project_id"));
			List<Task> listtask = taskService.getListTaskByProjectId(idxem);
			req.setAttribute("listtask", listtask);
			req.getRequestDispatcher("project-detail.jsp").forward(req, resp);
			break;
		default:
			break;
		}		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String path = req.getServletPath();
		switch (path) {
		case Common.PROJECT_CREATE:	
			Project new_project = new Project();			
			new_project.setProject_name(req.getParameter("project_name"));
			new_project.setDescription(req.getParameter("description"));
			new_project.setStart_date(Date.valueOf(req.getParameter("start_date")));
			new_project.setEnd_date(Date.valueOf(req.getParameter("end_date")));
			new_project.setOwner(Integer.parseInt(req.getParameter("user_id")));			
			if(projectService.addProject(new_project) != false ) {
				resp.sendRedirect(req.getContextPath()	+ Common.PROJECT);
			}else {
				resp.sendRedirect(req.getContextPath()	+ Common.PROJECT_CREATE);
				System.out.println("Không thêm được" + Date.valueOf(path));
			}			
			break;
		case Common.PROJECT_UPDATE:	
			Project project_update = new Project();	
			project_update.setId(Integer.parseInt(req.getParameter("project_id")));
			project_update.setProject_name(req.getParameter("project_name"));
			project_update.setDescription(req.getParameter("description"));
			project_update.setStart_date(Date.valueOf(req.getParameter("start_date")));
			project_update.setEnd_date(Date.valueOf(req.getParameter("end_date")));
			if(projectService.updateProject(project_update) != false ) {
				resp.sendRedirect(req.getContextPath()	+ Common.PROJECT);
			}else {
				resp.sendRedirect(req.getContextPath()	+ Common.PROJECT);
				System.out.println("Không sửa được");
			}									
			break;
		default:
			break;
		}
	}
}
