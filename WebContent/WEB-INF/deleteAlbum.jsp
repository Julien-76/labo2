<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Album</title>
</head>
<body>
<%@ include file="menuAlbum.jsp" %>
	<h5>Delete Album</h5>
		<form method="post" action="/Labo2/albums/delete">
			<div>
		    	<label for="albumToDelete">Album :</label>
			    <select id="albumToDelete" name="albumToDelete">
			    	<c:forEach items="${albums}" var="album">
			    		<option value="${album.name}">${album.name}</option>
			    	</c:forEach>
			    </select>
		    </div>
		    <input type="submit" value="Supprimer">
		</form>
</body>
</html>