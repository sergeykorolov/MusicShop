<html>
<head>
    <title>Login</title>
</head>
<body>
Login page
<form action="/login" method="post">
    <div><label> Username : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div><input type="submit" value="Sign In"/></div>
</form>
<a href="/registration">Sign up</a>
</body>
</html>