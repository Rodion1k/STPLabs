<%@ page import="java.time.LocalDate" %>
<%@ page import="com.example.lp_lab09v2.Components.List" %>
<%@ page import="com.example.lp_lab09v2.Components.Subject" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lp_lab09v2.DB.ConnectorDb" %><%--
  Created by IntelliJ IDEA.
  User: Родион
  Date: 21.04.2022
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <style>
        table{
            border: 1px solid black;
            text-align: center;
            border-collapse: collapse;
        }
        td{
            border: 1px solid black;
            text-align: center;
            padding: 5px;
        }
        div > input{
            margin-top: 10px;
            display: inline-block;
        }
        .Info > input{
            margin-top: 10px;
            display: block;
        }
    </style>
</head>
<body>
<h1>Welcome ${username}</h1>
<p>role: ${role}</p>
<p>current date: <%= LocalDate.now() %></p>
<form action="AddServlet" method="get">
    <div class="Info">
        <h3>Refactor Form</h3>
        <input type="text" name="group" placeholder="Enter group" />
        <input type="text" name="auditorium" placeholder="Enter auditorium" />
        <input type="text" name="subject" placeholder="Enter subject" />
        <input type="text" name="teacher" placeholder="Enter teacher" />
        <input type="text" name="weekDay" placeholder="Enter weekDay" />
        <input type="submit" value="Add" />
    </div>
</form>

<h3>Time Table:</h3>
<table>
    <tr>
        <td>Group</td>
        <td>Auditorium</td>
        <td>Subject</td>
        <td>Teacher</td>
        <td>Week Day</td>
    </tr>
    <%
        try {
            ConnectorDb connectorDb = new ConnectorDb();
            List subjects = new List(connectorDb.getConnection("TimeTableDb"));
            ArrayList<Subject> listChannel = subjects.getList();
            for (Subject subject : listChannel) {
    %>
    <tr>
        <td><%=subject.getGroup()%></td>
        <td><%=subject.getAuditorium()%></td>
        <td><%=subject.getSubject()%></td>
        <td><%=subject.getTeacher()%></td>
        <td><%=subject.getWeekDay()%></td>
    </tr>
    <%
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</table>
<a href="${pageContext.request.contextPath}/index.jsp">Выход</a>
</body>
</html>