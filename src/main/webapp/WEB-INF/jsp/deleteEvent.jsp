<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Delete Event</title>
    <style>
        body{
            font-family:Arial;
            background:#f3f4f6;
            display:flex;
            justify-content:center;
            align-items:center;
            height:100vh;
        }

        .box{
            background:white;
            padding:40px;
            width:400px;
            border-radius:15px;
            box-shadow:0 8px 20px rgba(0,0,0,0.1);
        }

        h2{
            text-align:center;
            margin-bottom:20px;
            color:#dc2626;
        }

        input{
            width:100%;
            padding:12px;
            margin:8px 0;
            border:1px solid #ccc;
            border-radius:8px;
        }

        button{
            width:100%;
            padding:12px;
            background:#dc2626;
            color:white;
            border:none;
            border-radius:8px;
        }
    </style>
</head>
<body>

<div class="box">
    <h2>Delete Event</h2>

    <form action="/delete-event-form" method="post">
        <input type="text" name="id" placeholder="Enter Event ID" required>
        <button type="submit">Delete Event</button>
    </form>
</div>

</body>
</html>