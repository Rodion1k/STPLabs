<%--
  Created by IntelliJ IDEA.
  User: Родион
  Date: 21.04.2022
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="register" method="get">
    <h2>Register Form</h2>
    <h3 style="color: red">${message}</h3>
    <input type="text" name="username" placeholder="Enter userName" />
    <input type="password" name="password" placeholder="Enter password" />
    <input type="text" name="role" placeholder="Enter role" />
    <input type="submit" value="Register" />
</form>
<a href="${pageContext.request.contextPath}/LoginPass.jsp">login</a>
</body>
</html>
