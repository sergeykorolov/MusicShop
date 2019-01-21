<#import "parts/common.ftl" as c/>

<@c.page>
<#if isCurrentUser && comment??>
    <#include "parts/commentEdit.ftl"/>
</#if>

<#include "parts/commentList.ftl"/>

</@c.page>