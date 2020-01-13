<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
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
<title>Insert title here</title>
</head>
<body onload="Addfavorites()">
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvrorCdK6gftsE_bC7VRg4DvR6obHwLniP_7jG0Xl3IUSHaTy37A&s">
		<a href="ShowFavorites">Favorites</a> <a href="ShowMovieListCustomer">Movies</a>
	</div>
	<div class="flim">
		<h3>Favorites</h3>
		<c:if test="${deletefavoritesmoviestatus}">
			<div class="notification">Movies Removed from Favorites
				SuccessFully
				</div>
		</c:if>
</div>
		<table id="table_id">
			<tr>
				<th>Title</th>
				<th>Box Office</th>
				<th>Genre</th>
				<th></th>

			</tr>

			<c:forEach items="${favorites.movieList}" var="moviesList">
				<tr>
					<td>${moviesList.title}</td>
					<td><fmt:setLocale value="en_US" /> <fmt:formatNumber
							type="currency" value="${moviesList.gross}" /></td>
					<td>${moviesList.genre}</td>
					<td><a class="fcolor" href="RemoveFavorites?moviesId=${moviesList.id}">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
<td>
          <td ><b>No.of Favorites:</b></td>
          <td ><b>${favorites.total}</b>
           </td>
           </tr>
        </table>
 </body>   
        <div class="footer">
                <h4>Copyright @ 2019</h4>
            </div>

			

</html>