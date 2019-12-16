<#import "/client_layout/defaultLayout.ftl" as layout>
<#import "/spring.ftl" as spring />
<@layout.client_layout "Home page"> 

 <#if (cafes??)>
	List all cafes
	<br>
	<#list cafes as cafe>
		${cafe.id}
		<br>
		${cafe.nom}
	</#list>
 </#if>
 
  



 </@layout.client_layout>