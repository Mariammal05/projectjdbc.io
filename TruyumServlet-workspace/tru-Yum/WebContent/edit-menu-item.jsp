<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Styles/style.css">
<script src="js/script.js"></script>
<title>Edit-Menu-Item</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img
			src="C:/Users/833368/TruyumServlet-workspace/tru-Yum/WebContent/images/truyum-logo-light.png">
		<a href="ShowMenuItemListAdmin">Menu</a>
	</div>
	<div class="cart">
		<h5>Edit Menu item</h5>
	</div>
	<div class="body-content-colour">
		<form action="EditMenuItem" onsubmit="return validateMenuItemForm()"
			name="menuItemForm" method="post">
			<div class="form-field-spacing">
				<label for="name">Name</label><br> <input type="text"
					class="text-box text-box-title" name="name"
					value="${menuItem.name}">
			</div>
			<div class="form-field-spacing">
				<label for="price">Price(Rs.)</label><br> <input type="text"
					class="text-boxl" name="price" id="price" value="${menuItem.price}">
			</div>
			<div class="form-field-spacing">
				<label for="active">Active</label><br>
				<div>
					Yes <input type="radio" class="radio" name="active" value="yes"
						<c:if test="${menuItem.active eq 'true'}">checked </c:if>>
					No <input type="radio" class="radio" name="active" value="No"
						<c:if test="${menuItem.active eq 'false'}">checked </c:if>>
				</div>
			</div>
			<div class="form-field-spacing">
				<label for="dateOfLaunch">Date of Launch</label><br> <input
					type="text" class="text-boxl" name="dateOfLaunch"
					value="<fmt:formatDate type="date" pattern="dd/MM/yyyy"
                                  value="${menuItem.dateOfLaunch}" />">
			</div>
			<div class="form-field-spacing">
				<label for="category">Category</label> <select name="category"
					class="dropdown">
					<option value="${menuItem.category}">${menuItem.category}</option>
					<option value="Starters">Starters</option>
					<option value="Main Course">Main Course</option>
					<option value="Dessert">Dessert</option>
					<option value="Drink">Drink</option>
				</select>
			</div>
			<div class="form-field-spacing">
				<label for="Free Delivery">Free Delivery</label>
				<input type="checkbox" name="freeDelivery"
					<c:if test="${menuItem.freeDelivery eq 'true'}">Checked</c:if>
					<c:if test="${menuItem.freeDelivery eq 'false'}"></c:if>>
			
			</div>
			<div>
				<input type="hidden" name="id" value="${menuItem.id}">
			</div>
			<div class="form-field-spacing">
				<br> <input type="submit" class="button success-button"
					value="save">
			</div>
		</form>
		</div>
		<div class="footer">
			<h4>Copyright © 2019</h4>
		</div>
</body>
</html>