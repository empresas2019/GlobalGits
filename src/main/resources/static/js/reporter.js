
var reporte = (function () {
    var fechas = new Array();
    var ventas = new Array();
    function getFechas() {
        axios.get('/venta/allf')
                .then(function (response) {
                    console.log(response.data);
                    fechas = response.data;
                })
                .catch(error => {
                    console.log(error.response)
                });
    }

    function busc() {
        var fechI = document.getElementById("se").value;
        var fechF = document.getElementById("se2").value;

        var carroc = "";
        carroc += "<tr>";
        var i;
        for (i = 0; i < ventas.length; i++) {
            if (ventas[i].fechaCompra>=fechI &&ventas[i].fechaCompra<=fechF){
                carroc += "<td>" + ventas[i].clienteCompro.nombre + "</th>";
                carroc += "<td>" + ventas[i].productoVendido.nombre + "</th>";
                carroc += "<td>" + ventas[i].fechaCompra + "</th>";
                carroc += "</tr>";
            }
        }
        document.getElementById("carcom").innerHTML = carroc;
    }

    function getAllVen() {
        axios.get('/venta/all')
                .then(function (response) {
                    console.log(response.data);
                    ventas = response.data;
                    busc();
                })
                .catch(error => {
                    console.log(error.response)
                });
    }

    function paintBus() {
        var clienn = "";
        clienn += "<br><br>";
        clienn += "<p class=lead> Entre esta fecha : .</p>";
        clienn += "<select  id=se name=sef class=selectpicker> ";
        var q;
        for (q = 0; q < fechas.length; q++) {
            clienn += "<option value=" + fechas[q] + ">" + fechas[q] + "</option>";
        }
        clienn += "</select>";
        clienn += "<p class=lead> Y esta : .</p>";
        clienn += "<select  id=se2 name=sef2 class=selectpicker>";
        var f;
        for (f = 0; f < fechas.length; f++) {
            clienn += "<option value=" + fechas[f] + ">" + fechas[f] + "</option>";
        }
        clienn += "</select>";
        clienn += "<br>";
        clienn += "<a  onclick=reporte.getAllVen() class=btn btn-primary btn-lg>Buscar</a>";
        document.getElementById("bu").innerHTML = clienn;
    }

    return{
        busc: busc,
        paintBus: paintBus,
        getFechas: getFechas,
        getAllVen: getAllVen
    }
}
)();