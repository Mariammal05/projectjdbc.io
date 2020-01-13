<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="Styles/style.css">
<script src="js/script.js"></script>
</head>
<body>

	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvrorCdK6gftsE_bC7VRg4DvR6obHwLniP_7jG0Xl3IUSHaTy37A&s">
		<a href="ShowMovieListAdmin">Movies</a>
	</div>
	<div class="flim">
		<h3>Movies</h3>
	</div>
	<table cellspacing="0px" cellpadding="10px">
		<tr>
			<th>Title</th>
			<th>Box Office</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<c:forEach var="moviesList" items="${moviesList}">
			<tr>
				<td>${moviesList.title}</td>
				<td><fmt:setLocale value="en_US" /> <fmt:formatNumber
						type="currency" value="${moviesList.gross}" /></td>
				<td><c:choose>
						<c:when test="${moviesList.active eq 'true'}">yes</c:when>
						<c:otherwise>No</c:otherwise>
					</c:choose></td>
				<td><fmt:formatDate type='date' pattern='dd/MM/yyyy'
						value="${moviesList.dateOfLaunch}" /></td>
				<td>${moviesList.genre}</td>
				<td><c:choose>
						<c:when test="${moviesList.hasTeaser eq 'true'}">Yes</c:when>
						<c:otherwise>No</c:otherwise>
					</c:choose></td>
				<td><a href="ShowEditMovies?id=${moviesList.id}">Edit</a></td>
			</tr>

		</c:forEach>

	</table>


	<div class="footer">
		<h4>Copyright @ 2019</h4>
	</div>


</body>
</html>