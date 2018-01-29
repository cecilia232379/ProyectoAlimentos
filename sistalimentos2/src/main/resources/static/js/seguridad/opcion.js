function ModificaOrden(Opcion, Orden, Tipo)
{
    var f = document.formularioGrid;
    f.Codigo.value = Opcion;
    f.Orden.value  = Orden;
    if (Tipo === 1)
    {
        //SUBIDA
        f.TipoOrden.value = 1;
    }
    else
    {
        //BAJADA
        f.TipoOrden.value = 2;
    }
    f.accion.value = "MODIFICAORDEN";
    f.submit();
}

function showModulos() 
{
    var sistema = $("#cboSistemas").val();
    var modulo  = $("#cboModulos").val();
    var vSelected = "${ oModulo.modsistema }"
    if (sistema.val != "")
    $("#divModulo").load("SAnidados?accion=Modulos", {pSistema: sistema, pSelected: vSelected})
    $("#divOpcion").load("SAnidados?accion=Opciones", {pSistema: modulo, pSelected: ""})
}

function showOpciones() 
{
    var modulo = $("#cboModulos").val();
    var vSelected = "${ oOpcion.opcmodulo }"
    if (modulo.val != "")
    $("#divOpcion").load("SAnidados?accion=Opciones", {pSistema: modulo, pSelected: vSelected})
}

function desactivamenu()
{
    var f = document.formulario;
    if (document.formulario.ck1.checked)
    {
        f.opcionPadre.disabled = true;
    }
    else
    {
        f.opcionPadre.disabled = false;
    }
}
    
function nuevo()
{
    var f = document.formularioGrid;
    f.accion.value = "NUEVO";
    f.Codigo.value = "";
    f.submit();
}
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
    }
    else
    {
        return;
    }
}


    