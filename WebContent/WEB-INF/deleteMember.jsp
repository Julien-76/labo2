<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Member</title>
</head>
<body>
<%@ include file="menuMember.jsp" %>
	<h5>Delete Member</h5>
		<form method="post" action="/Labo2/members/delete">
			<div>
		    	<label for="memberToDelete">Member :</label>
			    <select id="memberToDelete" name="memberToDelete">
			    	<c:forEach items="${member}" var="member">
			    		<option value="${member.id_Member}">${member.name} ${member.first_Name }</option>
			    	</c:forEach>
			    </select>
		    </div>
		    <input type="submit" value="Supprimer">
		</form>
</body>
</html>