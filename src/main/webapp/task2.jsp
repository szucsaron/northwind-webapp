<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<body>
    <p>
        <form action = "task2" method = "get">
            Filter by minimum number of products::<br>
            <input type="text" name="productNum"><br>
            <input type="submit" value="Submit">
        </form>
    </p>
    <table>
        <c:forEach var="company" items="${companies}">
            <tr>
                <td>${company.getName()}</td><td>${company.getNumberOfProducts()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
