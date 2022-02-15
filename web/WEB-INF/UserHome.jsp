<%@ page import="taskManagement.model.Task" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: NZP
  Date: 14.02.2022
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserHome</title>
</head>
<body>

<%
    List<Task> tasks = (List<Task>) request.getAttribute("tasks");
%>
<div style="width: 1000px;
            height: 500px;
            margin: auto">

    <h3 style="margin: auto"> MY TASKS: </h3>
    <table style="margin: auto" border="1">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>desc</th>
            <th>status</th>
            <th>deadline</th>
        </tr>
        <%
            for (Task task : tasks) { %>
        <tr>
            <td><%=task.getId()%>
            </td>
            <td><%=task.getName()%>
            </td>
            <td><%=task.getDescription()%>
            </td>
            <td><%=task.getStatus().name()%>
            </td>
            <td><%=task.getDeadline()%>
            </td>
        </tr>
        <% }
        %>
    </table>
</div>
</body>
</html>
