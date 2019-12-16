<#import "/admin_layout/defaultLayout.ftl" as layout>
<#import "/spring.ftl" as spring />
<@layout.admin_layout "Home page"> 
<#if delegation??>
${delegation.id}
${delegation.libell}
</#if>

by bilel
	<#if delegations??>
	
	<table class="table">
	<thead>
		<th>Id</th>
		<th>Libelle</th>
		<th>List villes</th>
	</thead>
	<#list delegations as delegation>
	<tr>
		<td>${delegation.id}</td>
		<td>${delegation.libell}</td>
		<td><a href="/delegation/${delegation.id}/ville">view
				all</a> [${delegation.getVilles()?size}]</td>
	</tr>
	</#list>
	</table>
	</#if>
	


</@layout.admin_layout>