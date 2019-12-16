<#import "/admin_layout/defaultLayout.ftl" as layout>
<#import "/spring.ftl" as spring />
<@layout.admin_layout "Home page"> 


Role:${control!'aa'} <br>
name : {auth.name!'ss'} <br>
email : @{auth.email!'dd'} 

<br>
<span class="text-danger"><@spring.message "welcome.message"/></span>
<br>
========
<br>

<#list usersNamesList as principal >
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
<br>

</#list> 

</@layout.admin_layout> 
