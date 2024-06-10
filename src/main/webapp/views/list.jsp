<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/7/2024
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<body>
<div class="container mt-5">
  <div class="d-flex justify-content-between">
    <h2>Managment Product</h2>
    <a href="/product/insert" class="btn btn-primary">Add product</a>
  </div>
  <div>
    <table class="table text-center">
      <tr>
        <th>Stt</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Color</th>
        <th>Category</th>
        <th>Action</th>
        <th></th>
      </tr>
      <c:forEach var="productList" items="${productList}" varStatus="status">
        <tr>

          <td>${status.count}</td>
          <td>${productList.name}</td>
          <td>${productList.price}</td>
          <td>${productList.quantity}</td>
          <td>${productList.color}</td>
          <td>${productList.category}</td>
          <td>
            <a href="/product/edit?id=${productList.id}" class="btn btn-primary btn-sm fst-normal" style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;">edit</a>
            <a href="/product/delete?id=${productList.id}" class="btn btn-primary btn-sm fst-normal" style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;">delete</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>
</body>
</html>
