<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Insert title here</title>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="card-header">
		<h3 style="text-align: center;">NEW REGISTRATION</h3>
	</div>
	<div class="card-body rounded-lg">
		<form action="RegistrationServlet" method="get">

			<div class="form-group">
				<input type="text" class="form-control" name="stud_id"
					placeholder="Enter Student id" required><br> <input
					type="text" class="form-control" name="stud_roll_no"
					placeholder="Enter Student roll_no" required><br> <input
					type="text" class="form-control" name="stud_name"
					placeholder="Enter student Name" required> <br> <input
					type="text" class="form-control" name="stud_city"
					placeholder="Enter Student city" required>

			</div>
			<input type="submit" name="submit" value="Register"
				class="form-control btn-primary">
	</div>
	</div>
	</div>

	</form>
</body>
</html>