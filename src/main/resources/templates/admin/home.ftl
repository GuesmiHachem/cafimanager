<#import "/admin_layout/defaultLayout.ftl" as layout>
<#import "/spring.ftl" as spring />
<@layout.admin_layout "Home page"> 

ADMIN
<br>
${Session.user!''}
<br>
${Session.role!''} 
		

</@layout.admin_layout> 
