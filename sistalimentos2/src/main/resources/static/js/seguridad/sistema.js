
function modificar(Valor)
{
    var f = document.formularioGrid;
    f.accion.value = "MODIF";
    f.Codigo.value = Valor;
    f.submit();
}
function eliminar(Valor)
{
    var f = document.formularioGrid;
    if (confirm('¿Desea eliminar este registro?'))
    {
        f.accion.value = "DEL";
        f.Codigo.value = Valor;
        f.submit();
    } else
    {
        return;
    }
}