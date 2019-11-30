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
 
  ${user1}

 <#if (user??)>${user.email}</#if>
 <#if (listcafes??)>
	List des cafes de <#if (user??)>${user.email}</#if>
	<br>
	<#list listcafes as cafe1>
		${cafe1.id}
		<br>
		${cafe1.nom}
	</#list>
 </#if>


 </@layout.myLayout1>