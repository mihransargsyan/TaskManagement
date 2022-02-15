 <%@ page import="taskManagement.model.User" %>
<%@ page import="java.util.List" %>
 <%--
  Created by IntelliJ IDEA.
  User: NZP
  Date: 14.02.2022
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ManagerHome</title>
</head>
<body>

<%
    List<User> allUsers = (List<User>) request.getAttribute("allUsers");
%>
<div style="width: 1000px;
            height: 500px;
            margin: auto">

    <div style="float: left;
                width: 500px;
                height: 500px">
        <h3 style="margin: auto"> ADD USSER </h3>
        <form style="margin: auto" action="/TaskManagement_war_exploded/AddUser" method="post">
            Name:<br>
            <input type="text" name="name"><br>
            Surname:<br>
            <input type="text" name="surname"><br>
            email: <br>
            <input type="email" name="email"><br>
            password: <br>
            <input type="password" name="password"><br>
            UserType:<br>
            <select name="userType">
                <option value="USER">USER</option>
                <option value="MANAGER">MANAGER</option>
            </select><br>
            <input type="submit" value="ok">
        </form>
    </div>

    <div style="float: left;
                width: 500px;
                height: 500px">
        <h3 style="margin: auto"> ADD TASK </h3>
        <form style="margin: auto" action="/TaskManagement_war_exploded/AddTask" method="post">
            Name:<br>
            <input type="text" name="name"><br>
            Description:<br>
            <input type="text" name="desc"><br>
            UserEmal:<br>
            <select name="userEmail">
            <% for (User allUser : allUsers) {%>
                <option><%=allUser.getEmail()%>
                </option>
            <% }
            %>
            </select><br>
            Status: <br>
            <select name="status">
                <option value="NEW">NEW</option>
                <option value="IN_PROCESS">IN_PROCESS</option>
                <option value="FINESHED">FINESHED</option>
            </select><br>
            Deadline (calendar): <br>
            <input type="date" name="deadline"><br>
            <input type="submit" value="ok">
        </form>
    </div>
</div>
</body>
</html>
