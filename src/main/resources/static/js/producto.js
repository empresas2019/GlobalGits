
var producto = (function () {
    var produc = new Array();

    function carrito(idpro){
        alert(idpro);
        
        
        
    }

    function getAllProduct() {
        var tarjetas = "";
        tarjetas.length = 0;
        axios.get('/producto/all')
                .then(function (response) {
                    console.log(response.data);
                    grouid = response.data;
                    produc = grouid;                   
                    tarj();
                })
                .catch(error => {
                    console.log(error.response)
                });
    }

    function tarj() {
        var tarjetas = "";
        document.getElementById("carts").innerHTML = "";
        var a;
        for (a=0; a<produc.length;a++){            
            tarjetas += "<div id="+a+" class=col-lg-3 col-md-6 mb-4>";
            tarjetas += "<div class=card h-100>";
            tarjetas += "<img class=card-img-top src=http://placehold.it/500x325 alt=>";
            tarjetas += "<div class=card-body>";
            tarjetas += "<h4 class=card-title>"+produc[a].nombre+"</h4>";
            tarjetas += "<p class=card-text>"+produc[a].descripcion+".</p>";
            tarjetas += "<h4 class=card-title>El precio es de: "+produc[a].precio+"</h4>";
            tarjetas += "<p class=card-text> Su identificador es: "+produc[a].id+".</p>";
            tarjetas += "</div>";
            tarjetas += "<div class=card-footer>";            
            tarjetas += "<a onclick=producto.carrito("+produc[a].id+"); class=btn btn-primary btn-lg>Añadir al carrito</a>";
            tarjetas += "</div></div></div>";
        }
        document.getElementById("carts").innerHTML = tarjetas; 
    }
    function getpro() {
        return produc;
    }
   return{
        getAllProduct: getAllProduct,
        tarj: tarj,
        carrito:carrito,
        getpro: getpro



    }
}
)();