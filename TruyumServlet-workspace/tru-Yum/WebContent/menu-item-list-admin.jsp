<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TruYum</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="Styles/style.css">
<script src="js/script.js"></script>
</head>
<body>
	
		<div class="topnav">
			<div class="home">truYum</div>
			<img
				src="C:/Users/833368/TruyumServlet-workspace/tru-Yum/WebContent/images/truyum-logo-light.png">
			<a href="ShowMenuItemListAdmin">Menu</a>
		</div>

		<div class="cart">
			<h3>Menu Items</h3>
		</div>
		<table cellspacing="0px" cellpadding="10px">
		<tr>
			<th>Name</th>
			<th class="currency">Price</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Category</th>
			<th>Free Delivery</th>
			<th>Action</th>
		</tr>
		<c:forEach var="menuItemList" items="${menuItemList}">
			<tr>
				<td>${menuItemList.name}</td>
				<td><fmt:setLocale value="en_IN" /> <fmt:formatNumber
						type="currency" value="${menuItemList.price}" /></td>
				<td><c:choose>
						<c:when test="${menuItemList.active eq 'true'}">yes</c:when>
						<c:otherwise>no</c:otherwise>
					</c:choose></td>

				<td><fmt:formatDate type='date' pattern='dd/MM/yyyy'
						value="${menuItemList.dateOfLaunch}" /></td>
				<td>${menuItemList.category}</td>
				<td><c:choose>
						<c:when test="${menuItemList.freeDelivery eq 'true'}">yes</c:when>
						<c:otherwise>no</c:otherwise>
					</c:choose></td>
				<td><a href="ShowEditMenuItem?id=${menuItemList.id}">Edit</a></td>
			</tr>
		</c:forEach>

	</table>
	<div class="footer">
		<h4>Copyright @ 2019</h4>
	</div>
</body>
</html>