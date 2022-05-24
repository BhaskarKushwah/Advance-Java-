<%@page import="java.util.ArrayList"%>
<%@page import="com.factory.SearchJdbc"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page errorPage="Error.jsp"%>
<%@page import="service.*"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<%@include file="link.jsp"%>
<title>Home</title>

</head>

<body>
	<%
		String same = (String) session.getAttribute("email");

		if (same == null) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);

		}
	%>
	<form action="HomeSvt" method="get">
		<div class="row g-3">
			<div class="col-md-4">
				<input type="text" class="form-control" placeholder="First name"
					name="firstname" aria-label="First name">
			</div>
			<div class="col-md-4">
				<input type="text" class="form-control" placeholder="Last name"
					name="lastname" aria-label="Last name">
			</div>
			<div class="col-2">
				<button type="submit" class="btn btn-primary" name="button"
					value="search">Search</button>
			</div>
			<div>
				<a href="logout.jsp">logout</a>
			</div>

		</div>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Phone Num</th>
					<th scope="col">Address</th>
					<th scope="col">City</th>
					<th scope="col">Zip code</th>
					<th scope="col">State</th>
					<th scope="col">Country</th>
					<th scope="col">Update</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>


			<%
				SearchJdbc searchJdbc = new SearchJdbc();
				ArrayList<OperationsEnp> list = searchJdbc.sereahALl();
			%>
			<%
				for (OperationsEnp operationsEnp : list) {
			%>

			<tbody>
				<tr>
					<th scope="row"><%=operationsEnp.getPratyid()%></th>
					<td><%=operationsEnp.getFirstName()%></td>
					<td><%=operationsEnp.getLastName()%></td>
					<td><%=operationsEnp.getPhone()%></td>
					<td><%=operationsEnp.getAddress()%></td>
					<td><%=operationsEnp.getCity()%></td>
					<td><%=operationsEnp.getZip()%></td>
					<td><%=operationsEnp.getState()%></td>
					<td><%=operationsEnp.getCountry()%></td>
					<%-- 	<td><button type="submit" class="btn btn-warning"
							name="update" value=<%=%>>Update</button></td> --%>
					<td><a href="Update.jsp?id=<%=operationsEnp.getPratyid()%>">
							Update </a></td>
					<td><a href="DeleteSvt?id=<%=operationsEnp.getPratyid()%>">
							Delete </a></td>
					<%-- 	<td><button type="submit" class="btn btn-danger" name="delete"
							value=<%=operationsEnp.getPratyid()%>>Delete</button></td>
 --%>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</form>
</body>
</html>
