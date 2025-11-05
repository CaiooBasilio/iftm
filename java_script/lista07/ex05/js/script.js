document.addEventListener("DOMContentLoaded", function() {
    
    const name = prompt("Digite seu nome completo:", "Caio Henrque Martins Basilio");
    var p = document.createElement("p");
    p.style.fontSize = "14px";
    p.textContent = name;
    document.getElementById("caixa").appendChild(p);
    var x = 14;

    let interv = setInterval(aumentaNome, 2000);

    function aumentaNome(){
        x += 2;
        p.style.fontSize = x + "px";
        if(x >= 40){
            clearInterval(interv);
        }
    }
})