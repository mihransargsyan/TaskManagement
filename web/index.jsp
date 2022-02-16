<%--
  Created by IntelliJ IDEA.
  User: NZP
  Date: 14.02.2022
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TaskManager</title>
</head>
<body>

<div style=" width: 500px;
             height: 500px;
             margin: auto">
<form style="width: 500px;
            height: 500px;
            margin: auto;"
      action="/TaskManagement_war_exploded/login" method="post">
    email: <br>
    <input type="email" name="email"><br>
    password: <br>
    <input type="password" name="password"><br>
    <input type="submit" value="ok">
</form>
</div>
</body>
</html>
