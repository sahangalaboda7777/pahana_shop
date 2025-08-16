<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="com.pahanabookshop.model.Customer"%>
<html>
<head>
    <title>Customers | Pahana Bookshop</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            background: #f4f7fb;
        }

        .container {
            max-width: 1000px;
            margin: 40px auto;
            padding: 20px;
            background: #fff;
            border-radius: 12px;
            box-shadow: 0 6px 15px rgba(0,0,0,0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
        }

        .back-link-top {
            display: inline-block;
            margin-bottom: 15px;
            padding: 8px 15px;
            background: #ddd;
            border-radius: 6px;
            text-decoration: none;
            color: #333;
            font-size: 14px;
        }

        .back-link-top:hover {
            background: #bbb;
        }

        .add-btn {
            display: inline-block;
            margin-bottom: 20px;
            padding: 10px 18px;
            background: linear-gradient(135deg, #4facfe, #00f2fe);
            color: white;
            border-radius: 8px;
            font-weight: 600;
            text-decoration: none;
            transition: background 0.3s;
        }

        .add-btn:hover {
            background: linear-gradient(135deg, #43e97b, #38f9d7);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }

        table th, table td {
            padding: 12px 15px;
            text-align: center;
            border-bottom: 1px solid #eee;
        }

        table th {
            background: #4facfe;
            color: white;
            font-weight: 600;
        }

        table tr:hover {
            background: #f1faff;
        }

        .action-links a {
            text-decoration: none;
            font-weight: 600;
            padding: 6px 12px;
            border-radius: 6px;
            margin: 0 3px;
            font-size: 13px;
            display: inline-block;
        }

        .action-links a.edit {
            background: #3498db;
            color: white;
        }

        .action-links a.edit:hover {
            background: #2980b9;
        }

        .action-links a.delete {
            background: #e74c3c;
            color: white;
        }

        .action-links a.delete:hover {
            background: #c0392b;
        }
    </style>
</head>
<body>
<div class="container">
    <a class="back-link-top" href="dashboard.jsp">⬅ Back</a>
    <h1>👥 Manage Customers</h1>
    
    <a href="customer?action=add" class="add-btn">+ Add New Customer</a>

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
            <td class="action-links">
                <a href="customer?action=edit&accountNo=<%=c.getAccountNo()%>" class="edit">✏ Edit</a>
                <a href="customer?action=delete&accountNo=<%=c.getAccountNo()%>" class="delete">🗑 Delete</a>
            </td>
        </tr>
        <%}}%>
    </table>
</div>
</body>
</html>
