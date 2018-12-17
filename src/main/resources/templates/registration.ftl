<#import "parts/common.ftl" as c>

<@c.page>
<div class="mb-1">Add new user</div>
${message?ifExists}
<form action="/registration" method="post">
    <div><label> Username : <input type="text" name="username"/> </label></div>
    <div><label> Email : <input type="email" name="email"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div><input type="submit" value="Sign In"/></div>
</form>
</@c.page>