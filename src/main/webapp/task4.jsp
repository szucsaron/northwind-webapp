<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<body>
    <p>
        <form action = "task4" method = "get">
            Filter by company name:<br>
            <input type="text" name="companyName"><br>
            <input type="submit" value="Submit">
        </form>
    </p>
    <table>
        <tr>
        <td><h3>Company</h3></td><td><h3>Orders</h3></td>
        </tr>
        <c:forEach var="orders" items="${orderLst}">
            <tr>
                <td>
                    ${orders.getCompanyName()}
                    <c:forEach var="order" items="${orders.getOrders()}">,
                        ${order}
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <a href="index.html"> Back</a>
    </p>
</body>
</html>
