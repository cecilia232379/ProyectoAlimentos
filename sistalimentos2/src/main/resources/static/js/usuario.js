function js_changePag() {
    var js_pagina = document.getElementById("js_pagina");
    window.location = "SPrincipal?pAccion=aListaUsuario&accion=LST&numpag=" + js_pagina.value;
}

function js_usuarioIns() {
    window.location = "SPrincipal?pAccion=aEditaUsuario&accion=ADD";
}

function js_usuarioDel() {
    var js_del = document.getElementsByName("js_del");
    var ids = "";

    for(var i =0; i<js_del.length; ++i) {
        if(js_del[i].checked) {
            ids += js_del[i].value + ",";
        }
    }

    if(ids == "") {
        alert("¡Debe seleccionar Usuario(s) a Retirar!");
    } else {
        if(confirm("¿Seguro de Retirar Usuarios seleccionados?")) {
            ids = ids.substring(0, ids.length - 1);
            window.location = "SPrincipal?pAccion=aEliminaUsuario&accion=DEL&ids=" + ids;
        }
    }
}

function js_usuarioUpd() {
    var js_upd = document.getElementsByName("js_upd");
    var id = "";

    for(var i =0; i<js_upd.length; ++i) {
        if(js_upd[i].checked) {
            id = js_upd[i].value;
            break;
        }
    }

    if(id == "") {
        alert("¡Debe seleccionar Usuario para Actualizar!");
    } else {
        if(confirm("¿Seguro de Actualizar datos de Usuario?")) {
            window.location = "SPrincipal?pAccion=aEditaUsuario&accion=EDT&id=" + id;
        }
    }
}
