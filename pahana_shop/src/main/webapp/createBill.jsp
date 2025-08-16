<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="com.pahanabookshop.model.Item"%>
<html>
<head>
    <title>Create Bill | Pahana Bookshop</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            background: #f4f7fb;
        }

        .container {
            max-width: 700px;
            margin: 50px auto;
            padding: 30px;
            background: #fff;
            border-radius: 12px;
            box-shadow: 0 6px 15px rgba(0,0,0,0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
        }

        h3 {
            margin-top: 25px;
            color: #555;
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
            padding: 10px 12px;
            margin-bottom: 18px;
            border-radius: 8px;
            border: 1px solid #ddd;
            font-size: 14px;
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
            margin-top: 15px;
        }

        input[type="submit"]:hover {
            background: linear-gradient(135deg, #43e97b, #38f9d7);
        }

        .back-link {
            display: inline-block;
            margin-top: 15px;
            text-decoration: none;
            font-size: 14px;
            color: #4facfe;
            font-weight: 500;
        }

        .back-link:hover {
            text-decoration: underline;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }

        table th, table td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #eee;
        }

        table th {
            background: #4facfe;
            color: white;
            font-weight: 600;
        }

        table tr:nth-child(even) {
            background: #f9f9f9;
        }

        table tr:hover {
            background: #f1faff;
        }

        input[type="number"] {
            width: 60px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>➕ Create Bill</h1>

    <form method="post" action="bill">
        <label>Bill No:</label>
        <input type="text" name="billNo" required>

        <label>Customer:</label>
<select name="accountNo" required>
    <option value="">-- Select Customer --</option>
    <%
        List<com.pahanabookshop.model.Customer> customers = 
            (List<com.pahanabookshop.model.Customer>) request.getAttribute("customers");
        if(customers != null){
            for(com.pahanabookshop.model.Customer cust : customers){
    %>
        <option value="<%=cust.getAccountNo()%>">
            <%=cust.getName()%> ( <%=cust.getAccountNo()%> )
        </option>
    <%
            }
        }
    %>
</select>

        <h3>Select Items</h3>
        <table>
            <tr>
                <th>Item</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
            <%
                List<Item> items = (List<Item>) request.getAttribute("items");
                if(items != null){
                    for(Item item: items){
            %>
            <tr>
                <td><%=item.getName()%></td>
                <td>Rs. <%=item.getPrice()%></td>
                <td>
                    <input type="hidden" name="itemId" value="<%=item.getItemId()%>">
                    <input type="number" name="quantity" min="0" value="0">
                </td>
            </tr>
            <%}}%>
        </table>

        <input type="submit" value="💾 Create Bill">
    </form>
</div>
</body>
</html>
