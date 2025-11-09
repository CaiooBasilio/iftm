document.addEventListener("DOMContentLoaded", function(){

    let qtn = document.getElementById("quantidade");
    let btn = document.getElementById("btn");

    btn.addEventListener("click", function(){
        var p = document.createElement("p");
        p.textContent = "Ho Ho Ho Feliz Natal!";
        var n = parseInt(qtn.value)
        for(let i = 0; i<n; i++){
            let clone = p.cloneNode(true);
            document.getElementById("caixa").appendChild(clone);
        }
    })
})