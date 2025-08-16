<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="com.pahanabookshop.model.Bill"%>
<html>
<head>
    <title>Bills</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>All Bills</h1>
    <a href="bill?action=create">Create New Bill</a>
    <table>
        <tr>
            <th>Bill No</th><th>Account No</th><th>Date</th><th>Total Amount</th>
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
