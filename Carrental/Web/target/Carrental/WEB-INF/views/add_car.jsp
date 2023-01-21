<!DOCTYPE html>
<html>
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
    crossorigin="anonymous"
  />
  <h1>Add car</h1>
  <div class="container text-center">
    <div class="row justify-content-center">
      <div class="col align-self-center card col-sm-4">
        <div class="card-body">
          <form
            action="/carrental/admin-console/car.html"
            enctype="multipart/form-data"
            method="post"
            onsubmit="onSubmit(event)"
          >

            <label for="photo" class="form-label">Photo</label>
            <input type="file" name="photo" class="form-control" id="photo">

            <label class="form-label" for="brand">Brand:</label>
            <input
              class="form-control"
              type="text"
              id="brand"
              name="brand"
              required
            />
            <label class="form-label" for="model">Model:</label>
            <input
              class="form-control"
              type="text"
              id="model"
              name="model"
              required
            />
            <label class="form-label" for="yearManufacture">Price:</label>
                <input
                  class="form-control"
                  type="text"
                  id="price"
                  name="price"
                  required
                /><br />
            <label class="form-label" for="yearManufacture">Year manufacture:</label>
            <input
              class="form-control"
              type="text"
              id="yearManufacture"
              name="yearManufacture"
              pattern="[0-9]{4}"
              required
            /><br />
            <!--label class="form-label" for="rentOut"> Activate: </label>
            <input
              type="checkbox"
              id="rentOut"
              name="rentOut"
              value="rentOut"
            /><br /-->

            <span id="error"></span><br />

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

  <script type="text/javascript">
    const error = document.getElementById("error");

    function onSubmit(event) {

    }
  </script>
</html>
