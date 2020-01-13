<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="Styles/style.css">
<script src="js/script.js"></script>
<title>Edit Movie</title>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvrorCdK6gftsE_bC7VRg4DvR6obHwLniP_7jG0Xl3IUSHaTy37A&s">
		<a href="ShowMovieListAdmin">Movies</a>
	</div>
	<div class="flim">
		<h3>Edit Movie</h3>
	</div>
	<form action="EditMovies" onsubmit="return validateMoviesForm()" name="editMovie" method="post">

	
	<div class="form-field-spacing">
		<label for="title">Title</label><br><input type="text" name="title" class="text-box" value="${movies.title}">
	</div>
	<div class="form-field-spacing">
		<label for="gross">Gross ($)</label> <input type="text"
			name="gross" class="text-box" value="${movies.gross}">
	</div>
	<div class="form-field-spacing">
		<label for="active">Active</label><br>
		<div>
			Yes <input type="radio" class="radio" name="active" value="yes"
				<c:if test="${movies.active eq 'true'}">checked </c:if>> No
			<input type="radio" class="radio" name="active" value="No"
				<c:if test="${movies.active eq 'false'}">checked </c:if>>
		</div>
	</div>
	<div class="form-field-spacing">
		<label for="dateOfLaunch">Date of Launch</label> <input type="text"
			name="dateOfLaunch" class="text-boxp"
			value="<fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${movies.dateOfLaunch}" />">

	</div>
	<div class="form-field-spacing">
		<label for="genre">Genre</label> <select name="genre"
			class="drop-down-list">
			<option value="${movies.genre}">${movies.genre}</option>
			<option value="Science Fiction">Science Fiction</option>
			<option value="Superhero">Super hero</option>
			<option value="Romance">Romance</option>
			<option value="Comedy">Comedy</option>
			<option value="Adventure">Adventure</option>
			<option value="Thriller">Thriller</option>
		</select>
	</div>
	
	<div class="form-field-spacing">
	<label for="Teaser">Has Teaser</label>
			<input type="checkbox" name="hasTeaser" class="checkboxfont"
				<c:if test="${movies.hasTeaser eq 'true'}"> checked </c:if>> <label
				for="teaser">Has Teaser</label>
		</div> 
 
	
	
<!-- 	<div class="form-field-spacing"> -->
<!-- 		<label for="Teaser">Has Teaser</label> -->
<%-- 		<c:if test="${movies.hasTeaser}"> --%>
<!-- 			<input type="checkbox" name="hasTeaser" class="checkboxfont"> -->
<%-- 		</c:if> --%>
<%-- 		<c:if test="${!movies.hasTeaser}"> --%>
<!-- 			<input type="checkbox" name="hasTeaser" class="checkboxfont"> -->
<%-- 		</c:if> --%>
<!-- 	</div> -->
	
	
	
	<div>
		<input type="hidden" name="id" value="${movies.id}">
	</div>
	<div class="form-field-spacing">
		<br><input type="submit" class="button success-button" value="save">
		
	</div>
	</form>
	<div class="footer">
		<h4>Copyright @ 2019</h4>
	</div>
</body>
</html>