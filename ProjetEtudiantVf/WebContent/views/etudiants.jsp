<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<title>Etudiants</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/app2.css">

</head>
<body>
	<div class="container">
		<div class="col-lg-12">
			<div id="content">
				<h1>Bienvenue Monsieur ${requestScope.username } </h1>
				<h4>Vous verrez ci dessous les étudiants et les modules qu'ils
					ont choisis</h4>
				<hr>
			</div>
			<div class="container">
				<h1 >Lise des cours</h1> 
				<label id="container"> 
				<s:iterator value="listCours">
						<tr>
							<th scope="row"><s:property value="key.idAdherent" /></th>
							<td><s:property value="key.idLivre" /></td>
							<td><s:property value="dateReservation" /></td>
							<td><s:property value="dateLimite" /></td>
						</tr>
					</s:iterator>
				</label>


			</div>

		</div>
	</div>

</body>
</html>