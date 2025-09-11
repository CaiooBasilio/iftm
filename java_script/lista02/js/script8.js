jogador1 = ["pedra", "papel", "tesoura"];
jogador2 = ["pedra", "papel", "tesoura"];

indice1 = Math.floor(Math.random()*3);
play1 = jogador1[indice1];
document.write(`<h1>O 1° jogador colocou: <img src='img/${play1}.png'></h1>`)
indice2 = Math.floor(Math.random()*3);
play2 = jogador2[indice2];
document.write(`<h1>O 2° jogador colocou: <img src='img/${play2}.png'></h1>`)

if(indice1 == 0 && indice2==2 || indice1 == 1 && indice2==0 || indice1 == 2 && indice2==1)
    document.write(`<p>Vitoria do 1° jogador</p>`)
else if (indice1 == 2 && indice2==0 || indice1 == 0 && indice2==1 || indice1 == 1 && indice2==0)
    document.write(`<p>Vitoria do 2° jogador</p>`)
else 
    document.write("<p>Empate!!</p>")
   