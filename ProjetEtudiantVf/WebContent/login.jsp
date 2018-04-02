<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<title></title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/app.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
			<a class="navbar-brand" href="#">Connexion</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<!--Partie de la connexion -->
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<form class="form-inline my-2 my-lg-0" method="post"
					action="login.do">
					<label class="sr-only" for="inlineFormInputGroupUsername2">Username</label>
					<input class="form-control mr-sm-2" type="text"
						placeholder="Identifiant" name="username"> <label
						class="sr-only" for="inlineFormInputGroupUsername2">Password</label>
					<input type="password" class="form-control" id="inputPassword"
						placeholder="Password" name="password">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Submit</button>

					<div class="col-auto my-1">
						<div class="form-check">
							<input class="form-check-input" type="checkbox"
								id="autoSizingCheck2"> <label class="form-check-label"
								for="autoSizingCheck2"> Remember me </label>
						</div>
					</div>
				</form>
				<div id="container" >
					<label > <%
 	String message = (String) request.getAttribute("message");
 	if (!(message == null)) {
 		out.println(message);
 	} else {
 		message = "";
 		out.println(message);
 	}
 %>
					</label>


				</div>
			</div>
		</div>

	</nav>

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div id="content">
					<h1>Bienvenue dans la page de connexion</h1>
					<h3>Cette page est réservée aux etudiants et professeurs</h3>
					<hr>
				</div>
			</div>

		</div>
	</div>

</body>
</html>