M.AutoInit();

$(document).ready(function(){
    $('.slider').slider();
    $('.modal').modal();
});


function iniciarModal() {
    $('.modal').modal();
}

function iniciarSelect() {
    $('select').formSelect('destroy');
    $('select').formSelect();
}