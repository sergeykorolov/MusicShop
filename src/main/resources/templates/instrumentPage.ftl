<#import "parts/common.ftl" as c>

<@c.page>
<div class="body">
    <b>${instrument.type}</b>
    <b>${instrument.title}</b>
    <b>${instrument.description}</b>
    <b>${instrument.price}</b>
</div>

<div>Comments</div>

<div>
    <form action="/musicShop/instrumentPage" method="post" enctype="multipart/form-data">
        <input type="text" name="text" placeholder="Enter comment">
        <input type="hidden" name="instrumentId" value="${instrument.id}">
        <input type="file" name="file">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Add comment</button>
    </form>
</div>
    <#list comments as comment>
        <div>
            <b>${(comment.author.username)!"&lt;none&gt;"}: </b>
            <i>${comment.text}</i>
            <i>${comment.date}</i>
            <div>
                <#if comment.filename??>
                    <img src="/img/${comment.filename}">
                </#if>
            </div>
        </div>
    <#else>
        <i>No message</i>
    </#list>
</@c.page>