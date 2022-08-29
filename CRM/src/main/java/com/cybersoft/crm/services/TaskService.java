package com.cybersoft.crm.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.crm.connection.DBConnection;
import com.cybersoft.crm.models.Task;
import com.cybersoft.crm.models.User;

public class TaskService {

	// Add new task
	public boolean addTask(Task task) {
		Connection connection =DBConnection.getConnection();
		String sql = "INSERT INTO task (task_name,description,start_date,project_id,user_id,status)\r\n"
				+ "VALUES (?,?,?,?,?,?)";
		boolean isSusses = false;
		try {			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, task.getTask_name());
			statement.setString(2, task.getDescription());
			statement.setDate(3, (Date) task.getStart_date());
			statement.setInt(4, task.getProject_id());
			statement.setInt(5, task.getUser_id());			
			statement.setString(6, task.getStatus());
			int result = statement.executeUpdate();
			if(result>0) {
				isSusses = true;
			}else {
				isSusses = false;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isSusses;
	}
	// Get list
	public List<Task> getListTask() {
		Task task = null;
		List<Task> list = new ArrayList<Task>();
		Connection connection =DBConnection.getConnection();
		String sql = "select t.id,t.task_name , t.description, p.project_name, u.fullname,  t.start_date, t.end_date, t.user_id, t.project_id, t.status\r\n"
				+ "from task t\r\n"
				+ "left join project p\r\n"
				+ "on t.project_id = p.id\r\n"
				+ "left join user u\r\n"
				+ "on t.user_id = u.id";		
		try {			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				task = new Task();	
				task.setId(Integer.parseInt(result.getString("id")));	
				task.setTask_name(result.getString("t.task_name"));
				task.setDescription(result.getString("t.description"));
				task.setProject_name(result.getString("p.project_name"));
				task.setUser_name(result.getString("u.fullname"));
				task.setStart_date(result.getDate("start_date"));
				task.setEnd_date(result.getDate("end_date"));
				task.setProject_id(Integer.parseInt(result.getString("project_id")));
				task.setUser_id(Integer.parseInt(result.getString("user_id")));
				task.setStatus(result.getString("status"));				
				list.add(task);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// Delete
	public void deleteTask(int id) {
		Connection con = DBConnection.getConnection();
		String sql = "delete from task where id = ?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);			
			int result = statement.executeUpdate();
			con.close();			
			if(result > 0) {
				System.out.println("Success!");
			}else {
				System.out.println("Error!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Update
	public boolean updateTask(Task task) {
		Connection con = DBConnection.getConnection();
		String sql = "UPDATE task SET task_name = ?, project_id = ?, user_id = ?, start_date = ?, end_date = ?, status = ? WHERE id = ?";
		boolean isSuccess = false;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, task.getTask_name());
			statement.setInt(2, task.getProject_id());
			statement.setInt(3, task.getUser_id());
			statement.setDate(4, (Date) task.getStart_date());
			statement.setDate(5, (Date) task.getEnd_date());
			statement.setString(6, task.getStatus());
			statement.setInt(7, task.getId());
			statement.executeUpdate();
			int result = statement.executeUpdate();
			if(result > 0 ) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	//Get list by user_id
		public List<Task> getListTaskByUserId(int user_id) {
			Task task = null;
			List<Task> list = new ArrayList<Task>();
			Connection connection =DBConnection.getConnection();
			String sql = "select id,task_name, start_date, end_date, status \r\n"
					+ "from task \r\n"
					+ "where user_id = ?";		
			try {			
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, user_id);	
				ResultSet result = statement.executeQuery();				
				while(result.next()) {
					task = new Task();	
					task.setId(Integer.parseInt(result.getString("id")));	
					task.setTask_name(result.getString("task_name"));
					task.setStart_date(result.getDate("start_date"));
					task.setEnd_date(result.getDate("end_date"));
					task.setStatus(result.getString("status"));				
					list.add(task);
				}
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		//Get list by project_id
		public List<Task> getListTaskByProjectId(int project_id) {
			Task task = null;
			List<Task> list = new ArrayList<Task>();
			Connection connection =DBConnection.getConnection();
			String sql = "select task_name, description, status, u.fullname\r\n"
					+ "from task t\r\n"
					+ "left join user u\r\n"
					+ "on u.id=t.user_id\r\n"
					+ "where project_id = ?";		
			try {			
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, project_id);	
				ResultSet result = statement.executeQuery();				
				while(result.next()) {
					task = new Task();	
					task.setTask_name(result.getString("task_name"));
					task.setDescription(result.getString("description"));
					task.setStatus(result.getString("status"));		
					task.setUser_name(result.getString("u.fullname"));
					list.add(task);
				}
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
}
