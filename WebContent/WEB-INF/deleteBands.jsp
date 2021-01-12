<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Band</title>
</head>
<body>
<%@ include file="menuBand.jsp" %>
	<h5>Delete Band</h5>
		<form method="post" action="/Labo2/bands/delete">
			<div>
		    	<label for="bandToDelete">Band :</label>
			    <select id="bandToDelete" name="bandToDelete">
			    	<c:forEach items="${band}" var="band">
			    		<option value="${band.name}">${band.name}</option>
			    	</c:forEach>
			    </select>
		    </div>
		    <input type="submit" value="Supprimer">
		</form>
</body>
</html>