<#import "/caissier_layout/defaultLayout.ftl" as layout> <#import
	"/spring.ftl" as spring /> <@layout.caissier_layout "Home page">




<div class="container-fluid">
	<div class="row">
		<div class="col-12">
			CAISSIER <br> ${Session.user!''} <br> ${Session.role!''}
		</div>
		<div class="col-12">

			<div class="card text-center">
				<div class="card-header">Featured</div>
				<div class="card-body">
					<a href="#" class="btn btn-primary">Serveur 1</a> <a href="#"
						class="btn btn-primary">Serveur 2</a> <a href="#"
						class="btn btn-primary">Serveur 3</a> <br> <br>
					<div class="row">
						<div class="col-md-8">
							<ul class="nav nav-tabs" id="myTab" role="tablist">
								<li class="nav-item"><a class="nav-link active"
									id="home-tab" data-toggle="tab" href="#home" role="tab"
									aria-controls="home" aria-selected="true">Jus</a></li>
								<li class="nav-item"><a class="nav-link" id="profile-tab"
									data-toggle="tab" href="#profile" role="tab"
									aria-controls="profile" aria-selected="false">Cafe</a></li>
								<li class="nav-item"><a class="nav-link" id="contact-tab"
									data-toggle="tab" href="#contact" role="tab"
									aria-controls="contact" aria-selected="false">Chicha</a></li>
							</ul>
							<div class="tab-content" id="myTabContent">
								<div class="tab-pane fade show active" id="home" role="tabpanel"
									aria-labelledby="home-tab">aaa</div>
								<div class="tab-pane fade" id="profile" role="tabpanel"
									aria-labelledby="profile-tab">zzzz</div>
								<div class="tab-pane fade" id="contact" role="tabpanel"
									aria-labelledby="contact-tab">
									<button type="button" class="btn btn-primary">Primary</button>
									<button type="button" class="btn btn-secondary">Secondary</button>
									<button type="button" class="btn btn-success">Success</button>
									<button type="button" class="btn btn-danger">Danger</button>
									<button type="button" class="btn btn-warning">Warning</button>
									<button type="button" class="btn btn-info">Info</button>
									<button type="button" class="btn btn-light">Light</button>
									<button type="button" class="btn btn-dark">Dark</button>

									<button type="button" class="btn btn-link">Link</button>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="card bg-light " >
							 <div class="card-header"><@spring.message "ticket.num"/></div>
								<div class="card-body bg-white">
									<h5 class="card-title"></h5>
									<p class="card-text">With supporting text below as a
										natural lead-in to additional content.</p>
									<a href="#" class="btn btn-primary">Go somewhere</a>
								</div>
							</div>
						</div>
					</div>



				</div>
				<div class="card-footer text-muted">2 days ago</div>
			</div>


		</div>
	</div>
</div>
</@layout.caissier_layout> 