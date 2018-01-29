function nuevo()
{
    $("#tabs").tabs({disabled: [0,1]});
    $("#tabs").tabs({active: 2});
}
function salir()
{
    $("#tabs").tabs({disabled: [1,2]});
    $("#tabs").tabs({active: 0});
}
function salir2()
{
    $("#tabs").tabs({disabled: [0,2]});
    $("#tabs").tabs({active: 1});
}
function modificar(Valor)
{
    var f = document.formularioGrid;
    f.accion.value = "ADDUSER";
    f.CodigoSist.value = Valor;
    f.submit();
}

function claves(Valor)
{
    var f = document.formularioGrid2;
    if (confirm('¿Desea reiniciar la contraseña para este usuario?'))
    {
        f.accion.value = "UPDCLAVE";
        f.CodigoUsuario.value = Valor;
        f.submit();
    }
    else
    {
        return;
    }
}

function modificarUsuario(Valor)
{
    var f = document.formularioGrid2;
    f.accion.value = "MODIFUSER";
    f.CodigoUsuarioPerfil.value = Valor;
    f.submit();
}

function eliminarUsuario(Valor)
{
    var f = document.formularioGrid2;
    if (confirm('¿Desea eliminar este registro?'))
    {
        f.accion.value = "DEL";
        f.CodigoUsuarioPerfil.value = Valor;
        f.submit();
    }
    else
    {
        return;
    }
}

function ValidarUsuario()
{
    var f = document.formulario;
    if (f.Usuario.value === "")
    {
        alert("Ingrese un número de DNI"); return;
    }
    
    f.accion.value = "SEARCHUSER";
    f.submit();
}