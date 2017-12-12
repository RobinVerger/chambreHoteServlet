<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="reservation.Reservation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1 class="ticketTable">
		<tr>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Telephone</th>
			<th>Email</th>
			<th>Date Arrivée</th>
			<th>Date Départ</th>
		</tr>
		<%
			Collection<Reservation> listeResa = (Collection<Reservation>) request.getAttribute("listeResa");
			if(listeResa != null){
				Iterator it = listeResa.iterator() ;
			    while (it.hasNext()){
			    	Reservation serveur=(Reservation) it.next() ;
		%>
					<tr>
						<td><%=serveur.getNom()%></td>
						<td><%=serveur.getPrenom()%></td>
						<td><%=serveur.getTelephone()%></td>
						<td><%=serveur.getEmail()%></td>						
						<td><%=serveur.getArrivee()%></td>
						<td><%=serveur.getDepart()%></td>
					</tr>
					<%}
			    }%>

</body>
</html>