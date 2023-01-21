    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

    <jsp:include page="templates/header_admin.jsp"/>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <a href="/carrental/admin-console/show-users.html">Show users</a><br>
    </security:authorize>
    <a href="/carrental/admin-console/cars.html">Show cars</a><br>
    <a href="/carrental/admin-console/car.html">Add car</a>

</body>
</html>