<html>
<head>
    <title>Main page</title>
    <link href="css/mainPage.css" type="text/css" rel="stylesheet">
</head>
<body>

    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Sign Out"/>
    </form>

    <span><a href="/user">User list</a></span>

    <div class="header">
        <div class="logo">logo</div>
        <div class="username">username</div>
    </div>

    <div class="body">
        <#list instruments as instrument>
            <a href="/musicShop/instrumentPage?instrumentId=${instrument.id}">
                <div class="item">
                    <b>${instrument.type}</b>
                    <b>${instrument.title}</b>
                    <b>${instrument.description}</b>
                    <b>${instrument.price}</b>
                </div>
            </a>
        </#list>
    </div>

</body>
</html>