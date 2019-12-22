var usname;
var usid;

var client = (function () {
    var profin=new Array();
    function goPay() {        
        pagina = "fin.html";
        pagina += "?";
        //nomVec = temp.split(",");
        pagina += "=" + usname+ "&" + usid;
        location.href = pagina;
    }
    
    function goToPage(nombre, iden) {
        var temp = nombre;
        pagina = "inventario.html";
        pagina += "?";
        nomVec = temp.split(",");
        pagina += "=" + temp + "&" + iden;       
        location.href = pagina;
    }
    
    function paintFinpage(cliente){
        profin=cliente.historialCompras;        
        document.getElementById("fincar").innerHTML = "";
        var total=0;
        var carroc="";
        carroc+="<tr>";
        var i; 
        for(i=0; i<profin.length; i++){            
            total+=profin[i].precio;            
            carroc+="<td>"+profin[i].nombre+"</th>";
            carroc+="<td>"+1+"</th>";
            carroc+="<td>"+profin[i].precio+"</th>";   
            carroc+="</tr>";
        }
        document.getElementById("fincar").innerHTML = carroc; 
        document.getElementById("total").innerHTML = total; 
    }
    
    function finPage(){
        var client;        
        producto.setUser();       
        axios.get('/cliente/one/'+usid)
                .then(function (response) {
                    console.log(response.data);                    
                    client = response.data;                  
                    paintFinpage(client);                    
                })
                .catch(error => {
                    console.log(error.response)
                });        
    }

    function InPage() {
        cadVariables = location.search.substring(2, location.search.length);
        arrVariables = cadVariables.split('&');
        usname=arrVariables[0];
        usid=arrVariables[1];
        return arrVariables;
    }

    function sendName() {
        var temp = $("#name").val();
        var temp1 = $("#idti").val();
        var temp2 = temp.split(" ");
        var temp3 = "";
        var i;
        for (i = 0; i < temp3.length; i++) {
            temp2 += temp3[i];
        }
        axios.post('/cliente/add/' + temp2 + "/" + temp1)
                .then(function (response) {
                    console.log(response.data);
                    goToPage(temp, temp1);
                })
                .catch(error => {
                    console.log(error.response)
                });
    }
    return{
        sendName: sendName,
        goToPage: goToPage,
        InPage: InPage,
        goPay:goPay,
        finPage:finPage,
        paintFinpage:paintFinpage
    }
}
)();