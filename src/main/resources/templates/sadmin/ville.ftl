
<#import "../temp1/defaultLayout.ftl" as layout>
<#import "../spring.ftl" as spring />
<@layout.myLayout1 "Home page"> <!-- *************************************************** -->
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
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong">
						  Launch demo modal
						</button>
						
						<!-- Modal -->
						<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <div class="modal-body">
						
						
						<div class="form-group">
						   <@spring.bind "ville" />

							<form action="/sadmin/ville/add" method="post">
								<label class="form-control-label">Delegation</label> 
								
								<@spring.formInput  "ville.libell" /><br><br>
								<@spring.showErrors "</br>" />
								
								<br>
								<br>
								<button type="submit" class="btn btn-primary">Ajouter</button>
							</form>
						</div>
						
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						        <button type="button" class="btn btn-primary">Save changes</button>
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
				<table class="table table-striped table-hover">
					<thead>
						<th>Id</th>
						<th>Libelle</th>
						<th>Delegation</th>
						<th>Action</th>
					</thead>
					<tbody>
						<#list villes as ville>
						<tr>
							<td>${ville.id}</td>
							<td><a href="/sadmin/ville/${ville.id}">${ville.libell}</a></td>
							<td><#if (ville.delegation??)> <a
									href="/delegation/${ville.delegation.id}"> <#if
										(ville.delegation??)> ${ville.delegation.libell} </#if>
								</a> <#else> no data </#if></td>
							<td><a href="/sadmin/ville/delete/${ville.id}">delete</a></td>
						</tr>
						</#list>
					</tbody>
				</table>
				

			</div>
		</div>
	</div>
</div>
</@layout.myLayout1> 
