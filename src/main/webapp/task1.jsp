<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<body>
    <p>
        <form action = "task1" method = "get">
            Filter by Company:<br>
            <input type="text" name="company"><br>
            <input type="submit" value="Submit">
        </form>
    </p>
    <table>
            <tr>
            <td><h3>Product</h3></td><td><h3>Company</h3></td>
            </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.getName()}</td><td>${product.getCompany()}</td>
            </tr>
        </c:forEach>
    </table>
    <p>
    <a href="index.html"> Back</a>
    </p>
</body>
</html>
