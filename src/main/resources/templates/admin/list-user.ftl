<#import "/admin_layout/defaultLayout.ftl" as layout> <#import
	"/spring.ftl" as spring /> <@layout.admin_layout "Home page">

<div class="container">
	<div class="row">
		<div class="col-lg-12" style="">

			<div class="ibox-body1">
				<#if (RequestParameters.page??)> <#assign
					pp=RequestParameters.page?number> <#else> <#assign
					pp=0></#if>
				<table class="table table-responsive">
					<thead>
						<th>Id</th>
						<th>Nom</th>
						<th>Email</th>
						<th>Role</th>
						<th>Cafe</th>
						<th>Ville</th>
						<th>Delete</th>
						<th>Update</th>
					</thead>
					<tbody class="text-muted font-weight-lighter text-lowercase">
						<#list pageUsers as v>
						<tr>
							<td>${v.id}</td>
							<td><a href="/admin/user/${v.id}">${v.name}</a></td>
							<td>${v.email}</td>
							<td><#if (v.role??)> ${v.role.role} </#if></td>
							<td><#if (v.cafe??)> ${v.cafe.nom} </#if></td>
							<td><#if (v.ville??)> ${v.ville.libell} </#if></td>
							<td><a href="/admin/ville/delete/${v.id}">delete</a></td>
							<td><a href="/admin/ville/update/${v.id}">update</a></td>
						</tr>
						</#list>
					</tbody>
				</table>
				<nav aria-label="Page navigation example">
					<ul class="pagination">

						<#assign next=pp?number+1> <#assign prev=pp?number-1>
						<#if (prev gte 0)>
						<li class="page-item"><a class="page-link"
							href="/admin/listuser?page=${prev}">Previous</a></li>
						<#else>
						<li class="page-item disabled"><a class="page-link" href="#">Previous
						</a></li></#if> <#list pages as p> <#if (p?index== pp?number)>
						<li class="page-item active"><a class="page-link"
							href="/admin/listuser?page=${p?index}">${p?index}</a></li>
						<#else>
						<li class="page-item"><a class="page-link"
							href="/admin/listuser?page=${p?index}">${p?index}</a></li></#if> </#list> <#if (next lt
							pages?size)>
						<li class="page-item"><a class="page-link"
							href="/admin/listuser?page=${next}">Next</a></li>
						<#else>
						<li class="page-item disabled"><a class="page-link" href="#">Next</a></li></#if>
					</ul>
				</nav>


			</div>

		</div>
	</div>

</div>
</@layout.admin_layout>