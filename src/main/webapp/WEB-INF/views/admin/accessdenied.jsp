<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Access Denied</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background:#f0f2f5; }
        .box {
            max-width:500px; margin:150px auto;
            background:white; padding:50px;
            border-radius:12px; text-align:center;
            box-shadow:0 4px 20px rgba(0,0,0,0.1);
        }
        .box h1 { font-size:5rem; }
        .box h3 { color:#dc2626; }
        .box p  { color:#888; }
    </style>
</head>
<body>
    <div class="box">
        <h1>🚫</h1>
        <h3>Access Denied!</h3>
        <p>You don't have permission to view this page.</p>
        <p>Only <strong>Super Admins</strong> can access this area.</p>
        <a href="/admin/dashboard" class="btn btn-primary mt-3">
            Go Back to Dashboard
        </a>
    </div>
</body>
</html>