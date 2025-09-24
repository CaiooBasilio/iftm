btnSoma = document.getElementById("soma");
btnMenos = document.getElementById("menos");
btnMulti = document.getElementById("multi");
btnDiv = document.getElementById("div");
val1 = document.getElementById("valor1");
val2 = document.getElementById("valor2");
resul = document.getElementById("resultado");

btnSoma.addEventListener("click", mostraSoma);
btnMenos.addEventListener("click", mostraMenos);
btnMulti.addEventListener("click", mostraMulti);
btnDiv.addEventListener("click", mostraDiv);

function mostraSoma() {
    resul.value=parseFloat(val1.value)+parseFloat(val2.value);
}
function mostraMenos() {
    resul.value=parseFloat(val1.value)-parseFloat(val2.value);
}
function mostraMulti() {
    resul.value=parseFloat(val1.value)*parseFloat(val2.value);
}
function mostraDiv() {
    if(val2.value==0)
        alert("Não existe divisão por zero")
    else
        resul.value=parseFloat(val1.value)/parseFloat(val2.value);
}
if(val1.value=="" || val2.value==""){
    resul.value="Preencha os dois valores";
}
