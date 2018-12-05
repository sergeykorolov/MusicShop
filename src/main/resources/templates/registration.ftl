<html>
<head>
    <title>Spring Security Example </title>
</head>
<body>
Add new user
<#--<#if message.>-->
    <#--${message}-->
<#--<#else>-->
    <#--message-->
<#--</#if>-->

<form action="/registration" method="post">
    <div><label> Username : <input type="text" name="username"/> </label></div>
    <div><label> Email : <input type="email" name="email"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div><input type="submit" value="Sign In"/></div>
</form>
</body>
</html>