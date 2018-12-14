<#import "parts/common.ftl" as c>

<@c.page>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Sign Out"/>
</form>

    <span><a href="/user">User list</a></span>

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
</@c.page>

