
<#import "/temp1/defaultLayout.ftl" as layout> <#import
	"/spring.ftl" as spring /> <@layout.myLayout1 "Home page"> <!-- *************************************************** -->
<!-- *************************************************** --> <!-- *************************************************** -->
<#if (ville??)> <#if (ville.id!=0)>
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
					<div class="col-lg-6">${ville.id!} ${ville.libell!}</div>
				</div>

			</div>

		</div>
	</div>
</div>
</#if> </#if> <!-- *************************************************** --> <!-- *************************************************** -->
<!-- *************************************************** --> <#if
	(governorats?? && delegations??)>
<div class="row">
	<div class="col-lg-8" style="">
		<div class="ibox">
			<div class="ibox-head">
				<div class="ibox-title">Ajouter une ville :</div>
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
							<@spring.bind "ville" />
							<form action="/admin/ville/add" method="post">
												<label class="form-control-label">libell</label>
												<@spring.formInput "ville.libell" /><br> <br>
												<label class="form-control-label">Délegation</label>
												<@spring.showErrors "</br>" /> <br> <select
									name="delegation">
									
													<#list delegations as delegation>
													<option value="${delegation.id}">${delegation.libell}</option>
													</#list>
												</select> <br><br>
												<button type="submit" class="btn btn-primary">Ajouter</button>
											</form>
										</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</#if> <!-- *************************************************** --> <!-- *************************************************** -->
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
				<#if (RequestParameters.page??)> <#assign
					pp=RequestParameters.page?number> <#else> <#assign
					pp=0></#if>
				<table class="table table-striped table-hover">
					<thead>
						<th>Id</th>
						<th>Libelle</th>
						<th>Delegation</th>
						<th>Action</th>
					</thead>
					<tbody>
						<#list pageVilles as v>
						<tr>
							<td>${v.id}</td>
							<td><a href="/admin/ville/${v.id}">${v.libell}</a></td>
							<td><#if (v.delegation??)&&(v.delegation.id??)> <a
									href="/delegation/${v.delegation.id}"> <#if
										(v.delegation??)> ${v.delegation.libell} </#if>
								</a> <#else> no data </#if></td>
							<td><a href="/admin/ville/delete/${v.id}">delete</a></td>
						</tr>
						</#list>
					</tbody>
				</table>
				<nav aria-label="Page navigation example">
					<ul class="pagination">

						<#assign next=pp?number+1> <#assign prev=pp?number-1>
							
						
						
						
					    <#if (prev gte 0)>
							<li class="page-item"><a class="page-link"
							href="/admin/ville?page=${prev}">Previous</a></li>
							<#else>
							<li class="page-item disabled"><a class="page-link" href="#">Previous </a></li>
					    </#if>
							
						<#list pages as p>
						
						<#if (p?index== pp?number)>
						    <li class="page-item active"><a class="page-link"
							href="/admin/ville?page=${p?index}">${p?index}</a>
							</li>
						<#else>	
							<li class="page-item"><a class="page-link"
							href="/admin/ville?page=${p?index}">${p?index}</a>
							</li>
						</#if>
							
						</#list>
						
						
							<#if (next lt pages?size)>
							<li class="page-item"><a class="page-link"
							href="/admin/ville?page=${next}">Next</a></li>
							<#else>
							<li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
							</#if>
						
					
					
					
					</ul>
				</nav>


			</div>
		</div>
	</div>
</div>
</@layout.myLayout1> 