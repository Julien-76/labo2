<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Label</title>
</head>
<body>
<%@ include file="menuLabel.jsp" %>
	<h5>Delete Label</h5>
		<form method="post" action="/Labo2/labels/delete">
			<div>
		    	<label for="labelToDelete">Label :</label>
			    <select id="LabelToDelete" name="labelToDelete">
			    	<c:forEach items="${label}" var="label">
			    		<option value="${label.name}">${label.name}</option>
			    	</c:forEach>
			    </select>
		    </div>
		    <input type="submit" value="Supprimer">
		</form>
</body>
</html>