<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="addProduct" method="post" modelAttribute="product">
		<form:hidden path="productId"/>
		<table>
			<tr>
				<td>Enter product name</td>
				<td>
					<form:input path="productName" readonly="true"/>
				 	<form:errors path="productName" class="error" />
				</td>
			</tr>
			
			<tr>
				<td>Enter product price</td>
				<td>
					<form:input path="productPrice" />
					<form:errors path="productPrice" class="error" />
				</td>
			</tr>
			
			<tr>
				<td>Enter product discount</td>
				<td><form:input path="productDiscount" readonly="true"/> <form:errors
						path="productDiscount" class="error" /></td>
			</tr>
			
			<tr>
				<td>Enter product category</td>
				<td>
					<form:input path="productCategory" readonly="true"/>
					<form:errors path="productCategory" class="error" />
				</td>
			</tr>
			
			<tr>
				<td>Enter product quantity</td>
				<td>
					<form:input path="productQuantity" readonly="true" />
				    <form:errors path="productQuantity" class="error" />
				 </td>
			</tr>
			
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>