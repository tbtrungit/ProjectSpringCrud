<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounts page.</title>
<script>
function confirmDelete(delUrl) {
    if (confirm("Are you sure ?")) {
        document.location = delUrl;
    }
}
</script>
</head>
<body>
	<form:form action="${deleteStudent}"
         onsubmit="confirmDelete('${pageContext.request.contextPath}/deleteStudent')">
	<h2>Wellcome to my page</h2>
	<table class="table" border="1">
		<tbody>
			<tr>
				<td><p>Id</p></td>
				<td><p>First_Name</p></td>
				<td><p>LastName</p></td>
				<td><p>Action</p></td>
			</tr>
			<c:forEach items="${students}" var="account">
				<tr>
					<td><p>${account.id}</p></td>
					<td><p>${account.firstName}</p></td>
					<td><p>${account.lastName}</p></td>
					<td><a href="<c:url value='/editStudent?id=${account.id}' />">Update</a>|
					<td><a href="<c:url value='/deleteStudent/${account.id}' />">Delete</a>|
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</form:form>
	<a href="addStudent">Click here to add Student</a>
	



</body>
</html>