<#import "/admin_layout/defaultLayout.ftl" as layout>
<#import "/spring.ftl" as spring />
<@layout.admin_layout "Home page"> 

<#if gov??> ${gov.id} ${gov.libell} </#if> <!-- =================================================== -->
<div class="row">
	<div class="col-lg-8" style="">
		<div class="ibox">
			<div class="ibox-head">
				<div class="ibox-title">Ajouter Governorat</div>
				<div class="ibox-tools">
					<a class="ibox-collapse"><i class="fa fa-minus"></i></a> <a
						class="dropdown-toggle" data-toggle="dropdown"><i
						class="fa fa-ellipsis-v"></i></a>
					<div class="dropdown-menu dropdown-menu-right">
						<a class="dropdown-item">option 1</a> <a class="dropdown-item">option
							2</a>
					</div>
				</div>
			</div>
			<div class="ibox-body">

				<form action="/governorat/add" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Libelle</label> <input type="text"
							class="form-control" name="libell">


					</div>

					<button type="submit" class="btn btn-primary">Ajouter</button>
				</form>
				<#if  errorMessage?? >
				<p class="text-danger">${errorMessage}</p>
				</#if> <#if governorats??> <#if errorDelete?? >
				<p class="text-danger">${errorDelete}</p>
				</#if>
			</div>
		</div>
	</div>
</div>



<div class="row">
	<div class="col-lg-8" style="">
		<div class="ibox">
			<div class="ibox-head">
				<div class="ibox-title">Liste des Governorats</div>
				<div class="ibox-tools">
					<a class="ibox-collapse"><i class="fa fa-minus"></i></a> <a
						class="dropdown-toggle" data-toggle="dropdown"><i
						class="fa fa-ellipsis-v"></i></a>
					<div class="dropdown-menu dropdown-menu-right">
						<a class="dropdown-item">option 1</a> <a class="dropdown-item">option
							2</a>
					</div>
				</div>
			</div>
			<div class="ibox-body">
				<table class="table table-striped table-hover">
					<thead>
						<th>Id</th>
						<th>Libelle</th>
						<th>List Delegation</th>
						<th>Delete</th>
					</thead>
					<tbody>
						<#list governorats as governorat>
						<tr>
							<td>${governorat.id}</td>
							<td>${governorat.libell}</td>
							<td><a href="/governorat/${governorat.id}/delegation">view
									all</a> [${governorat.getDelegations()?size}]</td>
							<td><#if  governorat.getDelegations()?size == 0> <a
									href="/governorat/delete/${governorat.id}"> delete</a> </#if> <#if governorat.getDelegations()?size gt  0>
								<a class="text-secondary" href="#"> delete</a> </#if></td>

						</tr>
						</#list>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>



</#if> </@layout.admin_layout>