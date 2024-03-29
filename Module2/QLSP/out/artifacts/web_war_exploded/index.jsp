<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create new Product</title>
  <style>
    .message{
      color:green;
    }
  </style>
</head>
<body>
<h1>Create new Product</h1>
<p>
  <c: test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
  </c:>
</p>
<p>
  <a href="/product">Back to Product list</a>
</p>
<form method="post" action="/products">
  <fieldset>
    <legend>Customer information</legend>
    <table>
      <tr>
        <td>Name: </td>
        <td><input type="text" name="name" id="name"></td>
      </tr>
      <tr>
        <td>Price: </td>
        <td><input type="text" name="price" id="price"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Create product"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>