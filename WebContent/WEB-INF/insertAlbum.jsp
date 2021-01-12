<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Création d'un album</title>
</head>
<body>
	<h5>Création d'un nouvel album</h5>
	<form method="post" action="/Labo2/albums/create">
	    <div>
	        <label for="name">Nom :</label>
	        <input type="text" id="name" name="name" placeholder="Nom de l'album">
	    </div>
	    <div>
	    	<label for="band">Groupe :</label>
		    <select id="band" name="band">
		    	<c:forEach items="${band}" var="band">
		    		<option value="${band.name}">${band.name}</option>
		    	</c:forEach>
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
	        <label for="date">Date de sortie :</label>
	        <input type="date" id="date" name="date" placeholder="Date">
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
	    
	    <input type="submit" value="Créer">
	</form>
	
</body>
</html>