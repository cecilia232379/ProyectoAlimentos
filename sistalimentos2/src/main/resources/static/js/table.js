function ilumina(fila) {
    fila.style.background = "#aaa";
    fila.style.color = "#fff";
}

function restaura(fila, clase) {
    if(clase == "f1") {
        fila.style.background = "#fff";
        fila.style.color = "#444";
    } else if(clase == "f2") {
        fila.style.background = "#ddd";
        fila.style.color = "#444";
    }
}


