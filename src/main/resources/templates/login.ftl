<#import "parts/common.ftl" as c>

<@c.page>
Login page
<form action="/login" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> User name :</label>
        <div class="col-sm-6">
            <input type="text" name="username" class="form-control" placeholder="User name"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password:</label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Password"/>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <a href="/registration">Sign up</a>
    <button class="btn btn-primary" type="submit">Sign In</button>
</form>
</@c.page>
