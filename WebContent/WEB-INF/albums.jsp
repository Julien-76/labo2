<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Les albums</title>
</head>
<body>
<%@ include file="menuAlbum.jsp" %>
<h2>Voici les différents albums de la DB</h2>

<c:if test="${messages != null}">
		<c:forEach items="${messages}" var="message" varStatus="boucle">
			<p>${boucle.count}) ${message}</p>
		</c:forEach>
</c:if>
<table>
		<thead>
			<th>Nom</th>
			<th>Groupe</th>
			<th>Label</th>
			<th>Date de sortie</th>
			<th>Style</th>
		</thead>
	<tbody>
		<c:forEach items="${albums}" var="album">
			<tr>
				<td>${album.name}</td>
				<td>${album.band.name}</td>
				<td>${album.label.name}</td>
				<td>${album.release_Date}</td>
				<td>${album.style}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>