<#import "/spring.ftl" as spring />
<!-- START SIDEBAR-->
<nav class="page-sidebar" id="sidebar">
	<div id="sidebar-collapse">
		<div class="admin-block d-flex">
			<div>
				<img src="../../assets/img/admin-avatar.png" width="45px" />
			</div>
			<div class="admin-info">
				<div class="font-strong">
				   ${Session.user!''}
				</div>
				<small>${Session.role!''}</small>
			</div>
		</div>
		<ul class="side-menu metismenu">
			<li><a class="active" href="/home"><i
					class="sidebar-item-icon fa fa-th-large"></i> <span
					class="nav-label"><@spring.message "home"/></span> </a></li>
			<li class="heading"><@spring.message "gestion"/></li>
			<li><a href="javascript:;"><i
					class="sidebar-item-icon fa fa-bookmark"></i> <span
					class="nav-label"><@spring.message "gestion.gouvernorat"/></span><i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level collapse">
					<li><a href="/admin/governorat"><@spring.message
							"list.gouvernorat"/></a></li>

				</ul></li>
			<li><a href="javascript:;"><i
					class="sidebar-item-icon fa fa-bookmark"></i> <span
					class="nav-label"><@spring.message "gestion.delegation"/></span><i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level collapse">
					<li><a href="/admin/delegation"><@spring.message
							"list.delegation"/></a></li>

				</ul></li>
			<li><a href="javascript:;"><i
					class="sidebar-item-icon fa fa-bookmark"></i> <span
					class="nav-label"><@spring.message "gestion.ville"/></span><i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level collapse">
					<li><a href="/admin/ville"><@spring.message "list.ville"/></a>
					</li>

				</ul></li>
			<li><a href="javascript:;"><i
					class="sidebar-item-icon fa fa-bookmark"></i> <span
					class="nav-label"><@spring.message "gestion.cafes"/></span><i
					class="fa fa-angle-left arrow"></i></a>
				<ul class="nav-2-level collapse">
					<li><a href="/client/cafe"><@spring.message "list.cafe"/></a>
					</li>

				</ul></li>

		</ul>
		<span class="text-danger"><@spring.message "welcome.message"/></span>

	</div>
</nav>
<!-- END SIDEBAR-->