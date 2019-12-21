


var client = (function () {


    function sendName() {
        var temp = $("#name").val();
        alert(temp);
        var temp2 = temp.split(" ");
        var temp3 = "";
        var i;
        for (i = 0; i < temp3.length; i++) {
            temp2 += temp3[i];
        }
        axios.post('/cliente/add/' + temp2)
                .then(function (response) {
                    console.log(response.data);

                })
                .catch(error => {
                    console.log(error.response)
                });
    }
    return{
        sendName: sendName



    }




}




)();