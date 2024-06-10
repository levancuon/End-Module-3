<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/9/2024
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Insert new product</h1>
<form action="/product/insert" method="post">
    product_name : <input type="text" placeholder="product_name" name="product_name" required> <br>
    product_price : <input type="number" placeholder="product_price" name="product_price" required min="10000000"> <br>
    product_quantity : <input type="number" placeholder="product_quantity" name="product_quantity" required min="1"> <br>
    product_color : <input type="text" placeholder="product_color" name="product_color"> <br>
    product_description : <input type="text" placeholder="product_description" name="product_description"> <br>
    product_category : <input type="text" placeholder="product_category" name="product_category"> <br>
    <button type="submit" >Insert</button>
</form>
</body>
</html>
