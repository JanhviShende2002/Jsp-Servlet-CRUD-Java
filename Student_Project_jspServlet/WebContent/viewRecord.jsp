<%@page import="javax.naming.ldap.Rdn"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<%@ include file="navbar.jsp"%><br>
	<br>


	<%!StudentDAO dao;

	public void init() throws ServletException {
		dao = new StudentDAO();
	}%>
	<%
		List<Student> list = dao.displayAllStudent();
	%>
	<%
		Iterator<Student> itr = list.iterator();
	%>
	<h3 style="text-align: center;">Student Records</h3>
	<div>
		<table
			class="table table-bordered table-striped table-hover text-center"
			id="myTable">

			<tr>
				<th>ID</th>
				<th>Roll_NO</th>
				<th>Name</th>
				<th>City</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>


			<%
				while (itr.hasNext()) {
					Student stud = itr.next();
			%>
			<tr>
				<td><%=stud.getId()%></td>
				<td><%=stud.getRoll_no()%></td>
				<td><%=stud.getName()%></td>
				<td><%=stud.getCity()%></td>
				<!-- <td><button class="btn btn-success">DELETE</button></td>
				<td><button class="btn btn-success">UPDATE</button></td> -->
				<%
					out.print("<td>");
						out.print("<a href='edit.jsp?sid=" + stud.getId() + "'>" + "UPDATE" + "</a>");
						out.print("</td>");
						out.print("<td>");
						out.print("<a href='DeleteServlet?id=" + stud.getId() + "'>" + "DELETE" + "</a>");
						out.print("</td>");
				%>
			</tr>
			<%
				}
			%>




		</table>

	</div>

</body>
</html>