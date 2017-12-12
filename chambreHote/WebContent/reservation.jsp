<%@page import="enregistrement.Reponse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/materialize.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<h1>Bravo le veau</h1>

	<table class="bordered">
		<thead>
			<tr>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Email</th>
				<th>Telephone</th>
				<th>Arrivée</th>
				<th>Départ</th>
				<th>Nbre de personnes</th>
				<th>Nbre de Jours</th>
				<th>Type de Séjour</th>
				<th>Options</th>
			</tr>
		</thead>


		<tbody>
			</tr>
			<%!String[] options;%>
			<td><%=request.getParameter("nom")%></td>
			<td><%=request.getParameter("prenom")%></td>
			<td><%=request.getParameter("email")%></td>
			<td><%=request.getParameter("telephone")%></td>
			<td><%=request.getParameter("arrivee")%></td>
			<td><%=request.getParameter("depart")%></td>
			<td><%=request.getParameter("nbrePersonne")%></td>
			<td><%=request.getAttribute("nuitee")%></td>
			<td><%=request.getParameter("myradio")%></td>
			<td><%options = request.getParameterValues("option");
					if (options != null) {
						for (int i = 0; i < options.length; i++) {
							out.println(" " + options[i] + " ");
						}
					} else
						out.println("Aucune");
				%>
			</td> 
			</tr>
		</tbody>

	</table>

	<a href="index.html">Retour</a>
</body>
</html>