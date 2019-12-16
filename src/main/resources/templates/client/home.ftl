<#import "/admin_layout/defaultLayout.ftl" as layout>
<#import "/spring.ftl" as spring />
<@layout.admin_layout "Home page"> 


Client
<br>
${Session.user!''}
<br>
${Session.role!''} 

</@layout.admin_layout> 
