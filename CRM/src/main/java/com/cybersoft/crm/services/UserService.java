package com.cybersoft.crm.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.crm.connection.DBConnection;
import com.cybersoft.crm.models.User;



public class UserService {
	// Đăng nhập
	public User getUser(String email, String password) {
		User user = null;
		Connection con = DBConnection.getConnection();
		String sql = "select * from user where email = ? and password = ?";		
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				user = new User();
				user.setId(Integer.parseInt(result.getString("id")));	
				user.setFullname(result.getString("fullname"));
				user.setEmail(result.getString("email"));	
				user.setAddress(result.getString("address"));
				user.setPhone(result.getString("phone"));
				user.setAvatar(result.getString("avatar"));
				user.setRole_id(Integer.parseInt(result.getString("role_id")));
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;	
	}
	// Lấy chi tiết user bằng id
	public User getUserById(int id) {
		User user = null;
		Connection con = DBConnection.getConnection();
		String sql = "select * from user where id = ?";		
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				user = new User();
				user.setId(Integer.parseInt(result.getString("id")));	
				user.setFullname(result.getString("fullname"));
				user.setEmail(result.getString("email"));	
				user.setAddress(result.getString("address"));
				user.setPhone(result.getString("phone"));
				user.setAvatar(result.getString("avatar"));
				user.setRole_id(Integer.parseInt(result.getString("role_id")));
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}
		return user;
}
	// Lấy danh sách
	public List<User> getListUser() {
		User user = null;
		List<User> list = new ArrayList<User>();
		Connection con = DBConnection.getConnection();
		String sql = "select * from user";		
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				user = new User();
				user.setId(Integer.parseInt(result.getString("id")));	
				user.setFullname(result.getString("fullname"));
				user.setEmail(result.getString("email"));	
				user.setAddress(result.getString("address"));
				user.setPhone(result.getString("phone"));
				user.setAvatar(result.getString("avatar"));
				user.setRole_id(Integer.parseInt(result.getString("role_id")));
				list.add(user);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
	// Thêm tài khoản
	public boolean addUser(User user) {		
		Connection con = DBConnection.getConnection();
		String sql = "insert into user(fullname,email,password,phone,address,role_id) values (?,?,?,?,?,?)";
		boolean isSuccess = false;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, user.getFullname());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getPhone());
			statement.setString(5, user.getAddress());
			statement.setInt(6, user.getRole_id());
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
	// Xóa tài khoản
	public void deleteUser(int id) {		
		Connection con = DBConnection.getConnection();
		String sql = "delete from user where id = ?";
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
	public boolean updateUser(User user) {		
		Connection con = DBConnection.getConnection();
		String sql = "update user set fullname = ?,email= ?,phone= ?,address = ?, role_id = ?"
				+ " WHERE id = ?"	;
		boolean isSuccess = false;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, user.getFullname());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPhone());
			statement.setString(4, user.getAddress());
			statement.setInt(5, user.getRole_id());
			statement.setInt(6, user.getId());			
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
	// Get project owner
	public List<User> getListUserByRole() {
		User user = null;
		List<User> list = new ArrayList<User>();
		Connection con = DBConnection.getConnection();
		String sql = "select * from user where role_id = 2 or role_id = 1";		
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				user = new User();
				user.setId(Integer.parseInt(result.getString("id")));	
				user.setFullname(result.getString("fullname"));
				user.setEmail(result.getString("email"));	
				user.setAddress(result.getString("address"));
				user.setPhone(result.getString("phone"));
				user.setAvatar(result.getString("avatar"));
				user.setRole_id(Integer.parseInt(result.getString("role_id")));
				list.add(user);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
}
