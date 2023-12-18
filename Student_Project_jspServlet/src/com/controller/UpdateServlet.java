package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.model.Student;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDAO dao;
	@Override
	public void init() throws ServletException
	{
	 dao=new StudentDAO();
	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	String stud_id=request.getParameter("stud_id");
	String stud_rollno=request.getParameter("stud_rollno");
	String stud_name=request.getParameter("stud_name");
	String stud_city=request.getParameter("stud_city");
	
	int id=Integer.parseInt(stud_id);
	int rollno=Integer.parseInt(stud_rollno);
	
	Student student=new Student(id, rollno, stud_name, stud_city);
	try {
		int i=dao.updateStudentById(student);
		if(i>0)
		{
			out.print("<b>Record updated successfully.<b>");
			RequestDispatcher rd=request.getRequestDispatcher("viewRecord.jsp");
			rd.include(request, response);
		}
		else {
			out.print("<b>Record not  updated.<b>");

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}

}
