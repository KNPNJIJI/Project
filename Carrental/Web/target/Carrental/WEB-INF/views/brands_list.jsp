<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cars</title>
  </head>
  <body>
        <h1>Cars</h1>

        <table style="width:100%" class="table">
          <tr>
            <th>ID</th>
            <th>Brand & Model</th>
            <th>Year of manufacture</th>
            <th>Popularity</th>
          </tr>
          <c:forEach items="${brands}" var="brand">
          <tr>
            <td><c:out value="${car.id}"/></td>
            <td><c:out value="${brand} ${car.model}"/></td>
            <td><c:out value="${car.yearManufacture}"/></td>
            <td><c:out value="${car.popularity}"/></td>
          </tr>
          </c:forEach>
        </table>
  </body>
</html>
