<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.pahanabookshop.model.User" %>
<%
    User user = (User) session.getAttribute("currentUser");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Dashboard | Pahana Bookshop</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            background: #f4f7fb;
        }

        .navbar {
            background: linear-gradient(135deg, #4facfe, #00f2fe);
            padding: 15px 25px;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar h1 {
            margin: 0;
            font-size: 20px;
            font-weight: 600;
        }

        .navbar a {
            color: white;
            text-decoration: none;
            margin-left: 20px;
            font-size: 14px;
            font-weight: 500;
        }

        .navbar a:hover {
            text-decoration: underline;
        }

        .container {
            max-width: 900px;
            margin: 40px auto;
            padding: 20px;
        }

        .welcome {
            text-align: center;
            margin-bottom: 30px;
        }

        .welcome h2 {
            font-size: 22px;
            color: #333;
            font-weight: 600;
        }

        .cards {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
            gap: 20px;
        }

        .card {
            background: #fff;
            padding: 25px;
            border-radius: 12px;
            text-align: center;
            box-shadow: 0 6px 15px rgba(0,0,0,0.1);
            transition: transform 0.2s, box-shadow 0.2s;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 20px rgba(0,0,0,0.15);
        }

        .card a {
            text-decoration: none;
            color: #4facfe;
            font-size: 16px;
            font-weight: 600;
        }

        .card a:hover {
            color: #43e97b;
        }

        .logout-btn {
            background: #e74c3c;
            padding: 10px 16px;
            border-radius: 8px;
            color: #fff !important;
            font-size: 14px;
            font-weight: 600;
            transition: background 0.3s;
        }

        .logout-btn:hover {
            background: #c0392b;
        }
    </style>
</head>
<body>

<div class="navbar">
    <h1>Pahana Bookshop</h1>
    <div>
        <a href="#">Dashboard</a>
        <a href="login.jsp" class="logout-btn">Logout</a>
    </div>
</div>

<div class="container">
    <div class="welcome">
        <h2>Welcome, <%= user.getUsername() %> 👋</h2>
        <p>Select a module to manage the system.</p>
    </div>

    <div class="cards">
        <div class="card">
            <a href="item?action=list">📚 Manage Items</a>
        </div>
        <div class="card">
            <a href="customer?action=list">👥 Manage Customers</a>
        </div>
        <div class="card">
            <a href="bill?action=list">🧾 Manage Bills</a>
        </div>
    </div>
</div>

</body>
</html>
