<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.pahanabookshop.model.Item" %>
<%
    Item item = (Item) request.getAttribute("item");
%>
<html>
<head>
    <title><%= (item != null) ? "Edit Item" : "Add Item" %></title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1><%= (item != null) ? "Edit Item" : "Add Item" %></h1>
    <form method="post" action="item">
        <input type="hidden" name="id" value="<%= (item != null) ? item.getItemId() : 0 %>">
        <label>Name:</label>
        <input type="text" name="name" value="<%= (item != null) ? item.getName() : "" %>" required>
        <label>Price:</label>
        <input type="number" step="0.01" name="price" value="<%= (item != null) ? item.getPrice() : "" %>" required>
        <label>Stock:</label>
        <input type="number" name="stock" value="<%= (item != null) ? item.getStock() : "" %>" required>
        <br><br>
        <input type="submit" value="Save">
    </form>
</div>
</body>
</html>
