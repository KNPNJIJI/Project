<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="templates/header_admin.jsp"/>
        <h1>Cars</h1>

        <table style="width:100%" class="table">
          <tr>
            <th>ID</th>
            <th>Photo</th>
            <th>Brand & Model</th>
            <th>Price</th>
            <th>Year of manufacture</th>
            <th>Popularity</th>
            <th>Active</th>
          </tr>
          <c:forEach items="${cars}" var="car">
          <tr>
            <td><c:out value="${car.id}"/></td>
            <td><image src="/carrental/image/photo/id=${car.carPhoto}/" width="50" class="img-thumbnail"><td>
            <td>
                <a href="/carrental/car=${car.id}/photo=1/">
                    <c:out value="${car.brand} ${car.model}"/>
                </a>
            </td>
            <td><c:out value="${car.price}"/></td>
            <td><c:out value="${car.yearManufacture}"/></td>
            <td><c:out value="${car.popularity}"/></td>
            <td><c:out value="${car.active}"/></td>
          </tr>
          </c:forEach>
        </table>
        <div  class="page_wrapper">
          <ul class="page">
                <c:if test="${totalPages le 3}">
                     <c:forEach begin="1" end="${totalPages}" var="i">
                        <c:choose>
                            <c:when test="${currentPage eq i}">
                                 <li class="page__numbers active">${i}</li>
                            </c:when>
                            <c:otherwise>
                              <li class="page__numbers"><a href="/carrental/admin-console/cars/page=${i}/">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                     </c:forEach>
                </c:if>
                <c:if test="${totalPages gt 3}">
                  <c:if test="${currentPage != 1}">
                      <li class="page__btn"><a href="/carrental/admin-console/cars/page=1/"><<</a></li>
                  </c:if>
                  <c:if test="${currentPage gt 1}">
                    <c:set  var="start" value="${currentPage-1}"/>
                  </c:if>
                  <c:if test="${currentPage eq 1}">
                    <c:set  var="start" value="1"/>
                  </c:if>
                   <c:if test="${currentPage+2 le totalPages}">
                    <c:set  var="end" value="${currentPage+2}"/>
                  </c:if>
                  <c:if test="${currentPage+2 gt totalPages}">
                    <c:set  var="end" value="${totalPages}"/>
                  </c:if>

                      <c:forEach begin="${start}" end="${end}" var="i">
                        <c:choose>
                            <c:when test="${currentPage eq i}">
                                 <li class="page__numbers active">${i}</li>
                            </c:when>
                            <c:otherwise>
                              <li class="page__numbers"><a href="/carrental/admin-console/cars/page=${i}/">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                      </c:forEach>

                    <c:if test="${currentPage != totalPages}">
                      <li class="page__btn"><a href="/carrental/admin-console/cars/page=${totalPages}/">>></a></li>
                    </c:if>
                </c:if>
          </ul>
        </div>
  </body>
</html>
