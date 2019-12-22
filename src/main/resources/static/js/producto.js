
var clie;
var clieN;
var clieId;


var producto = (function () {
    var produc = new Array();
    var procarrito=new Array();

    function carrito(idpro){
        alert(idpro);
        var a;
        for(a=0; a<produc.length ;a++){
            if(produc[a].id==idpro){
                
                procarrito.push(produc[a]);                   
                axios.post('/cliente/addprod/' + clieId+"/"+idpro)
                .then(function (response) {
                    console.log(response.data);                        
                 
                })
                .catch(error => {
                    console.log(error.response)
                });
                
                
            }
        }
        carritoP();
        
    }
    
    function carritoP(){
        document.getElementById("carcom").innerHTML = "";
        var total=0;
        var carroc="";
        carroc+="<tr>";
        var i;
        alert(procarrito.length);
        for(i=0; i<procarrito.length; i++){
            
            total+=procarrito[i].precio;
            
            carroc+="<td>"+procarrito[i].nombre+"</th>";
            carroc+="<td>"+1+"</th>";
            carroc+="<td>"+procarrito[i].precio+"</th>";   
            carroc+="</tr>";
        }
        document.getElementById("carcom").innerHTML = carroc; 
        document.getElementById("total").innerHTML = total; 
        
        
        
        
    }
    

    function getAllProduct() {
        var tarjetas = "";
        tarjetas.length = 0;
        axios.get('/producto/all')
                .then(function (response) {
                    console.log(response.data);
                    grouid = response.data;
                    produc = grouid;                   
                    tarj(setUser);
                })
                .catch(error => {
                    console.log(error.response)
                });
    }

    function tarj(callback) {
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
        //clie=client.InPage();
        
        callback();
    }
    
    function setUser(){
        
        clie=client.InPage();
        clieN=String(clie[0]);
        clieId=clie[1];
        var textn="Bienvenido usuario : "+clieN;
        var textid="Identificado con :"+clieId;
        
        document.getElementById("usn").innerHTML=textn;
        document.getElementById("usid").innerHTML=textid;
        
    }
    
    
    function getpro() {
        return produc;
    }
   return{
        getAllProduct: getAllProduct,
        tarj: tarj,
        carrito:carrito,
        getpro: getpro,
        setUser:setUser



    }
}
)();