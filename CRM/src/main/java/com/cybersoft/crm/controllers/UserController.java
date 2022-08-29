package com.cybersoft.crm.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybersoft.crm.common.Common;
import com.cybersoft.crm.models.Task;
import com.cybersoft.crm.models.User;
import com.cybersoft.crm.services.TaskService;
import com.cybersoft.crm.services.UserService;

@WebServlet(name = "urlUser", urlPatterns = {Common.LOGOUT,Common.USER_LIST,Common.USER_CREATE,Common.USER_DETAIL,Common.USER_UPDATE,Common.USER_DELETE,Common.HOMEPAGE})
public class UserController extends HttpServlet{
	private UserService userService = new UserService();
	private TaskService taskService = new TaskService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String role = (String) session.getAttribute("Role").toString();
		
		String path = req.getServletPath();
		switch (path) {
		case Common.LOGOUT:
			req.getSession().invalidate();
			resp.sendRedirect(req.getContextPath()	+ "/login");
			break;
		case Common.USER_CREATE:
			System.out.println("Dont have a auth!!");
			resp.sendRedirect(req.getContextPath()	+ Common.USER_LIST);
			break;
		case Common.HOMEPAGE:
			req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
			break;
		case Common.USER_DELETE:
			int idxoa = Integer.parseInt(req.getParameter("user_id"));
			userService.deleteUser(idxoa);		
			resp.sendRedirect(req.getContextPath()	+ Common.USER_LIST);
			break;
		case Common.USER_LIST:
			if(role.equalsIgnoreCase("1") || role.equalsIgnoreCase("2")) {
				List<User> list = userService.getListUser();
				req.setAttribute("list", list);			
				req.getRequestDispatcher("user-table.jsp").forward(req, resp);
			}else {		
				System.out.println("Dont have a auth!!");
				resp.sendRedirect(req.getContextPath()	+ Common.HOMEPAGE);
			}
			break;
		case Common.USER_DETAIL:
			int idxem = Integer.parseInt(req.getParameter("user_id"));
			User user = userService.getUserById(idxem);
			req.setAttribute("user", user);
			List<Task> listtask = taskService.getListTaskByUserId(idxem);
			req.setAttribute("listtask", listtask);
			req.getRequestDispatcher("user-detail.jsp").forward(req, resp);
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
		case Common.USER_CREATE:	
			User new_user = new User();			
			new_user.setFullname(req.getParameter("fullname"));
			new_user.setEmail(req.getParameter("email"));
			new_user.setPassword(req.getParameter("password"));
			new_user.setPhone(req.getParameter("phone"));
			new_user.setAddress(req.getParameter("address"));
			new_user.setRole_id(Integer.parseInt(req.getParameter("role")));	
			if(userService.addUser(new_user) != false ) {
				resp.sendRedirect(req.getContextPath()	+ Common.USER_LIST);
			}else {
				resp.sendRedirect(req.getContextPath()	+ Common.USER_CREATE);
				System.out.println("Không thêm được");
			}			
			break;
		case Common.USER_UPDATE:	
			User update_user = new User();			
			update_user.setFullname(req.getParameter("fullname"));
			update_user.setEmail(req.getParameter("email"));
			update_user.setPhone(req.getParameter("phone"));
			update_user.setAddress(req.getParameter("address"));
			update_user.setRole_id(Integer.parseInt(req.getParameter("role")));
			update_user.setId(Integer.parseInt(req.getParameter("id")));
			System.out.println(update_user.getEmail());
			if(userService.updateUser(update_user) != false ) {
				resp.sendRedirect(req.getContextPath()	+ Common.USER_LIST);
			}else {
				resp.sendRedirect(req.getContextPath()	+ Common.USER_UPDATE);
				System.out.println("Không sửa được");
			}									
			break;
		default:
			break;
		}
	}
}
