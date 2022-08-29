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

@WebServlet(name = "urlTask", urlPatterns = {Common.TASK_CREATE,Common.TASK_LIST,Common.TASK_DELETE, Common.TASK_UPDATE})
public class TaskController extends HttpServlet{

	private TaskService taskService = new TaskService();
	private UserService userService = new UserService();
	private ProjectService projectService = new ProjectService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		List<User> listuser = userService.getListUser();
		List<Project> listproject = projectService.getListProjects();
		req.setAttribute("listuser", listuser);
		req.setAttribute("listproject", listproject);
		List<Task> list = taskService.getListTask();
		req.setAttribute("list", list);
		String path = req.getServletPath();
		HttpSession session = req.getSession();
		String role = (String) session.getAttribute("Role").toString();
		switch (path) {
		case Common.LOGOUT:
			req.getSession().invalidate();
			resp.sendRedirect(req.getContextPath()	+ Common.LOGOUT);
			break;
		case Common.TASK_LIST:	
			req.getRequestDispatcher("task-table.jsp").forward(req, resp);
			break;
		case Common.TASK_CREATE:
			if(role.equalsIgnoreCase("1") || role.equalsIgnoreCase("2")) {
				req.setAttribute("listuser", listuser);			
				req.setAttribute("listproject", listproject);
				req.getRequestDispatcher("task-add.jsp").forward(req, resp);
			}else {		
				System.out.println("Dont have a auth!!");
				resp.sendRedirect(req.getContextPath()	+ Common.TASK_LIST);
			}
			break;
		case Common.TASK_DELETE:
			if(role.equalsIgnoreCase("1") || role.equalsIgnoreCase("2")) {
				int idxoa = Integer.parseInt(req.getParameter("task_id"));
				taskService.deleteTask(idxoa);
				resp.sendRedirect(req.getContextPath()	+ Common.TASK_LIST);
			}else {		
				System.out.println("Dont have a auth!!");
				resp.sendRedirect(req.getContextPath()	+ Common.TASK_LIST);
			}
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
		HttpSession session = req.getSession();
		String role = (String) session.getAttribute("Role").toString();
		switch (path) {
		case Common.TASK_CREATE:			
			Task new_task = new Task();
			new_task.setTask_name(req.getParameter("task_name"));
			new_task.setDescription(req.getParameter("description"));
			new_task.setStart_date(Date.valueOf(req.getParameter("start_date")));
			new_task.setUser_id(Integer.parseInt(req.getParameter("user_id")));
			new_task.setProject_id(Integer.parseInt(req.getParameter("project_id")));			
			new_task.setStatus("2");
			if(taskService.addTask(new_task) != false ) {
				resp.sendRedirect(req.getContextPath()	+ Common.TASK_LIST);
			}else {
				resp.sendRedirect(req.getContextPath()	+ Common.TASK_CREATE);
				System.out.println("Không thêm được");
			}			
			break;
		case Common.TASK_UPDATE:
			if(role.equalsIgnoreCase("1") || role.equalsIgnoreCase("2")) {
				Task task = new Task();
				task.setId(Integer.parseInt(req.getParameter("task_id")));
				task.setTask_name(req.getParameter("task_name"));
				task.setDescription(req.getParameter("description"));
				task.setStart_date(Date.valueOf(req.getParameter("start_date")));
				task.setEnd_date(Date.valueOf(req.getParameter("end_date")));
				task.setUser_id(Integer.parseInt(req.getParameter("user_id")));
				task.setProject_id(Integer.parseInt(req.getParameter("project_id")));			
				task.setStatus(req.getParameter("status"));
				if(taskService.updateTask(task) != false ) {
					resp.sendRedirect(req.getContextPath()	+ Common.TASK_LIST);
				}else {
					resp.sendRedirect(req.getContextPath()	+ Common.TASK_LIST);
					System.out.println("Không thêm được");
				}
			}else {		
				System.out.println("Dont have a auth!!");
				resp.sendRedirect(req.getContextPath()	+ Common.TASK_LIST);
			}
			break;
		default:
			break;
		}
	}
}
