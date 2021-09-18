<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>productId</th>
				<th>productName</th>
				<th>productPrice</th>
				<th>productDiscount</th>
				<th>productCategory</th>
				<th>productQuantity</th>
				<th>update</th>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.productId}</td>
					<td>${product.productName}</td>
					<td>${product.productPrice}</td>
					<td>${product.productDiscount}</td>
					<td>${product.productCategory}</td>
					<td>${product.productQuantity}</td>
					<td><a href="updateProduct?id=<c:out value="${product.productId}"/>">update</a></td>
					<td><a href="deleteProduct?id=<c:out value="${product.productId}"/>">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="addProduct">Add new Product</a>
</body>
</html>