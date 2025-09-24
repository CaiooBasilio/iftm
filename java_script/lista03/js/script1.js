txt = document.getElementById("txt01");
btn = document.getElementById("btnExibe");
btn.addEventListener("click", alerta);
function alerta() {
    alert(`${txt.value}`)
}
