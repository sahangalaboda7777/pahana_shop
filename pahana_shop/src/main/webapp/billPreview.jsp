<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="com.pahanabookshop.model.Bill"%>
<html>
<head>
    <title>Bills | Pahana Bookshop</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            background: #f4f7fb;
        }

        .container {
            max-width: 1000px;
            margin: 50px auto;
            padding: 25px;
            background: #fff;
            border-radius: 12px;
            box-shadow: 0 6px 15px rgba(0,0,0,0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .back-link-top {
            display: inline-block;
            margin-bottom: 15px;
            text-decoration: none;
            font-size: 14px;
            color: #4facfe;
            font-weight: 500;
        }

        .back-link-top:hover {
            text-decoration: underline;
        }

        a[href*="create"] {
            display: inline-block;
            margin-bottom: 20px;
            padding: 10px 16px;
            background: linear-gradient(135deg, #4facfe, #00f2fe);
            color: #fff;
            border-radius: 8px;
            text-decoration: none;
            font-size: 14px;
            font-weight: 600;
            transition: background 0.3s;
        }

        a[href*="create"]:hover {
            background: linear-gradient(135deg, #43e97b, #38f9d7);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }

        table th, table td {
            padding: 12px 15px;
            border: 1px solid #ddd;
            text-align: center;
            font-size: 14px;
        }

        table th {
            background: #4facfe;
            color: #fff;
        }

        table tr:nth-child(even) {
            background: #f9f9f9;
        }

        table tr:hover {
            background: #f1faff;
        }
    </style>
</head>
<body>
<div class="container">
    <a class="back-link-top" href="dashboard.jsp">⬅ Back to Dashboard</a>
    <h1>📜 All Bills</h1>
    <a href="bill?action=create">➕ Create New Bill</a>
    <table>
        <tr>
            <th>Bill No</th>
            <th>Account No</th>
            <th>Date</th>
            <th>Total Amount</th>
        </tr>
        <%
            List<Bill> bills = (List<Bill>) request.getAttribute("bills");
            if(bills != null){
                for(Bill bill: bills){
        %>
        <tr>
            <td><%=bill.getBillNo()%></td>
            <td><%=bill.getAccountNo()%></td>
            <td><%=bill.getBillDate()%></td>
            <td><%=bill.getTotalAmount()%></td>
        </tr>
        <%}}%>
    </table>
</div>
</body>
</html>
