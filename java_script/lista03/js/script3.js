btn = document.getElementById("btnTop");
val1 = document.getElementById("valor1");
valFim= document.getElementById("valorFinal");

btn.addEventListener("click", mostraDobro);
function mostraDobro(){
    valFim.value = val1.value *2;
}