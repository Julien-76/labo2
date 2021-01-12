<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Création d'un Label</title>
</head>
<body>
<%@ include file="menuLabel.jsp" %>
	<h5>Création d'un nouveau label</h5>
	<form method="post" action="/Labo2/labels/create">
	    <div>
	        <label for="name">Nom :</label>
	        <input type="text" id="name" name="name" placeholder="Nom du label">
	    </div>
	    <div>
	        <label for="nationality">Nationality :</label>
	        <input type="text" id="nationality" name="nationality" placeholder="Nationalité du label">
	    </div>
	    <div>
	        <label for="creation">Création :</label>
	        <input type="text" id="creation" name="creation" placeholder="Création du label">
	    </div>
	    <input type="submit" value="Créer">
	</form>
	
</body>
</html>