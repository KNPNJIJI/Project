<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
    crossorigin="anonymous"
  />
  <h1>Add photo for ${car.brand} ${car.model}</h1>
  <security:authorize access="isAuthenticated()">
  <div class="container text-center">
    <div class="row justify-content-center">
      <div class="col align-self-center card col-sm-4">
        <div class="card-body">
          <form
            action="/carrental/image/add-photo/carid=${car.id}/"
            enctype="multipart/form-data"
            method="post"
            onsubmit="onSubmit(event)"
          >

            <label for="photo" class="form-label">Photo</label>
            <input type="file" name="photo" class="form-control" id="photo">

            <input
              type="submit"
              id="sname"
              name="sname"
              value="Done"
              class="btn btn-primary"
            />
          </form>
        </div>
      </div>
    </div>
  </div>
  </security:authorize>
</html>
