txt = document.getElementById("txt01");
btn = document.getElementById("btnExibe");
btn.addEventListener("click", alerta);
function alerta() {
    texto = txt.value.toUpperCase();
    alert(`${texto}`)
}