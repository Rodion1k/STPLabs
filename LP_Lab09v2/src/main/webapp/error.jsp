<%--
  Created by IntelliJ IDEA.
  User: Родион
  Date: 22.04.2022
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Error:${pageContext.errorData.statusCode}</h3>
<h4>${pageContext.exception}</h4>
<a href="${pageContext.request.contextPath}/index.jsp">Выход</a>
</body>
</html>
