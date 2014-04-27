<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
    
		<link rel="shortcut icon" href="../../assets/ico/favicon.ico">

		<title>Spring - AngularJS - STOMP over SockJS</title>

		<spring:url value="/assets/css" var="cssAssetsBaseUrl" />
		<spring:url value="/assets/js" var="jsAssetsBaseUrl" />

		<!-- Bootstrap core CSS -->
		<link href="${cssAssetsBaseUrl}/bootstrap.min.css" rel="stylesheet">

		<!-- Custom styles -->
		<link href="${cssAssetsBaseUrl}/style.css" rel="stylesheet">
		
		<!-- Just for debugging purposes. Don't actually copy this line! -->
		<!--[if lt IE 9]><script src="${jsAssetsBaseUrl}/ie8-responsive-file-warning.js"></script><![endif]-->

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>		
		<spring:url value="/" var="baseUrl" />
		<spring:url value="/authenticate" var="loginUrl" />
		<spring:url value="/logout" var="logoutUrl" />
		<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="${baseUrl}">Spring Example</a>
				</div>
				<div class="navbar-collapse collapse">					
					<form class="navbar-form navbar-right" action="${loginUrl}" method="POST" role="form">
						<div class="form-group">
							<input type="email" name="username" placeholder="Email" class="form-control" required="required">
						</div>
						<div class="form-group">
							<input type="password" name="password" placeholder="Password" class="form-control" required="required">
						</div>
						<button type="submit" class="btn btn-info">Sign in</button>
					</form>
				</div><!--/.navbar-collapse -->
			</div>
		</div>
		<div class="container">
			
			<!-- Content Start -->
			<div class="page-header">
				<h1>List of Ideas</h1>
			</div>
			<div class="btn-group">
				<a href="#" class="btn btn-primary add-new-order"><span class="glyphicon glyphicon-plus"></span> New Idea</a>
			</div>
			<div class="table-responsive">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Title</th>
							<th>Description</th>
							<th>Votes</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>N/A</td>
							<td>N/A</td>
							<td>N/A</td>
							<td>N/A</td>
							<td>N/A</td>
						</tr>
						<tr>
							<td>N/A</td>
							<td>N/A</td>
							<td>N/A</td>
							<td>N/A</td>
							<td>N/A</td>
						</tr>
						<tr>
							<td>N/A</td>
							<td>N/A</td>
							<td>N/A</td>
							<td>N/A</td>
							<td>N/A</td>
						</tr>
		        	</tbody>
		        </table>
			</div>
			<ul class="pager">
				<li class="disabled"><a>Previous</a></li>
				<li class="disabled"><a>Next</a></li>
			</ul>
			<!-- Content End -->
			<hr>
			<footer>
				<p>&copy; <a href="http://innovez-one.com">Innovez One</a> 2014</p>
			</footer>
		</div> <!-- /container -->


		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="${jsAssetsBaseUrl}/jquery.min.js"></script>
		<script src="${jsAssetsBaseUrl}/bootstrap.min.js"></script>
	</body>
</html>
