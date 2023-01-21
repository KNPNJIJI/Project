<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
  <head>
    <link href="${pageContext.request.contextPath}/css/car_datail.css" rel="stylesheet" type="text/css"  crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/pagin.css" rel="stylesheet" type="text/css"  crossorigin="anonymous">
    <script type="text/javascript" src=" https://code.jquery.com/jquery-3.5.1.js"></script>

  </head>
  <body>
    <div class="product-item">
      <img src="/carrental/image/photo/id=${car.carPhoto}/">
    </div>
    <div  class="page_wrapper">
      <ul class="page">
        <c:forEach begin="1" end="${totalPhoto}" var="i">
          <c:choose>
              <c:when test="${currentPhoto eq i}">
                   <li class="page__numbers active">${i}</li>
              </c:when>
              <c:otherwise>
                <li class="page__numbers">
                    <a href="/carrental/car=${car.id}/photo=${i}/">${i}</a>
                </li>
              </c:otherwise>
          </c:choose>
        </c:forEach>
      </ul>
    </div>
      <div class="product-item">
          <div class="product-list">
            <h3>${car.brand} ${car.model} </h3>
            <span class="price">Price ${car.price}</span>
            <a href="/carrental/add-reserve/carid=${car.id}/" class="button">Make a reservation</a>
            <security:authorize access="isAuthenticated()">
              <button onclick="onActivate()"  class="button">
                Activate/deactivate car
              </button>
              <a href="/carrental/image/add-photo/carid=${car.id}/" class="button">Add photo</a>
            </security:authorize>
          </div>
      </div>
  </body>
  <script>

  function onActivate() {
    $.ajax({
          type : 'PUT',
          url : "/carrental/admin-console/deactivate/car=${car.id}/",
          contentType: 'application/x-www-form-urlencoded',
          success : function(data, status, xhr){
            alert( 'Сhanged');
          },
          error: function(xhr, status, error){
            alert(error);
          }
    });
  }


  </script>
</html>