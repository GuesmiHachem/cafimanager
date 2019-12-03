<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html>

<!-- Mirrored from admincast.com/admincast/preview/html/error_404.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 10 Dec 2018 04:41:57 GMT -->
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width initial-scale=1.0">
<title>Admincast bootstrap 4 &amp; angular 5 admin template,
	Шаблон админки | Login</title>
<!-- GLOBAL MAINLY STYLES-->
<link href="/assets/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- THEME STYLES-->
<link href="/assets/css/main.css" rel="stylesheet" />
</head>

<body class="bg-silver-100">
	<div class="content">
		<h1 class="m-t-20"></h1>
		<p class="error-title"><@spring.message "invalid.session"/></p>
		<p class="m-b-20">
			<@spring.message "page.not.found.text"/> <br> <a
				class="color-green" href="/home"> <@spring.message
				"go.home.page"/> </a>
		</p>
		
	</div>
	<style>
.content {
	max-width: 450px;
	margin: 0 auto;
	text-align: center;
}

.content h1 {
	font-size: 160px
}

.error-title {
	font-size: 22px;
	font-weight: 500;
	margin-top: 30px
}
</style>
	<!-- BEGIN PAGA BACKDROPS-->
	<div class="sidenav-backdrop backdrop"></div>
	<div class="preloader-backdrop">
		<div class="page-preloader">Loading</div>
	</div>
	<!-- END PAGA BACKDROPS-->
	<!-- CORE PLUGINS -->
	<script src="/assets/vendors/jquery/dist/jquery.min.js"
		type="text/javascript"></script>
	<script src="/assets/vendors/popper.js/dist/umd/popper.min.js"
		type="text/javascript"></script>
	<script src="/assets/vendors/bootstrap/dist/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- CORE SCRIPTS-->
	<script src="/assets/js/app.js" type="text/javascript"></script>
</body>


<!-- Mirrored from admincast.com/admincast/preview/html/error_404.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 10 Dec 2018 04:41:57 GMT -->
</html>