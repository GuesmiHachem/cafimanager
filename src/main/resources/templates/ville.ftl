<#import "temp1/defaultLayout.ftl" as layout>


<@layout.myLayout1 "Home page">
<!-- *************************************************** -->
<!-- *************************************************** -->
<!-- *************************************************** -->
<#if (ville??)>
<div class="row">
	<div class="col-lg-8" style="">
		<div class="ibox">
			<div class="ibox-head">
				<div class="ibox-title">Ville</div>
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
				<div class="row">
					<div class="col-lg-1"></div>
					<div class="col-lg-6">
						 ${ville.id} ${ville.libell}
					</div>
				</div>

			</div>

		</div>
	</div>
</div>
 </#if>
<!-- *************************************************** -->
<!-- *************************************************** -->
<!-- *************************************************** -->
<div class="row">
	<div class="col-lg-8" style="">
		<div class="ibox">
			<div class="ibox-head">
				<div class="ibox-title">Ajouter une ville</div>
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
				<div class="row">
					<div class="col-lg-1"></div>
					<div class="col-lg-6">

						<div class="form-group">
							<form action="/ville/add" method="post">
								<div class="form-group">
									<label for="exampleInputEmail1">Libelle</label> <input
										type="text" class="form-control" name="libell">
								</div>
								<label class="form-control-label">Delegation</label> <select
									class="form-control select2_demo_1" name="delegation">
									<#list governorats as governorat>
									<optgroup label="${governorat.libell}">
										<#list governorat.getDelegations() as d>
										<option value="${d.id}">${d.libell}</option>
										</#list>
									</optgroup>
									</#list>

								</select>
								<br><br>
								<button type="submit" class="btn btn-primary">Ajouter</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- *************************************************** -->
<!-- *************************************************** -->
<!-- *************************************************** -->
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
						<th>Delegation</th>
					</thead>
					<tbody>
						<#list villes as ville>
						<tr>
							<td>${ville.id}</td>
							<td><a href="/ville/${ville.id}">${ville.libell}</a></td>
							<td><#if (ville.delegation??)> <a
									href="/delegation/${ville.delegation.id}"> <#if
										(ville.delegation??)> ${ville.delegation.libell} </#if>
								</a>
								<#else> no data </#if></td>

						</tr>
						</#list>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</@layout.myLayout1>