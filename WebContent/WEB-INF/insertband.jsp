<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Création d'un groupe</title>
</head>
<body>
<%@ include file="menuBand.jsp" %>
	<h5>Création d'un nouveau groupe</h5>
	<form method="post" action="/Labo2/bands/create">
	    <div>
	        <label for="name">Nom :</label>
	        <input type="text" id="name" name="name" placeholder="Nom du groupe">
	    </div>
	    <div>
	        <label for="nationality">Nationalité :</label>
	        <input type="text" id="nationality" name="nationality" placeholder="Nationalité">
	    </div>
	    <div>
	        <label for="creation">Création :</label>
	        <input type="number" id="creation" name="creation" placeholder="Date de Création">
	    </div>
	    <div>
	    	<label for="style">Style :</label>
		    <select id=style name="style">
		    	<option value="Death">Death</option>
		    	<option value="Black">Black</option>
		    	<option value="Thrash">Thrash</option>
		    	<option value="Doom">Doom</option>
		    	<option value="Power">Power</option>
		    	<option value="Heavy">Heavy</option>
		    </select>
	    </div>
	    <div>
	    	<label for="label">Label :</label>
		    <select id="label" name="label">
		    	<c:forEach items="${label}" var="label">
		    		<option value="${label.name}">${label.name}</option>
		    	</c:forEach>
		    </select>
	    </div>
	    <div>
	        <label for="members">Membres :</label>
	        <input type="number" id="members" name="members" placeholder="Membres">
	    </div>
	    <div>
	        <label for="albums">Albums :</label>
	        <input type="number" id="albums" name="albums" placeholder="Albums">
	    </div>
	    <input type="submit" value="Créer">
	</form>
	
</body>
</html>