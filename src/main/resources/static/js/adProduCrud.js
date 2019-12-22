
var ProdCrud = (function () {
    var n = -1;
    var nombre = "";
    var id = -1;
    var descripcion = "";
    var precio = -1;
    function addPro() {
        var temp0 = $("#name").val();
        var temp1 = $("#descr").val();
        var e = temp1.replace(" ", "-");
        var temp2 = $("#pre").val();
        var temp3 = $("#idti").val();
        axios.post('/producto/add/' + temp0 + "/" + e + "/" + temp2 + "/" + temp3)
                .then(function (response) {
                    console.log(response.data);
                })
                .catch(error => {
                    console.log(error.response)
                });
    }

    function editProd2() {
        var temp0 = $("#name").val();
        var temp1 = $("#descr").val();
        var e = temp1.replace(" ", "-");
        var prue = document.getElementById("descr").value;
        var ee = "";
        var q;
        for (q = 0; q < e.length; q++) {
            if (e[q] != " ") {
                ee += e[q];
            }
        }
        var temp2 = $("#pre").val();
        var temp3 = $("#idti").val();
        axios.post('/producto/change/' + temp0 + "/" + ee + "/" + temp2 + "/" + id)
                .then(function (response) {
                    console.log(response.data);
                    confirm("El producto fue actualizado satisfactoriamente.");
                })
                .catch(error => {
                    console.log(error.response)
                });
    }

    function editProd() {
        var temp1 = $("#idti").val();
        axios.get('/producto/one/' + temp1)
                .then(function (response) {
                    console.log(response.data);
                    pro = response.data;
                    if (pro.nombre != null) {
                        nombre = pro.nombre;
                        id = pro.id;
                        descripcion = pro.descripcion;
                        precio = pro.precio;
                        if (n == 0) {
                            editPro2(pro);
                        } else if (n == 1) {
                            eraserPaint2(pro);
                        } else {
                            confirm("Ocurrio un error, vuelva a intentar");
                        }
                    } else {
                        confirm("No se encontro un cliente con esa identificacion, vuelve a intentar.");
                    }
                })
                .catch(error => {
                    console.log(error.response)
                });
    }
    function eraserPro() {
        axios.post('/producto/eraser/' + id)
                .then(function (response) {
                    console.log(response.data);
                    confirm("El producto fue eliminado satisfactoriamente.");
                })
                .catch(error => {
                    console.log(error.response)
                });
    }

    function paintAdd() {       
        var clienn = "";
        clienn += "<br><br>";
        clienn += "<p class=lead>Ingerse el nombre del producto.</p>  ";
        clienn += "<input type=text id=name class=form-control placeholder=nombre>";
        clienn += "<br>";
        clienn += "<p class=lead>Ingerse la descripcion del producto.</p>  ";
        clienn += "<input type=text id=descr class=form-control placeholder=deescripcion>";
        clienn += "<br>";
        clienn += "<p class=lead>Ingerse el precio del producto.</p>  ";
        clienn += "<input type=number id=pre class=form-control placeholder=9999>";
        clienn += "<br>";
        clienn += "<p class=lead>Ingrese la identificacion del producto.</p> ";
        clienn += "<input type=number id=idti class=form-control placeholder=123456> ";
        clienn += "<br>";
        clienn += "<a onclick=ProdCrud.addPro() class=btn btn-primary btn-lg>Agrergar</a>";
        document.getElementById("prod").innerHTML = clienn;
    }
    
    function editPro() {
        n = 0;
        var clienn = "";
        clienn += "<br><br>";
        clienn += "<p class=lead> Ingrese el id del producto a consultar.</p>  ";
        clienn += "<br>";
        clienn += "<p class=lead>Identificacion.</p> ";
        clienn += "<input type=number id=idti class=form-control placeholder=Ingrese el ID> ";
        clienn += "<br>";
        clienn += "<a onclick=ProdCrud.editProd() class=btn btn-primary btn-lg>Consultar</a>";
        document.getElementById("prod").innerHTML = clienn;
    }

    function editPro2(producto) {
        nombre = producto.nombre;
        id = producto.id;
        descripcion = producto.descripcion;
        precio = producto.precio;
        var clienn = "";
        clienn += "<br><br>";
        clienn += "<p class=lead>Ingerse un nueuvo nombre del producto. Anterior mente : " + nombre + "</p>  ";
        clienn += "<input type=text id=name class=form-control placeholder=nombre>";
        clienn += "<br>";
        clienn += "<p class=lead>Ingerse una nueuva descripcion del producto.Anterior mente : " + descripcion + "</p>  ";
        clienn += "<input type=text id=descr class=form-control placeholder=deescripcion>";
        clienn += "<br>";
        clienn += "<p class=lead>Ingerse un nuevo precio del producto.Anterior mente : " + precio + "</p>  ";
        clienn += "<input type=number id=pre class=form-control placeholder=9999>";
        clienn += "<br>";
        clienn += "<p id=idti class=lead>La identificacion del producto es: " + id + ".</p> ";
        clienn += "<br>";
        clienn += "<a onclick=ProdCrud.editProd2() class=btn btn-primary btn-lg>Actualizar</a>";
        document.getElementById("prod").innerHTML = clienn;
    }
    
    function eraserPaint() {
        n = 1;
        var clienn = "";
        clienn += "<br><br>";
        clienn += "<p class=lead> Ingrese el id del producto a consultar.</p>  ";
        clienn += "<br>";
        clienn += "<p class=lead>Identificacion.</p> ";
        clienn += "<input type=number id=idti class=form-control placeholder=Ingrese el ID> ";
        clienn += "<br>";
        clienn += "<a onclick=ProdCrud.editProd() class=btn btn-primary btn-lg>Consultar</a>";
        document.getElementById("prod").innerHTML = clienn;
    }
        
    function eraserPaint2(producto){
        nombre = producto.nombre;
        id = producto.id;
        descripcion = producto.descripcion;
        precio = producto.precio;
        var clienn = "";
        clienn += "<br><br>";
        clienn += "<p class=lead>Ingerse un nueuvo nombre del producto. Anterior mente : " + nombre + "</p>  ";        
        clienn += "<br>";
        clienn += "<p class=lead>Ingerse una nueuva descripcion del producto.Anterior mente : " + descripcion + "</p>  ";       
        clienn += "<br>";
        clienn += "<p class=lead>Ingerse un nuevo precio del producto.Anterior mente : " + precio + "</p>  ";        
        clienn += "<br>";
        clienn += "<p id=idti class=lead>La identificacion del producto es: " + id + ".</p> ";
        clienn += "<br>";
        clienn += "<a onclick=ProdCrud.eraserPro() class=btn btn-primary btn-lg>Eliminar</a>";
        document.getElementById("prod").innerHTML = clienn;        
    }

    return{
        addPro: addPro,
        editPro: editPro,
        eraserPro: eraserPro,
        paintAdd: paintAdd,
        editPro: editPro,
        editPro2: editPro2,
        editProd: editProd,
        editProd2: editProd2,
        eraserPaint: eraserPaint,
        eraserPaint2:eraserPaint2        
    }
}
)();