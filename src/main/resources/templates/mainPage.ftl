<html>
<head>
    <title>Main page</title>
    <link href="css/mainPage.css" type="text/css" rel="stylesheet">
</head>
<body>

    <div class="header">
        <div class="logo">logo</div>
        <div class="username">username</div>
    </div>

    <div class="body">
        <#list instruments as instrument>
            <div class="item">
                <b>${instrument.type}</b>
                <b>${instrument.title}</b>
                <b>${instrument.description}</b>
                <b>${instrument.price}</b>
            </div>
        </#list>
    </div>

</body>
</html>