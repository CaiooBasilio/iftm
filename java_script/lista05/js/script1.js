personagem = document.getElementById("imgTama");

window.onload = pensa();
personagem.addEventListener("mouseout", pensa);

function pensa(){
    document.getElementById("imgTama").src = "img/ex01/Pensativo.png";
    document.getElementById("fala").innerHTML= "zzzzzzzzz!";
}

personagem.addEventListener("mouseover", susto);
function susto(){
    document.getElementById("imgTama").src = "img/ex01/Assustado.png";
    document.getElementById("fala").innerHTML= "O que você quer?";
}

personagem.addEventListener("click", click);
function click(){
    nome = prompt("Qual o seu nome?", "Caio Basilio");
    if(nome==''){
        document.getElementById("imgTama").src = "img/ex01/Nervoso.png";
        document.getElementById("fala").innerHTML= "Não me faça perder o meu tempo!";
    }else{
        document.getElementById("imgTama").src = "img/ex01/alegre.png";
        document.getElementById("fala").innerHTML= `${nome}, seja bem-vindo!`;
    }
}

