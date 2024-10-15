<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h2>User 상세 정보</h2>
	<ul>
	    <!-- html comment -->
	    <%-- jsp comment ${} --%>
		<li>ID = ${user.id} </li>
		<li>UserId = ${user.userId} </li>
		<li>Name = ${user.name} </li>
		<li>Gender = ${user.gender} </li>
		<li>City = ${user.city} </li>
	</ul>
</body>
</html>