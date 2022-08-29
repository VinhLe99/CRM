package com.cybersoft.crm.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.crm.connection.DBConnection;
import com.cybersoft.crm.models.Project;

public class ProjectService {

	//Them nhom viec
	public boolean addProject(Project project) {
		Connection connection =DBConnection.getConnection();
		String sql = "insert into project(project_name,description,start_date,end_date,owner) values (?,?,?,?,?)";
		boolean isSusses = false;
		try {			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, project.getProject_name());
			statement.setString(2, project.getDescription());
			statement.setDate(3, (Date) project.getStart_date());
			statement.setDate(4, (Date) project.getEnd_date());
			statement.setInt(5, project.getOwner());
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
	//Cap nhat nhom viec
	public boolean updateProject(Project project) {		
		Connection con = DBConnection.getConnection();
		String sql = "update project set project_name = ?,description= ?,start_date= ?,end_date = ?"
				+ " WHERE id = ?"	;
		boolean isSuccess = false;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, project.getProject_name());
			statement.setString(2, project.getDescription());
			statement.setDate(3, (Date) project.getStart_date());
			statement.setDate(4, (Date) project.getEnd_date());
			statement.setInt(5, project.getId());
			int result = statement.executeUpdate();
			if(result > 0 ) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}			
			con.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return isSuccess;
	}
	//Xoa thanh vien
	public void deleteProject(int id) {
		Connection con = DBConnection.getConnection();
		String sql = "delete from project where id = ?";
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
	//Lay danh sach nhom viec tu database
	public List<Project> getListProjects() {
		Project project = null;
		List<Project> list = new ArrayList<Project>();
		Connection connection =DBConnection.getConnection();
		String sql = "select * from project";		
		try {			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				project = new Project();
				project.setId(Integer.parseInt(result.getString("id")));	
				project.setProject_name(result.getString("project_name"));
				project.setDescription(result.getString("description"));
				project.setStart_date(result.getDate("start_date"));
				project.setEnd_date(result.getDate("end_date"));
				project.setOwner(result.getInt("owner"));
				list.add(project);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
