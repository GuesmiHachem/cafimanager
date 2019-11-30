



<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width initial-scale=1.0">
<title>Admincast bootstrap 4 &amp; angular 5 admin template,
	Шаблон админки | Form Advanced Plugins</title>
<!-- GLOBAL MAINLY STYLES-->
<link href="/static/assets/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="/static/assets/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="../../static/assets/vendors/themify-icons/css/themify-icons.css"
	rel="stylesheet" />
<!-- PLUGINS STYLES-->
<link href="../../assets/vendors/select2/dist/css/select2.min.css"
	rel="stylesheet" />
<link
	href="../../assets/vendors/bootstrap-datepicker/dist/css/bootstrap-datepicker3.min.css"
	rel="stylesheet" />
<link
	href="../../assets/vendors/bootstrap-timepicker/css/bootstrap-timepicker.min.css"
	rel="stylesheet" />
<link href="../../assets/vendors/jquery-minicolors/jquery.minicolors.css"
	rel="stylesheet" />
<!-- THEME STYLES-->
<link href="../../assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->


<#import "../temp1/defaultLayout.ftl" as layout> <#import
	"../spring.ftl" as spring /> <@layout.myLayout1 "Home page"> <!-- *************************************************** -->
<!-- *************************************************** --> <!-- *************************************************** -->
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
					<div class="col-lg-6">${ville.id!} ${ville.libell!}</div>
				</div>

			</div>

		</div>
	</div>
</div>
</#if> <!-- *************************************************** --> <!-- *************************************************** -->
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

						<!-- Button trigger modal -->
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#exampleModalLong">Launch demo modal</button>

						<!-- Modal -->
						<div class="modal fade" id="exampleModalLong" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLongTitle"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLongTitle">Modal
											title</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">


										<div class="form-group">
											<@spring.bind "ville" />

											<form action="/sadmin/ville/add" method="post">
												<label class="form-control-label">libell</label>

												<@spring.formInput "ville.libell" /><br> <br>
												<@spring.showErrors "</br>" /> <br> <select
													name="delegation">
													<#list delegations as delegation>
													<option value="${delegation.id}">${delegation.libell}</option>
													</#list>
												</select> <br>
												<button type="submit" class="btn btn-primary">Ajouter</button>
											</form>
										</div>

									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Close</button>
										<button type="button" class="btn btn-primary">Save
											changes</button>
									</div>
								</div>
							</div>
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
				<#if (RequestParameters.page??)>
				<#assign pp=RequestParameters.page?number>
				<#else>
				<#assign pp=0>
				</#if>
				<table class="table table-striped table-hover">
					<thead>
						<th>Id</th>
						<th>Libelle</th>
						<th>Delegation</th>
						<th>Action</th>
					</thead>
					<tbody>
						<#list pageVilles as ville>
						<tr>
							<td>${ville.id}</td>
							<td><a href="/admin/ville/${ville.id}">${ville.libell}</a></td>
							<td><#if (ville.delegation??)> <a
									href="/delegation/${ville.delegation.id}"> <#if
										(ville.delegation??)> ${ville.delegation.libell} </#if>
								</a> <#else> no data </#if></td>
							<td><a href="/admin/ville/delete/${ville.id}">delete</a></td>
						</tr>
						</#list>
					</tbody>
				</table>
				<nav aria-label="Page navigation example">
					<ul class="pagination">

						<#assign next=pp?number+1> <#assign
							prev=pp?number- 1>
							
						
						
						
					    <#if (prev gte 0) >
							<li class="page-item"><a class="page-link"
								href="/admin/ville?page=${prev}">Previous</a></li>
							<#else>
							<li class="page-item disabled"><a class="page-link"
								href="#">Previous </a></li>
					    </#if>
							
						<#list pages as p>
						
						<#if (p?index == pp?number) >
						    <li class="page-item active"><a class="page-link"
							href="/admin/ville?page=${p?index}">${p?index}</a>
							</li>
						<#else>	
							<li class="page-item"><a class="page-link"
							href="/admin/ville?page=${p?index}">${p?index}</a>
							</li>
						</#if>
							
						</#list>
						
						
							<#if (next lt pages?size) >
							<li class="page-item"><a class="page-link"
								href="/admin/ville?page=${next}">Next</a></li>
							<#else>
							<li class="page-item disabled"><a class="page-link"
								href="#">Next</a></li>
							</#if>
						
					
					</ul>
				</nav>
				

			</div>
		</div>
	</div>
</div>
</@layout.myLayout1> 