<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="templates/_header.jsp"/>

<label for="startRent">Start rent:</label>
<input type="date" id="startRent" name="startRent">

<label for="endRent">End rent:</label>
<input type="date" id="endRent" name="endRent"><br />

<select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example"
        onChange="selectBrandFunction(this.value)" name="selectBrand" id="selectBrand">
  <option selected>Select brand</option>
  <c:forEach items="${brands}" var="brand">
     <option value="${brand}">${brand}</option>
  </c:forEach>
</select>

<select class="form-select form-select-sm" aria-label=".form-select-sm example"
        onChange="selectModelFunction(this.value)" name="selectModel" id = "selectModel">
  <option selected>Select model</option>
  <option value="1">One</option>
</select>

<h1>Cars</h1>
<table id="carsTable" class="display" style="width:100%"></table>

<script type="text/javascript">
  var tableCars;
  var brandAuto;

  var startRent = document.getElementById('startRent');
  startRent.valueAsDate = new Date();
  startRent.min = new Date().toISOString().split("T")[0];

  var endRent = document.getElementById('endRent');
  endRent.valueAsDate = new Date();
  endRent.min = new Date().toISOString().split("T")[0];

  $(document).ready(function () {
    tableCars = $('#carsTable').DataTable({
        ajax: {
            url: '/carrental/api/cars/brand=' + 'all/' ,
            dataSrc: ''
            //type: 'POST',
        },
        columns: [

          {
            title: 'Brand',
            data: {Brand:"Brand", Id:"Id"},
            render: function (data, type, full) {
                        return '<a href="/carrental/car=' + data.Id + '/photo=1/">' + data.Brand + '</a>';
                   }
          },
          {
            title: 'Model',
            data: 'Model'
          },
          {
            title: 'Price',
            data: 'Price'
          },
          {
            title: 'Year Manufacture',
            data: 'Year Manufacture'
          },
          {
            title: 'Car Photo',
            data: 'CarPhoto',
            render: function (idPhoto) {
                return '<img src="/carrental/image/photo/id=' + idPhoto + '/" width="50"/>';
            }
          },
        ],
    });
  });

    document.getElementById("selectModel").style.visibility = "hidden";

    function selectBrandFunction(index){ //this.selectedIndex
        if (index != "Select brand"){
            brandAuto = index;
            tableCars.ajax.url('/carrental/api/cars/brand=' + index + '/' );
            tableCars.ajax.reload();

            const xhr = new XMLHttpRequest();
            xhr.open('get', '/carrental/model/brand=' + index+ '/', true);
            //xhr.open('get', '/carrental/homePageShow-cars.html', true);
            xhr.send();

            xhr.onreadystatechange = function () {
            //если состояние запроса - конец выполнения (4)
              if (xhr.readyState === 4){
                  console.log('xhr.readyState = 4');
                  // если ответ положительный ОК (200)
                  if(xhr.status === 200) {
                      console.log('xhr.status = 200');
                      //  console.log(xhr.responseText);
                      var modelValues = JSON.parse(xhr.responseText);
                      var nCurrModelValuesCnt = modelValues.length;
                      var oModelValues = document.getElementById('selectModel');
                      oModelValues.length = 0; // удаляем все элементы option из списка

                      var newModelListOption = document.createElement("OPTION");
                      newModelListOption.text = 'Select model';
                      newModelListOption.value = 'Select model';
                      (oModelValues.options.add) ? oModelValues.options.add(newModelListOption) : oModelValues.add(newModelListOption, null);


                      for (i = 0; i < nCurrModelValuesCnt; i++){
                          // далее мы добавляем необходимые Model в список
                          if (document.createElement){
                              newModelListOption = document.createElement("OPTION");
                              newModelListOption.text = modelValues[i];
                              newModelListOption.value = modelValues[i];
                              // тут мы используем для добавления элемента либо метод IE, либо DOM, которые, alas, не совпадают по параметрам…
                              (oModelValues.options.add) ? oModelValues.options.add(newModelListOption) : oModelValues.add(newModelListOption, null);
                          }else{
                              // для NN3.x-4.x
                              oModelValues.options[i] = new Option(modelValues[i], modelValues[i], false, false);
                          }
                      }
                  }
                  else {
                      console.log(xhr.statusText);// вызвать обработчик ошибки с текстом ответа
                      console.log('xhr.statusText = not 200');
                  }
              }else{
                  console.log('xhr.readyState = ???');
              }
            }
            document.getElementById("selectModel").style.visibility = "visible";
        }
    }

    function selectModelFunction(modelAuto){
        tableCars.ajax.url('/carrental/api/cars/brand=' + brandAuto + '/model=' + modelAuto + '/' );
        tableCars.ajax.reload();
    }

    function selectDateStart(){
    dateControl.value = '2017-06-01';
    console.log(dateControl.value);
    }

    // инициируем изменение элементов в списке брендов
    //selectBrandFunction(document.elements["selectBrand"].selectedIndex);

</script>

<jsp:include page="templates/_footer.jsp"/>
