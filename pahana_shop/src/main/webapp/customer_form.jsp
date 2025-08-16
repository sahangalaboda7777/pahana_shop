<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.pahanabookshop.model.Customer" %>
<%
    Customer customer = (Customer) request.getAttribute("customer");
%>
<html>
<head>
    <title><%= (customer != null) ? "Edit Customer" : "Add Customer" %></title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1><%= (customer != null) ? "Edit Customer" : "Add Customer" %></h1>
    <form method="post" action="customer">
        <label>Account No:</label>
        <input type="text" name="accountNo" value="<%= (customer != null) ? customer.getAccountNo() : "" %>" <%= (customer != null) ? "readonly" : "required" %>>
        <label>Name:</label>
        <input type="text" name="name" value="<%= (customer != null) ? customer.getName() : "" %>" required>
        <label>Address:</label>
        <input type="text" name="address" value="<%= (customer != null) ? customer.getAddress() : "" %>" required>
        <label>Phone:</label>
        <input type="text" name="phone" value="<%= (customer != null) ? customer.getPhone() : "" %>" required>
        <br><br>
        <input type="submit" value="Save">
    </form>
</div>
</body>
</html>
