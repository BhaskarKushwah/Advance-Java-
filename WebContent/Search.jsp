<%@page import="java.util.ArrayList"%>
<%@page import="service.OperationsEnp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="link.jsp"%>
<meta charset="ISO-8859-1">
<title>search</title>
<script>
function myFunction() {
  var x = document.getElementById("mySearch").value;
  document.getElementById("demo").innerHTML = x;
}
</script>

</head>
<body>

	<form action="HomeSvt">

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
					value="search" onclick="myFunction()">Search</button>
				<p id="demo"></p>
			</div>
		</div>
	</form>

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

			</tr>
		</thead>

		<%
			ArrayList<OperationsEnp> arrayList = (ArrayList) request.getAttribute("serach");
			if (arrayList != null) {
				for (OperationsEnp operationsEnp : arrayList) {
		%>


		<tbody>
			<tr>

				<td><%=operationsEnp.getFirstName()%></td>
				<td><%=operationsEnp.getLastName()%></td>
				<td><%=operationsEnp.getPhone()%></td>
				<td><%=operationsEnp.getAddress()%></td>
				<td><%=operationsEnp.getCity()%></td>
				<td><%=operationsEnp.getZip()%></td>
				<td><%=operationsEnp.getState()%></td>
				<td><%=operationsEnp.getCountry()%></td>
		</tbody>
		<%
			}
			}
		%>
	</table>

</body>
</html>
