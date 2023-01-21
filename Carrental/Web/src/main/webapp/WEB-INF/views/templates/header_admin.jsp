<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Car rental admin console</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/pagin.css" rel="stylesheet" type="text/css"  crossorigin="anonymous">

  </head>
  <body>

    <nav class="navbar navbar-expand-lg bg-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="/carrental/index.html">Car rental</a>
      </div>
      <div class="container-fluid">
        <a class="navbar-brand" href="/carrental/admin-console/">Admin console</a>
      </div>
          <security:authorize access="isAuthenticated()">
              <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
          </security:authorize>
          <security:authorize access="!isAuthenticated()">
                  <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
          </security:authorize>

          <security:authorize access="isAuthenticated()">
            <a class="nav-link disabled">Welcome&nbsp;<security:authentication property="name"/>&nbsp;</a>
          </security:authorize>
          <security:authorize access="!isAuthenticated()">
            <a class="nav-link disabled">Welcome&nbsp;anonymous</a>
          </security:authorize>
        </ul>
      </div>
    </nav>
