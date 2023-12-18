package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.utility.DBUtility;

public class StudentDAO {
	//insert Student
	

	public int addStudent(Student student) throws SQLException {
		Connection con=DBUtility.getDBConnection();
		String sql="insert into students values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, student.getId());
		ps.setInt(2, student.getRoll_no());
		ps.setString(3, student.getName());
		ps.setString(4, student.getCity());
		
		return ps.executeUpdate();
	}
	
	//display Student
	public List<Student> displayAllStudent() throws SQLException
	{
		List<Student> list=new ArrayList<>();
		
		Connection con=DBUtility.getDBConnection();
		String sql="select * from students";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Student student=new Student();
			
			student.setId(rs.getInt(1));
			student.setRoll_no(rs.getInt(2));
			student.setName(rs.getString(3));
			student.setCity(rs.getString(4));
			
			list.add(student);
		}
		return list;
	}
//Delete Student
	public int deleteStudentById(int id1) throws SQLException {
		Connection con=DBUtility.getDBConnection();
		String sql="delete from students where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1,id1 );
		
		return ps.executeUpdate();
	}	
	//get single student data
	public Student getStudentById(int id1) throws SQLException {
		Connection con=DBUtility.getDBConnection();
		String sql="select * from students where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1,id1);
		Student student=new Student();
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			student.setId(rs.getInt(1));
			student.setRoll_no(rs.getInt(2));
			student.setName(rs.getString(3));
			student.setCity(rs.getString(4));
		}
		return student;
		
	}
	
	//update Student
	public int updateStudentById(Student student) throws SQLException{
		
		Connection con=DBUtility.getDBConnection();
		String sql="update students set roll_no=?,name=?,city=? where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, student.getRoll_no());
		ps.setString(2, student.getName());
		ps.setString(3, student.getCity());
		ps.setInt(4, student.getId());
		return ps.executeUpdate();
	}

}
