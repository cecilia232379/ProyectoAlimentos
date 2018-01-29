function salir(){
     var f = document.formulario;
     f.action = "mainpage.php";
     f.method = "post";
     f.target = "_self";
     f.Pagina.value = "";
     f.submit();
}
function Regresar()
{
    $("#tabs").tabs({disabled: [1]});
    $("#tabs").tabs({active: 0});
    
}
