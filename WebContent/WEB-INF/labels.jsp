<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Labels</title>
</head>
<body>
<%@ include file="menuLabel.jsp" %>
<h2>Voici les différents Labels de la DB</h2>

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
		</thead>
	<tbody>
		<c:forEach items="${labels}" var="label">
			<tr>
				<td>${label.name}</td>
				<td>${label.nationality}</td>
				<td>${label.creation}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>