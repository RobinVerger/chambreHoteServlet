<%@page import="enregistrement.Reponse"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
		<title>Félicitation</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body style="text-align:center;">
		<% Reponse reponse = (Reponse) request.getAttribute("reponse"); %>
		<h1>Bravo le veau</h1>
		<p>Votre réservation a été enregistré avec les informations suivantes :</p>
		<table class="resultTable">
			<tr>
				<td>Nom</td>
				<td><%=reponse.getNom()%></td>
			</tr>
			<tr>
				<td>Prénom</td>
				<td><%=reponse.getPrenom()%></td>
			</tr>
			<tr>
				<td>Date Arrivée</td>
				<td><%=reponse.getArrivee()%></td>
			</tr>
		</table>
		<a href="index.html" >Retour</a>
	</body>
</html>


