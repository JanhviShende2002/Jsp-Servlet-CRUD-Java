package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.model.Student;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 
		 String stud_id=request.getParameter("stud_id");
		 String stud_rollNo=request.getParameter("stud_roll_no");
		 String stud_name=request.getParameter("stud_name");
		 String stud_city=request.getParameter("stud_city");
		 
		 int id=Integer.parseInt(stud_id);
		 int rollNo=Integer.parseInt(stud_rollNo);
		 Student student=new Student(id, rollNo, stud_name, stud_city);
		 
		 StudentDAO dao=new StudentDAO();
		 try {
			int i=dao.addStudent(student);
			if(i>0)
			{
				out.print("Record Inserted Successfully.");
				response.sendRedirect("viewRecord.jsp");

			}
			else {
				out.print("Record not Inserted.");

			}
			 
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		 
		 
		 
		 
		 
	}
	

}
