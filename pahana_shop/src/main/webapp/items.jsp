<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="com.pahanabookshop.model.Item"%>
<html>
<head>
    <title>Items</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Items</h1>
    <a href="dashboard.jsp" class="back-link-top">Back</a>
    <br>
    <a href="item?action=add">Add New Item</a>
    <table>
        <tr>
            <th>ID</th><th>Name</th><th>Price</th><th>Stock</th><th>Actions</th>
        </tr>
        <%
            List<Item> items = (List<Item>) request.getAttribute("items");
            if(items != null){
                for(Item item: items){
        %>
        <tr>
            <td><%= item.getItemId() %></td>
            <td><%= item.getName() %></td>
            <td><%= item.getPrice() %></td>
            <td><%= item.getStock() %></td>
            <td>
                <a href="item?action=edit&id=<%=item.getItemId()%>">Edit</a> |
                <a href="item?action=delete&id=<%=item.getItemId()%>">Delete</a>
            </td>
        </tr>
        <%}}%>
    </table>
</div>
</body>
</html>
