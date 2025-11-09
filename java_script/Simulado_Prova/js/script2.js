document.addEventListener("DOMContentLoaded", function(){

    var p = document.createElement("p");
    p.textContent = localStorage.getItem("textoUsuario");
    p.style.fontSize = "18px";
    document.getElementById("colocaTexto").appendChild(p);
    var palavraM = document.getElementById("palavraM");
    var priPalavra = document.getElementById("priPalavra");
    var segPalavra = document.getElementById("segPalavra");
    var ultPalavra = document.getElementById("ultPalavra");
    

    let btn = document.getElementById("btnAnalisa");
    let btnNatal = document.getElementById("btnNatal");

    btn.addEventListener("click", function(){
        var contaM = 0;
        if(document.getElementById("s/n").value=="sim"){
            var vet = p.textContent.split(" ");
            console.log(vet)
            var p2 = document.createElement("scan");
            p2.textContent = vet.length;
            document.getElementById("qtdTexto").appendChild(p2)
            for(let i=0; i<vet.length; i++){
                if(vet[i].match(/^m/i))
                    ++contaM;
            }
            palavraM.value = contaM;
            priPalavra.value = vet[0];
            segPalavra.value = vet[1];
            ultPalavra.value = vet[vet.length-1];
        }else{
            let novoTxt = document.getElementById("novoTxt");
            let txt = novoTxt.value;
            var vet = txt.split(" ");
            var p2 = document.createElement("scan");
            p2.textContent = vet.length;
            document.getElementById("qtdTexto").appendChild(p2)
            for(let i=0; i<vet.length; i++){
                if(vet[i].match(/^m/i))
                    ++contaM;
            }
            palavraM.value = contaM;
            priPalavra.value = vet[0];
            segPalavra.value = vet[1];
            ultPalavra.value = vet[vet.length-1];
        }
    })
    btnNatal.addEventListener("click", function(){
        window.location.href = "felizNatal.html";
    })
});