<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Loading...</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <meta http-equiv="refresh" content="3;URL=login.jsp">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(135deg, #4facfe, #00f2fe);
            color: #fff;
            flex-direction: column;
            text-align: center;
        }

        .container {
            background: rgba(255, 255, 255, 0.1);
            padding: 30px 50px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
        }

        h2 {
            margin-bottom: 20px;
            font-size: 24px;
            font-weight: 600;
        }

        p {
            margin-top: 20px;
            font-size: 16px;
        }

        .spinner {
            width: 60px;
            height: 60px;
            border: 6px solid rgba(255,255,255,0.3);
            border-top-color: #fff;
            border-radius: 50%;
            animation: spin 1s linear infinite;
            margin: 0 auto;
        }

        @keyframes spin {
            0% { transform: rotate(0deg);}
            100% { transform: rotate(360deg);}
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>WELCOME TO PAHANA BOOKSHOP SYSTEM</h2>
        <div class="spinner"></div>
        <p>Loading, please wait...</p>
    </div>
</body>
</html>
