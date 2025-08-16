<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.pahanabookshop.model.Item" %>
<%
    Item item = (Item) request.getAttribute("item");
%>
<html>
<head>
    <title><%= (item != null) ? "Edit Item" : "Add Item" %> | Pahana Bookshop</title>
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

        input[type="text"], input[type="number"] {
            padding: 12px 14px;
            border: 1px solid #ddd;
            border-radius: 8px;
            font-size: 14px;
            margin-bottom: 18px;
            outline: none;
            transition: border-color 0.3s;
        }

        input[type="text"]:focus, input[type="number"]:focus {
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
    <h1><%= (item != null) ? "✏ Edit Item" : "➕ Add Item" %></h1>

    <form method="post" action="item">
        <input type="hidden" name="id" value="<%= (item != null) ? item.getItemId() : 0 %>">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" 
               value="<%= (item != null) ? item.getName() : "" %>" required>

        <label for="price">Price:</label>
        <input type="number" step="0.01" id="price" name="price" 
               value="<%= (item != null) ? item.getPrice() : "" %>" required>

        <label for="stock">Stock:</label>
        <input type="number" id="stock" name="stock" 
               value="<%= (item != null) ? item.getStock() : "" %>" required>

        <input type="submit" value="💾 Save">
    </form>

    <a href="item?action=list" class="back-link">⬅ Back to Items</a>
</div>
</body>
</html>
