
function buscarEndereco() {
    var cep = document.getElementById("idForm:cepDelegacia").value;
    $.get("http://apps.widenet.com.br/busca-cep/api/cep.json", { code: cep },
        function(result){
            if( result.status!=1 ){
                alert(result.message || "Houve um erro desconhecido");
                return;
            }
            document.getElementById("idForm:ruaDelegacia").value = result.address;
            document.getElementById("idForm:bairroDelegacia").value = result.district;
            document.getElementById("idForm:cidadeDelegacia").value = result.city;
            document.getElementById("idForm:estadoDelegacia").value = result.state;
        });
}


$(document).ready( function () {




});