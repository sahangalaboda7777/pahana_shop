<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="com.pahanabookshop.model.Customer"%>
<html>
<head>
    <title>Customers</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Customers</h1>
    <a href="customer?action=add">Add New Customer</a>
    <table>
        <tr>
            <th>Account No</th><th>Name</th><th>Address</th><th>Phone</th><th>Actions</th>
        </tr>
        <%
            List<Customer> customers = (List<Customer>) request.getAttribute("customers");
            if(customers != null){
                for(Customer c: customers){
        %>
        <tr>
            <td><%= c.getAccountNo() %></td>
            <td><%= c.getName() %></td>
            <td><%= c.getAddress() %></td>
            <td><%= c.getPhone() %></td>
            <td>
                <a href="customer?action=edit&accountNo=<%=c.getAccountNo()%>">Edit</a> |
                <a href="customer?action=delete&accountNo=<%=c.getAccountNo()%>">Delete</a>
            </td>
        </tr>
        <%}}%>
    </table>
</div>
</body>
</html>
