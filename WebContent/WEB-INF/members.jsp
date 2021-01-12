<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Membres de groupes</title>
</head>
<body>
<%@ include file="menuMember.jsp" %>
<h2>Voici les différents membres de groupes</h2>

<c:if test="${messages != null}">
		<c:forEach items="${messages}" var="message" varStatus="boucle">
			<p>${boucle.count}) ${message}</p>
		</c:forEach>
</c:if>
<table>
		<thead>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Role</th>
			<th>Naissance</th>
			<th>Origine</th>
			<th>ID</th>
			<th>Second Rôle</th>
		</thead>
	<tbody>
		<c:forEach items="${members}" var="member">
			<tr>
				<td>${member.name}</td>
				<td>${member.first_Name}</td>
				<td>${member.role}</td>
				<td>${member.birthdate}</td>
				<td>${member.origin}</td>
				<td>${member.id_Member}</td>
				<td>${member.second_Role}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>