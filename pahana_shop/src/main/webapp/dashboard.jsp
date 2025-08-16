<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.pahanabookshop.model.User" %>
<%
    User user = (User) session.getAttribute("currentUser");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Welcome, <%= user.getUsername() %></h1>
    <ul>
        <li><a href="item?action=list">Manage Items</a></li>
        <li><a href="customer?action=list">Manage Customers</a></li>
        <li><a href="bill?action=list">Manage Bills</a></li>
        <li><a href="login.jsp">Logout</a></li>
    </ul>
</div>
</body>
</html>
