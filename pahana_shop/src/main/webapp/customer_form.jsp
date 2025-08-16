<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.pahanabookshop.model.Customer" %>
<%
    Customer customer = (Customer) request.getAttribute("customer");
%>
<html>
<head>
    <title><%= (customer != null) ? "Edit Customer" : "Add Customer" %> | Pahana Bookshop</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            background: #f4f7fb;
        }

        .container {
            max-width: 500px;
            margin: 60px auto;
            padding: 30px 25px;
            background: #fff;
            border-radius: 12px;
            box-shadow: 0 6px 15px rgba(0,0,0,0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 6px;
            font-size: 14px;
            font-weight: 500;
            color: #444;
        }

        input[type="text"] {
            padding: 12px 14px;
            border: 1px solid #ddd;
            border-radius: 8px;
            font-size: 14px;
            margin-bottom: 18px;
            outline: none;
            transition: border-color 0.3s;
        }

        input[type="text"]:focus {
            border-color: #4facfe;
        }

        input[type="submit"] {
            background: linear-gradient(135deg, #4facfe, #00f2fe);
            border: none;
            padding: 12px;
            border-radius: 8px;
            color: #fff;
            font-weight: 600;
            font-size: 15px;
            cursor: pointer;
            transition: background 0.3s;
        }

        input[type="submit"]:hover {
            background: linear-gradient(135deg, #43e97b, #38f9d7);
        }

        .back-link {
            display: inline-block;
            margin-top: 15px;
            text-decoration: none;
            font-size: 13px;
            color: #4facfe;
        }

        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h1><%= (customer != null) ? "✏ Edit Customer" : "➕ Add Customer" %></h1>

    <form method="post" action="customer">
        <label>Account No:</label>
        <input type="text" name="accountNo" 
               value="<%= (customer != null) ? customer.getAccountNo() : "" %>" 
               <%= (customer != null) ? "readonly" : "required" %>>

        <label>Name:</label>
        <input type="text" name="name" 
               value="<%= (customer != null) ? customer.getName() : "" %>" required>

        <label>Address:</label>
        <input type="text" name="address" 
               value="<%= (customer != null) ? customer.getAddress() : "" %>" required>

        <label>Phone:</label>
        <input type="text" name="phone" 
               value="<%= (customer != null) ? customer.getPhone() : "" %>" required>

        <input type="submit" value="💾 Save">
    </form>

    <a href="customer?action=list" class="back-link">⬅ Back to Customers</a>
</div>
</body>
</html>
