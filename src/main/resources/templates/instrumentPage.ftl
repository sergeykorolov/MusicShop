<html>
<head>
    <title>Instrument page</title>
</head>
<body>
    <div class="body">
        <b>${instrument.type}</b>
        <b>${instrument.title}</b>
        <b>${instrument.description}</b>
        <b>${instrument.price}</b>
    </div>

    <div>Comments</div>

    <div>
        <form action="/musicShop/instrumentPage" method="post">
            <input type="text" name="text" placeholder="Enter comment">
            <input type="hidden" name="instrumentId" value="${instrument.id}">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit">Add comment</button>
        </form>
    </div>

    <#list comments as comment>
        <div>
            <i>${comment.text}</i>
            <i>${comment.date}</i>
        </div>
    </#list>
</body>
</html>