

var clientCro = (function () {
    var n=-1;
    
    var nombre=-2;
    var id=-2;

    function addClien() {
        var temp = $("#name").val();
        var temp1 = $("#idti").val();
        
        axios.post('/cliente/add/' + temp + "/" + temp1)
                .then(function (response) {
                    console.log(response.data);
                    //goToPage(temp, temp1);
                })
                .catch(error => {
                    console.log(error.response)
                });                      
    }
    
    function editClien(){
        
        var temp1 = $("#idti").val();
         axios.get('/cliente/one/'+temp1)
                .then(function (response) {
                    console.log(response.data);                    
                    client = response.data;  
                    
                    if(client.nombre!=null){
                        alert(n);
                        nombre=client.nombre;
                        id=client.id;
                        if(n==0){
                            editPaint2(client);
                            
                        }else if(n==1){
                            
                            eraserPaint2(client);
                        }else{
                            alert("nada");
                        }
                        
                    }else{
                        confirm("No se encontro un cliente con esa identificacion, vuelve a intentar.");
                    }
                    
                })
                .catch(error => {
                    console.log(error.response)
                });      
    }
    
    function editClien2(){
        var temp = $("#name").val();
        var temp1 = $("#idti").val();
        

        
        axios.post('/cliente/change/' + temp + "/" + id)
                .then(function (response) {
                    console.log(response.data);
                    
                })
                .catch(error => {
                    console.log(error.response)
                });                      
    }
    
    function eraseClien(){
              var temp = $("#name").val();
        var temp1 = $("#idti").val();
        
        alert(temp1);
        
        axios.post('/cliente/eraser/'+ id)
                .then(function (response) {
                    console.log(response.data);
                    confirm("El cliente ha sido eliminado satisfactoriamente.");
                })
                .catch(error => {
                    console.log(error.response)
                });                              
    }
    function addPaint(){
        var clienn="";
        clienn+="<br><br>";
        clienn+="<p class=lead> Nombre.</p>  ";
        clienn+="<input type=text id=name class=form-control placeholder=Ingrese su nombre para continuar>";
        clienn+="<br>";
        clienn+="<p class=lead>Identificacion.</p> ";
        clienn+="<input type=number id=idti class=form-control placeholder=Ingrese su id para continuar> ";
        clienn+="<br>";
        clienn+="<a onclick=clientCro.addClien() class=btn btn-primary btn-lg>Agrergar</a>";        
        document.getElementById("prod").innerHTML = clienn; 
        
        
        
        
        
    }
    function editPaint(){
        n=0;
        var clienn="";
        clienn+="<br><br>";
        clienn+="<p class=lead> Ingrese el id del cliente a consultar.</p>  ";
        
        clienn+="<br>";
        clienn+="<p class=lead>Identificacion.</p> ";
        clienn+="<input type=number id=idti class=form-control placeholder=Ingrese el ID> ";
        clienn+="<br>";
        clienn+="<a onclick=clientCro.editClien() class=btn btn-primary btn-lg>Consultar</a>";        
        document.getElementById("prod").innerHTML = clienn;   
        
    }
    
    function editPaint2(cliente){
        nombre=cliente.nombre;
        id=cliente.identificacion;
        alert(id);
        var clienn="";
        clienn+="<br><br>";
        clienn+="<p class=lead> Ingrese el nueuvo nombre para el cliente</p>  ";
        clienn+="<input type=text id=name class=form-control placeholder="+cliente.nombre+">";
        clienn+="<br>";
        clienn+="<p class=lead>El id del cliente es :"+cliente.identificacion+"</p> ";
        
        clienn+="<br>";
        clienn+="<a onclick=clientCro.editClien2() class=btn btn-primary btn-lg>Enviar</a>";        
        document.getElementById("prod").innerHTML = clienn;   
        
    }
    function eraserPaint(){
        n=1;
          var clienn="";
        clienn+="<br><br>";
        clienn+="<p class=lead> Ingrese el id del cliente a eliminar.</p>  ";
        
        clienn+="<br>";
        clienn+="<p class=lead>Identificacion.</p> ";
        clienn+="<input type=number id=idti class=form-control placeholder=Ingrese el ID> ";
        clienn+="<br>";
        clienn+="<a onclick=clientCro.editClien() class=btn btn-primary btn-lg>Consultar</a>";        
        document.getElementById("prod").innerHTML = clienn;   
    }
    
    function eraserPaint2(cliente){
        document.getElementById("prod").innerHTML = "";   
        nombre=cliente.nombre;
        id=cliente.identificacion;
        alert(id);
        var clienn="";
        clienn+="<br><br>";
        clienn+="<p class=lead> Desea eliminar al cliente : "+cliente.nombre+"</p>  ";
        
        clienn+="<br>";
        clienn+="<p class=lead>El id del cliente es :"+cliente.identificacion+"</p> ";
        
        clienn+="<br>";
        clienn+="<a onclick=clientCro.eraseClien() class=btn btn-primary btn-lg>Eliminar</a>";        
        document.getElementById("prod").innerHTML = clienn;
        
        
    }
    

    
    return{
        addClien: addClien,
        editClien:editClien,
        eraseClien:eraseClien,
        addPaint:addPaint,
        editPaint:editPaint,
        editPaint2:editPaint2,
        editClien2:editClien2,
        eraserPaint:eraserPaint,
        eraserPaint2:eraserPaint2
       



    }




}




)();