<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Groupes</title>
</head>
<body>
<%@ include file="menuBand.jsp" %>
<h2>Voici les différents groupes de la DB</h2>

<c:if test="${messages != null}">
		<c:forEach items="${messages}" var="message" varStatus="boucle">
			<p>${boucle.count}) ${message}</p>
		</c:forEach>
</c:if>
<table>
		<thead>
			<th>Nom</th>
			<th>Nationality</th>
			<th>Creation</th>
			<th>Style</th>
			<th>Label</th>
			<th>Albums</th>
			<th>Members</th>
		</thead>
	<tbody>
		<c:forEach items="${bands}" var="band">
			<tr>
				<td>${band.name}</td>
				<td>${band.nationality}</td>
				<td>${band.creation}</td>
				<td>${band.style}</td>
				<td>${band.label.name}</td>
				<td>${band.albums}</td>
				<td>${band.members}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>