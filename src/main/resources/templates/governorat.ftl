<#import "temp1/defaultLayout.ftl" as layout>
<@layout.myLayout1 "Home page"> 
<#if gov??>
${gov.id}
${gov.libell}
</#if>

	<#if governorats??>
	
	<table class="table">
	<thead>
		<th>Id</th>
		<th>Libelle</th>
		<th>List Delegation</th>
	</thead>
	<#list governorats as governorat>
	<tr>
		<td>${governorat.id}</td>
		<td>${governorat.libell}</td>
		<td><a href="/gouvernorat/${governorat.id}/delegation">view
				all</a> [${governorat.getDelegations()?size}]</td>
	</tr>
	</#list>
	</table>
	</#if>
	


</@layout.myLayout1>