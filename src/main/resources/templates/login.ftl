
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login V6</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="icon" type="image/png" href="login/images/icons/favicon.ico" />

<link rel="stylesheet" type="text/css"
	href="login/vendor/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css"
	href="login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css"
	href="login/fonts/iconic/css/material-design-iconic-font.min.css">

<link rel="stylesheet" type="text/css"
	href="login/vendor/animate/animate.css">

<link rel="stylesheet" type="text/css"
	href="login/vendor/css-hamburgers/hamburgers.min.css">

<link rel="stylesheet" type="text/css"
	href="login/vendor/animsition/css/animsition.min.css">

<link rel="stylesheet" type="text/css"
	href="login/vendor/select2/select2.min.css">

<link rel="stylesheet" type="text/css"
	href="login/vendor/daterangepicker/daterangepicker.css">

<link rel="stylesheet" type="text/css" href="login/css/util.css">
<link rel="stylesheet" type="text/css" href="login/css/main.css">

</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-20 p-b-10">
				<form class="login100-form validate-form" action="/login"
					method="POST">
					<input type="hidden" id="g-recaptcha-response"
						name="g-recaptcha-response"> <input type="hidden"
						name="action" value="validate_captcha"> <span
						class="login100-form-title p-b-10"> CafiManager </span> <span
						class="login100-form-avatar"> <img
						src="login/images/avatar-01.jpg" alt="AVATAR">
					</span>
					<div class="wrap-input100 validate-input m-t-85 m-b-20"
						data-validate="Enter username">
						<input class="input100" type="text" name="email"> <span
							class="focus-input100" data-placeholder="Username"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-20"
						data-validate="Enter password">
						<input class="input100" type="password" name="password"> <span
							class="focus-input100" data-placeholder="Password"></span>
					</div>
					
					<div class="g-recaptcha"
    data-sitekey="6Leg6sUUAAAAAOKYA3r3uy3PjHBoQ1_BQ4iXobcj">
  </div>
		
					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn">Login</button>
					</div>
					<ul class="login-more p-t-50">
						<li class="m-b-8"><span class="txt1"> Forgot </span> <a
							href="#" class="txt2"> Username / Password? </a></li>
						<li><span class="txt1"> Don’t have an account? </span> <a
							href="#" class="txt2"> Sign up </a></li>
					</ul>
				</form>
			</div>
		</div>
	</div>
	<div id="dropDownSelect1"></div>

	<script src="login/vendor/jquery/jquery-3.2.1.min.js"
		type="9a5e3859048f4fef624ec378-text/javascript"></script>

	<script src="login/vendor/animsition/js/animsition.min.js"
		type="9a5e3859048f4fef624ec378-text/javascript"></script>

	<script src="login/vendor/bootstrap/js/popper.js"
		type="9a5e3859048f4fef624ec378-text/javascript"></script>
	<script src="login/vendor/bootstrap/js/bootstrap.min.js"
		type="9a5e3859048f4fef624ec378-text/javascript"></script>

	<script src="login/vendor/select2/select2.min.js"
		type="9a5e3859048f4fef624ec378-text/javascript"></script>

	<script src="login/vendor/daterangepicker/moment.min.js"
		type="9a5e3859048f4fef624ec378-text/javascript"></script>
	<script src="login/vendor/daterangepicker/daterangepicker.js"
		type="9a5e3859048f4fef624ec378-text/javascript"></script>

	<script src="login/vendor/countdowntime/countdowntime.js"
		type="9a5e3859048f4fef624ec378-text/javascript"></script>

	<script src="login/js/main.js"
		type="9a5e3859048f4fef624ec378-text/javascript"></script>

	<script async
		src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"
		type="9a5e3859048f4fef624ec378-text/javascript"></script>
	<script type="9a5e3859048f4fef624ec378-text/javascript">
	  window.dataLayer = window.dataLayer || [];
	  function gtag(){dataLayer.push(arguments);}
	  gtag('js', new Date());

	  gtag('config', 'UA-23581568-13');
	</script>
	<script
		src="https://ajax.cloudflare.com/cdn-cgi/scripts/7089c43e/cloudflare-static/rocket-loader.min.js"
		data-cf-settings="9a5e3859048f4fef624ec378-|49" defer=""
		type="text/javascript"></script>
	<script src="https://www.google.com/recaptcha/api.js?render=your reCAPTCHA site key here"></script>
<script>
    grecaptcha.ready(function() {
    // do request for recaptcha token
    // response is promise with passed token
        grecaptcha.execute('your reCAPTCHA site key here', {action:'validate_captcha'})
                  .then(function(token) {
            // add token value to form
            document.getElementById('g-recaptcha-response').value = token;
        });
    });
</script>
</body>
</html>
