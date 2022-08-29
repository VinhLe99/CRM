package com.cybersoft.crm.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybersoft.crm.common.Common;
import com.cybersoft.crm.models.User;
import com.cybersoft.crm.services.UserService;

@WebServlet(Common.LOGIN)
public class LoginController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("login.jsp").forward(req, resp);		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User user = userService.getUser(email, password);
		
		if(user != null) {			
			/*
			 * Dùng session để lưu dữ liệu
			 * */			
			HttpSession session = req.getSession();
			session.setAttribute("Role", user.getRole_id());	
			session.setMaxInactiveInterval(60*60*60);
			resp.sendRedirect(req.getContextPath() + Common.HOMEPAGE);			
		}else {
			resp.sendRedirect(req.getContextPath() + Common.LOGIN);	
		}		
	}
}
