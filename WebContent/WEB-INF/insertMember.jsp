<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Création d'un membre de groupe</title>
</head>
<body>
<%@ include file="menuMember.jsp" %>
	<h5>Création d'un nouveeau membre</h5>
	<form method="post" action="/Labo2/members/create">
	    <div>
	        <label for="name">Nom :</label>
	        <input type="text" id="name" name="name" placeholder="Nom">
	    </div>
	    <div>
	        <label for="first_Name">Prénom :</label>
	        <input type="text" id="first_Name" name="first_Name" placeholder="Prenom">
	    </div>
	    <div>
	    	<label for="role">Role :</label>
		    <select id=role name="role">
		    	<option value="aucun">aucun</option>
		    	<option value="Singer">Singer</option>
		    	<option value="Guitar">Guitar</option>
		    	<option value="Bass">Bass</option>
		    	<option value="Keyboard">Keyboard</option>
		    	<option value="Drums">Drums</option>
		    	<option value="All">All</option>
		    </select>
	    </div>
	    <div>
	        <label for="birthdate">Date de naissance :</label>
	        <input type="date" id="date" name="date" placeholder="Date">
	    </div>
	    <div>
	        <label for="origin">Origine :</label>
	        <input type="text" id="origin" name="origin" placeholder="Origine">
	    </div>
	    <div>
	        <label for="id_Member">ID :</label>
	        <input type="number" id="id_Member" name="id_Member" placeholder="ID">
	    </div>
	    <div>
	    	<label for="second_Role">Second Role :</label>
		    <select id=second_Role name="second_Role">
		    	<option value="aucun">aucun</option>
		    	<option value="Singer">Singer</option>
		    	<option value="Guitar">Guitar</option>
		    	<option value="Bass">Bass</option>
		    	<option value="Keyboard">Keyboard</option>
		    	<option value="Drums">Drums</option>
		    	<option value="All">All</option>
		    </select>
	    </div>
	    
	    <input type="submit" value="Créer">
	</form>
	
</body>
</html>