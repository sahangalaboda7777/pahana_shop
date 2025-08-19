<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>System Guide - Pahana Billing System</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            background: #f4f7fb;
            color: #333;
        }

        .container {
            max-width: 1240px;
            margin: 40px auto;
            padding: 30px;
            background: #fff;
            border-radius: 12px;
            box-shadow: 0 6px 15px rgba(0,0,0,0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
            font-size: 26px;
        }

        h2 {
            margin-top: 25px;
            color: #4facfe;
            font-size: 20px;
            border-left: 4px solid #4facfe;
            padding-left: 10px;
        }

        p, li {
            font-size: 15px;
            line-height: 1.6;
            color: #555;
        }

        ul {
            margin: 10px 0 15px 20px;
        }

        .section {
            margin-bottom: 30px;
        }

        .note {
            background: #f1faff;
            border-left: 4px solid #4facfe;
            padding: 10px 15px;
            border-radius: 6px;
            font-size: 14px;
            color: #333;
            margin-top: 10px;
        }

        .back-link-top {
            display: inline-block;
            margin-bottom: 20px;
            padding: 8px 15px;
            background: #ddd;
            border-radius: 6px;
            text-decoration: none;
            color: #333;
            font-size: 14px;
            font-weight: 500;
        }

        .back-link-top:hover {
            background: #bbb;
        }

        hr {
            margin: 30px 0;
            border: none;
            border-top: 1px solid #eee;
        }

        footer {
            text-align: center;
            font-size: 0.9em;
            color: #777;
        }
    </style>
</head>
<body>
    <div class="container">
        <a class="back-link-top" href="dashboard.jsp">⬅ Back</a>
        <h1>📘 System Guide</h1>

        <div class="section">
            <h2>🔐 Login</h2>
            <p>Enter your registered username and password on the login page to access the system.</p>
            <div class="note">Note: Make sure your account is active and credentials are correct.</div>
        </div>

        <div class="section">
            <h2>📦 Item Management</h2>
            <p>Navigate to the "Add Item" page to add a new product to the inventory.</p>
            <ul>
                <li>Fill in the item name, unit price, and stock quantity.</li>
                <li>Click "Submit" to save the item.</li>
            </ul>
            <p>Go to the "Item List" page to view or update existing items.</p>
        </div>

        <div class="section">
            <h2>🧾 Billing</h2>
            <p>To generate a bill:</p>
            <ul>
                <li>Select a customer or enter details.</li>
                <li>Choose items from the list and specify quantity.</li>
                <li>The total will be automatically calculated.</li>
                <li>Click "Generate Bill" to finalize and save.</li>
            </ul>
        </div>

        <div class="section">
            <h2>📄 View Bills</h2>
            <p>Go to the "View Bills" page to see previously generated bills with details.</p>
        </div>

        <div class="section">
            <h2>🚪 Logout</h2>
            <p>Click on the "Logout" button on the top menu to securely log out of the system.</p>
        </div>

        <hr>
        <footer>&copy; 2025 Pahana Billing System. All rights reserved.</footer>
    </div>
</body>
</html>
