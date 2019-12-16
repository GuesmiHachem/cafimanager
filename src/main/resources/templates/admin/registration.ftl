<#import "/admin_layout/defaultLayout.ftl" as layout>
<#import "/spring.ftl" as spring />
<@layout.admin_layout "Home page"> 


	<div class="container">
		<div class="row main">
			<div class="main-login main-center">

				<form autocomplete="off" action="#" action="/registration"
					 method="post" class="form-horizontal"
					role="form">
					<fieldset>
						<!-- Form Name -->
						<legend>Create your account</legend>
						<!-- Text input-->

						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label"></label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span> <input type="text"
										placeholder="Name" class="form-control" name="name"/>
								</div>
								
							</div>
						</div>


						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label"> </label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
										type="text" name="email" placeholder="Email"
										class="form-control" />
								</div>
								
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label"></label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
										type="password" name="password" placeholder="Password"
										class="form-control" />
								</div>
								
							</div>
						</div>


						<div class="form-group">
							<input type="submit" class="btn btn-lg btn-primary btn-block"
								name="Submit" value="Register">
						</div>
					</fieldset>
				</form>
				<div class="panel-footer ">
					Already have an account? <a href="/login" onClick="">
						Login </a>
				</div>
			</div>

		</div>
	</div>


</@layout.admin_layout>