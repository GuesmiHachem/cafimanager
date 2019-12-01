<#import "temp1/defaultLayout.ftl" as layout>
<@layout.myLayout1 "Home page"> 



Role :${control!'aa'}
<br>
name : {auth.name!'ss'}
<br>
email : @{auth.email!'dd'}





</@layout.myLayout1>

