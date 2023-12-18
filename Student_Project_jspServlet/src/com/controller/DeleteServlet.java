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


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 
		 
		 
		 String id=request.getParameter("id");
		 
		 int id1=Integer.parseInt(id);
		 
		 StudentDAO dao=new StudentDAO();
		 try {
			int i=dao.deleteStudentById(id1);
			if(i>0)
			{
				out.print("Record Deleted Successfully");
				//response.sendRedirect("viewRecord.jsp");
				RequestDispatcher rd=request.getRequestDispatcher("viewRecord.jsp");
				rd.include(request, response);

			}
			else {
				out.print("Record  Not Deleted");

			}
		}
		 catch (Exception e) {
			System.out.println(e);
		}
	}

}
