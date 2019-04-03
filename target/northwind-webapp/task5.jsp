<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<body>
<h1>Most Expensive Product</h1>
<table>
<tr>
    <td><h3>Name</h3></td>
    <td><h3>Company</h3></td>
    <td><h3>Price</h3></td>
</tr>
<tr>
    <td>${product.getName()}</td>
    <td>${product.getCompany()}</td>
    <td>${product.getPrice()}</td>
</tr>
</table>
<p>
    <a href="index.html"> Back</a>
</p>
</body>
</html>
