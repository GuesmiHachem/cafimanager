<#import "../temp1/defaultLayout.ftl" as layout>
<@layout.myLayout1 "Home page"> <!-- =================================================== -->

 <#if (cafes??)>
	List all cafes
	<br>
	<#list cafes as cafe>
		${cafe.id}
		<br>
		${cafe.nom}
	</#list>
 </#if>
 
  



 </@layout.myLayout1>