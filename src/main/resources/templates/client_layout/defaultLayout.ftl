<!DOCTYPE html>
<#macro client_layout title="FreeMarker example">
<html lang="en">


<!-- Mirrored from admincast.com/admincast/preview/html/ by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 10 Dec 2018 04:32:16 GMT -->
<head>
<#include "style.ftl"/>
</head>

<body class="fixed-navbar">
	<div class="page-wrapper">

		<#include "header.ftl"/> <#include "page-sidebar.ftl"/>

		<div class="content-wrapper">
			<!-- START PAGE CONTENT-->
			<div class="page-content fade-in-up">
				<#nested />
			</div>
			<!-- END PAGE CONTENT -->
		<#-- include "footer.ftl"/>
		</div>
	</div>

	<!-- <#include "theme.ftl"/> -->

	<!-- BEGIN PAGA BACKDROPS-->
	<!-- 
	<div class="sidenav-backdrop backdrop"></div>
	<div class="preloader-backdrop">
		<div class="page-preloader">Loading</div>
	</div>
	 -->
	
	

	<#include "script.ftl"/>
</body>
<!-- Mirrored from admincast.com/admincast/preview/html/ by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 10 Dec 2018 04:32:53 GMT -->
</html>
</#macro>