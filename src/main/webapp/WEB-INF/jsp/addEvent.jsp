<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Event</title>
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
            color:#16a34a;
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
            background:#16a34a;
            color:white;
            border:none;
            border-radius:8px;
            margin-top:10px;
        }
    </style>
</head>
<body>

<div class="box">
    <h2>Add Event</h2>

    <form action="/add-event-form" method="post">
        <input type="text" name="id" placeholder="Event ID" required>
        <input type="text" name="name" placeholder="Event Name" required>
        <input type="text" name="type" placeholder="Event Type" required>
        <input type="text" name="date" placeholder="Date" required>
        <input type="text" name="venue" placeholder="Venue" required>
        <input type="text" name="seats" placeholder="Seats" required>
        <input type="text" name="price" placeholder="Price" required>
        <button type="submit">Add Event</button>
    </form>
</div>

</body>
</html>