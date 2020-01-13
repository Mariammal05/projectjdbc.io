<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width,initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="Styles/style.css">
<script src="js/script.js"></script>
<title>Cart</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img
			src="C:/Users/833368/TruyumServlet-workspace/tru-Yum/WebContent/images/truyum-logo-light.png">
		<a href="ShowCart">Cart</a> <a href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<div class="cart">
		<h3>Cart</h3>
		<h6>
			<span class="notification" id="span"></span>
			<c:if test="${deletecartstatus}">
				<span class="notification">Item removed from Cart
					Successfully</span>
			</c:if>
		</h6>
	</div>
	<table id="table_id">
		<tr>
			<th>Name</th>
			<th>Free Delivery</th>
			<th>Price</th>
		</tr>
		<tr>
			<c:forEach items="${cart.menuItemList}" var="menuItem">

				<tr>
					<td>${menuItem.name}</td>
					<td><c:choose>
							<c:when test="${menuItem.freeDelivery eq 'true'}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><fmt:setLocale value="en_IN" /> <fmt:formatNumber
							type="currency" value="${menuItem.price}" /></td>
					<td><a href="RemoveCart?id=${menuItem.id}">Delete</a></td>
				</tr>
			</c:forEach>
		<tr>
			<td></td>
			<td><b>Total</b></td>
			<td><b><fmt:setLocale value="en_IN" /> <fmt:formatNumber
					type="currency" value="${cart.total}" /></b></td>
			<td></td>

		</tr>
	</table>
	<div class="footer">
		<h4>Copyright @ 2019</h4>
	</div>
</body>
</html>