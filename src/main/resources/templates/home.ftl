<#import "temp1/defaultLayout.ftl" as layout>
<@layout.myLayout1 "Home page"> Role :${control!'aa'} <br>
name : {auth.name!'ss'} <br>
email : @{auth.email!'dd'} 

<br>
<span class="text-danger"><@spring.message "welcome.message"/></span>
<br>
========
<br>
<#list usersNamesList as principal>
getUsername :${principal.getUsername()!''} <br>
getPassword :${principal.getPassword()!''} <br>
<#if principal.isAccountNonExpired()> 
isAccountNonExpired : yes
</#if>
<br>
<#if principal.isAccountNonLocked()> 
isAccountNonLocked : yes
</#if>
<br>
<#if principal.isEnabled()> 
isEnabled : yes
</#if>
<br>





<br>
========
<br>
</#list> 

</@layout.myLayout1> 
