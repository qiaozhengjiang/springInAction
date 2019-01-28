package com.prac.springInAction.chapter01.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DataAccessTest {
	@Autowired
	private static JdbcTemplate jdbcTemplate;
	public static void main(String[] args) throws ClassNotFoundException {
		jdbc();
		jdbcTemplate();
	}
	/**
	 * 使用JDBC导致很多样板式代码
	 * @throws ClassNotFoundException 
	 */
	public static void jdbc() throws ClassNotFoundException {
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			pst=conn.prepareStatement("select * from sys_user where login_name=?");
			pst.setString(1, "thinkgem");
			rs=pst.executeQuery();
			while(rs.next()) {
				String username=rs.getString("name");
				String password=rs.getString("password");
				System.out.println("name:"+username+"\tpassword:"+password);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pst!=null) {
					pst.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static Connection getConnection() throws ClassNotFoundException {
		String url="jdbc:mysql://127.0.0.1:3306/jeesite?characterEncoding=utf-8";
		String username="root";
		String password="root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection(url, username, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 使用jdbcTemplate消除模板式代码
	 */
	public static void jdbcTemplate() {
		jdbcTemplate.queryForObject("select * from sys_user where login_name=?", new RowMapper<String>() {
			public String mapRow(ResultSet rs,int rowNum)throws SQLException{
				String result="name:"+rs.getString("name")+"\tpassword"+rs.getString("password");
				return result;
			}
		},"thinkgem");
	}
}
