<#import "temp1/defaultLayout.ftl" as layout>
<@layout.myLayout1 "Home page"> 

Role :${control}
<br>
name : ${auth.name}
<br>
email : ${auth.email}



</@layout.myLayout1>