<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="com.pahanabookshop.model.Item"%>
<html>
<head>
    <title>Create Bill</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Create Bill</h1>
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <form method="post" action="bill">
        <label>Bill No:</label>
        <input type="text" name="billNo" required>
        <label>Account No:</label>
        <input type="text" name="accountNo" required>

        <h3>Select Items</h3>
        <table>
            <tr><th>Item</th><th>Price</th><th>Quantity</th></tr>
            <%
                List<Item> items = (List<Item>) request.getAttribute("items");
                if(items != null){
                    for(Item item: items){
            %>
            <tr>
                <td><%=item.getName()%></td>
                <td><%=item.getPrice()%></td>
                <td>
                    <input type="hidden" name="itemId" value="<%=item.getItemId()%>">
                    <input type="number" name="quantity" min="0" value="0">
                </td>
            </tr>
            <%}}%>
        </table>
        <br>
        <input type="submit" value="Create Bill">
    </form>
</div>
</body>
</html>
