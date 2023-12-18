<%@page import="com.model.Student"%>
<%@page import="com.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="navbar.jsp"%>
</head>
<body>
	<%!
	StudentDAO dao;

	public void init() throws ServletException {
		dao = new StudentDAO();
	}%>
	<%
		String id = request.getParameter("sid");
		int id1 = Integer.parseInt(id);

		Student student = dao.getStudentById(id1);
	%>

	<h3>student update form</h3>
	<div class="card-body rounded-lg">
		<form action="UpdateServlet" method="get">

			<div class="form-group">
				<input type="text" class="form-control" name="stud_id"
					placeholder="Enter Student id" value="<%=student.getId()%>"readonly><br>
					
				<input type="text" class="form-control" name="stud_rollno"
					placeholder="Enter Student roll_no" value="<%=student.getRoll_no()%>"
					required><br> 
					<input type="text" class="form-control"
					name="stud_name" placeholder="Enter student Name"
					value="<%=student.getName()%>" required> <br> <input
					type="text" class="form-control" name="stud_city"
					placeholder="Enter Student city" value="<%=student.getCity()%>"required>

			</div>
			<input type="submit" name="submit" value="Update"
				class="form-control btn-primary">

		</form>
	</div>



</body>
</html>