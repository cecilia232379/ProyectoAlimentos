function js_changePag() {
    var js_pagina = document.getElementById("js_pagina");
    window.location = "SPrincipal?pAccion=aListaInstitucion&accion=LST&numpag=" + js_pagina.value;
}

function js_institucionIns() {
    window.location = "SPrincipal?pAccion=aEditaInstitucion&accion=ADD";
}

function js_institucionDel() {
    var js_del = document.getElementsByName("js_del");
    var ids = "";

    for(var i =0; i<js_del.length; ++i) {
        if(js_del[i].checked) {
            ids += js_del[i].value + ",";
        }
    }

    if(ids == "") {
        alert("¡Debe seleccionar Institución(s) a Retirar!");
    } else {
        if(confirm("¿Seguro de Retirar Instituciones seleccionados?")) {
            ids = ids.substring(0, ids.length - 1);
            window.location = "SPrincipal?pAccion=aEliminaInstitucion&accion=DEL&ids=" + ids;
        }
    }
}

function js_institucionUpd() {
    var js_upd = document.getElementsByName("js_upd");
    var id = "";

    for(var i =0; i<js_upd.length; ++i) {
        if(js_upd[i].checked) {
            id = js_upd[i].value;
            break;
        }
    }

    if(id == "") {
        alert("¡Debe seleccionar Institución para Actualizar!");
    } else {
        if(confirm("¿Seguro de Actualizar datos de Institución?")) {
            window.location = "SPrincipal?pAccion=aEditaInstitucion&accion=EDT&id=" + id;
        }
    }
}

function js_correoIns(idcliente) {
    window.location = "view/correoIns.jsp?idcliente=" + idcliente;
}

function js_correoDel(index) {
    
    var idcorreo = document.getElementById("idcorreo_" + index).value;

    if((idcorreo == null) || (idcorreo == "")) {
        alert("¡Este Cliente NO tiene correos!");
    } else {
        if(confirm("¿Retirar Correo?")) {
            window.location = "Correo?accion=DEL&ids=" + idcorreo;
        }
    }
}

function js_correoUpd(index){
    var idcorreo = document.getElementById("idcorreo_" + index).value;

    if((idcorreo == null) || (idcorreo == "")) {
        alert("¡Este Cliente NO tiene correos!");
    } else {
        if(confirm("¿Actualizar Correo?")) {
            window.location = "view/correoUpd.jsp?idcorreo=" + idcorreo;
        }
    }
}