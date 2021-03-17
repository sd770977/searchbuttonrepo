<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Material Design Bootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.2/css/mdb.min.css"
	rel="stylesheet">
<link
	href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.min.css"
	rel="stylesheet">
<!-- JQuery -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.2/js/mdb.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.18/js/dataTables.bootstrap4.min.js"></script>


<title>Search Page</title>
<!-- <style type="text/css">
.table {
	margin-left: auto;
	margin-right: auto;
}
</style> -->
<script src="<c:url value="/resources/js/main.js"/>"></script>

</head>
<body>


	<form action="/searchbutton/search" method="get">
		<div class="">
			<div style="text-align: center; padding-top: 30px; border: blue;">
				<label for="searchtext"
					style="color: white-space; font-size: 70px; font-weight: bold;">Search
					Here</label> <br> <input type="text" id="searchtext"
					style="margin: 5px; border-radius: 7px; height: 40px; color:;"
					name="searchText">
				<button class="btn btn-primary" value="search">Search</button>
			</div>
		</div>
	</form>
	<c:if test="${not empty plist}">
		<table class="table table-striped table-bordered table-sm"
			cellspacing="0" width="100%" id="searchResultTable">
			<thead>
				<tr>
					<th class="th-sm">ID</th>
					<th class="th-sm">First Name</th>
					<th class="th-sm">Last Name</th>
					<th class="th-sm">EmailID</th>
					<th class="th-sm">Country Name</th>
				</tr>
			</thead>
			<tbody>
				<%
					int id = 1;
				%>
				<c:forEach items="${plist}" var="con">
					<tr>
						<td><%=id++%></td>
						<td><c:out value="${con.firstName}"></c:out></td>
						<td><c:out value="${con.lastName}"></c:out></td>
						<td><c:out value="${con.email}"></c:out></td>
						<td><c:out value="${con.country}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</c:if>
	<c:if test="${not empty message}">
		<h2>${message}</h2>
	</c:if>
</body>
</html>