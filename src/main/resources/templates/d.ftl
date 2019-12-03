<#import "temp1/defaultLayout.ftl" as layout>
<#import "/spring.ftl" as spring />
<@layout.myLayout1 "Home page">
<br>
<#list roles as role>
${role!''} <br>
</#list> 

</@layout.myLayout1> 
