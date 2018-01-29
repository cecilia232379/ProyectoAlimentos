function modificar(Valor)
{
    var f = document.formularioGrid;
    f.accion.value = "MODIF";
    f.Codigo.value = Valor;
    f.submit();
}

function CancelarForm()
{
    $("#tabs").tabs({disabled: [1]});
    $("#tabs").tabs({active: 0});
}