<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Update Event</title>
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
            width:500px;
            border-radius:15px;
            box-shadow:0 8px 20px rgba(0,0,0,0.1);
        }

        h2{
            text-align:center;
            margin-bottom:20px;
            color:#f59e0b;
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
            background:#f59e0b;
            color:white;
            border:none;
            border-radius:8px;
        }
    </style>
</head>
<body>

<div class="box">
    <h2>Update Event</h2>

    <form action="/update-event-form" method="post">
        <input type="text" name="id" placeholder="Event ID" required>
        <input type="text" name="name" placeholder="New Event Name" required>
        <input type="text" name="type" placeholder="New Event Type" required>
        <input type="text" name="date" placeholder="New Date" required>
        <input type="text" name="venue" placeholder="New Venue" required>
        <input type="text" name="seats" placeholder="New Seats" required>
        <input type="text" name="price" placeholder="New Price" required>
        <button type="submit">Update Event</button>
    </form>
</div>

</body>
</html>