<#import "../temp1/defaultLayout.ftl" as layout>
<@layout.myLayout1 "Home page"> 

<button href="#" onclick="loada('fr');">francais</button>
<a href="/?lang=en">anglais</a>
<a href="/?lang=ar">arabe</a>



ADMINNNNNNNNNNN
Role :${control}
<br>
name : ${auth.name}
<br>
email : ${auth.email}





</@layout.myLayout1>

