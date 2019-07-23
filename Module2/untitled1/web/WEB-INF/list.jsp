<%--
  Created by IntelliJ IDEA.
  User: Pham Huy Duc
  Date: 22/07/2019
  Time: 4:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product</h1>
<p>
    <a href="/product?action=create">Create new product</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["product"]}' var="product">
        <tr>
            <td><a href="/customers?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${customer.getPrice()}</td>
            <td><a href="/customers?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="/customers?action=delete&id=${product.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

</body>
</html>
