<#import "temp1/defaultLayout.ftl" as layout>
<@layout.myLayout1 "Home page"> 
<#if delegation??>
${delegation.id}
${delegation.libell}
</#if>

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
	


</@layout.myLayout1>