function CallOpcMain(Tipo)
{
    
    if (Tipo === 1)
    {
        var f = document.FormOpcMain;
        f.pAccion.value = "aListado";
    }
    if (Tipo === 2)
    {
        var f = document.FormOpcMain;
        f.pAccion.value = "aLogout";
    }
    if (Tipo === 3)
    {
        var f = document.FormOpcMain;
        f.pAccion.value = "aPerfilSeg";
    }
    f.submit();
}
function CallOpcion(Val1,Val2)
{
    var f = document.FormOpcion;
    f.pAccion.value = "aSesOpcion";
    f.Op.value = Val1;
    f.Os.value = Val2;
    f.submit();
}