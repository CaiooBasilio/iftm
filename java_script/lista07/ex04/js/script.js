document.addEventListener("DOMContentLoaded", function() {

    const n = parseInt(prompt("Quantos nomes deseja inserir?", "3"));
    let nomes = [];
    const btn = document.getElementById("add");

    btn.addEventListener("click", adiciona);

    function adiciona(){
        var pegaNome = document.getElementById("nome");
        if(pegaNome !== ""){
            nomes.push(pegaNome.value);
            pegaNome.value =  " ";
        }
        if(nomes.length === n){
            btn.disabled = true;
            var interv = setInterval(printaNomes, 1000);
        }
    }
    function printaNomes() {
        var p = document.createElement("p");
        p.textContent = nomes[0];
        nomes.splice(0, 1);
        document.getElementById("caixa").appendChild(p);
    }
    clearInterval(interv);
});