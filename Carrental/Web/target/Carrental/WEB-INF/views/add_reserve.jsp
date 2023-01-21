<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="templates/_header.jsp"/>
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
    crossorigin="anonymous"
  />
  <h2>Reserve car</h2>
  <h3>${car.brand} ${car.model} </h3>
  <div class="container text-center">
    <div class="row justify-content-center">
      <div class="col align-self-center card col-sm-4">
        <div class="card-body">
          <form
            action="/carrental/add-reserve/carid=${car.id}/"
            method="post"
            onsubmit="onSubmit(event)"
          >
            <label class="form-label" for="firstName">First name:</label>
            <input
              class="form-control"
              type="text"
              id="firstName"
              name="firstName"
              required
            />
            <label class="form-label" for="lastName">Last name:</label>
            <input
              class="form-control"
              type="text"
              id="lastName"
              name="lastName"
              required
            />
            <label class="form-label" for="phone"
              >Enter your phone number:</label
            >
            <input
              class="form-control"
              type="tel"
              id="phone"
              name="phone"
              placeholder="8012-345-67-89"
              pattern="[0-9]{4}-[0-9]{3}-[0-9]{2}-[0-9]{2}"
            />
            <label class="form-label" for="email">Enter your email:</label>
            <input class="form-control" type="email" id="email" name="email" />

            <label for="startRent">Start rent:</label>
            <input type="date" id="startRent" name="startRent">

            <label for="endRent">End rent:</label>
            <input type="date" id="endRent" name="endRent"><br />
            <span id="error"></span><br />

            <input
              type="submit"
              id="sname"
              name="sname"
              value="Reserve"
              class="btn btn-primary"
            />
          </form>
        </div>
      </div>
    </div>
  </div>

  <script type="text/javascript">
      document.getElementById('startRent').valueAsDate = new Date();
      document.getElementById('startRent').min = new Date().toISOString().split("T")[0];

      document.getElementById('endRent').valueAsDate = new Date();
      document.getElementById('endRent').min = new Date().toISOString().split("T")[0];

    const error = document.getElementById("error");

    function onSubmit(event) {
      const email = document.getElementById("email").value;
      const phone = document.getElementById("phone").value;

      if (email == "" && phone == "") {
        error.textContent = "Please enter a valid phone or email";
        error.style.color = "red";
        event.preventDefault();
      } else {
        error.textContent = "";
      }
    }
  </script>
<jsp:include page="templates/_footer.jsp"/>
