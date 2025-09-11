carta = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,];
jogador1 = [];
jogador2 = [];
jogador3 = [];
jogador4 = [];
for(i=0; i<3; i++) {
    num = Math.floor(Math.random()*carta.length);
    jogador1[i] = carta[num];
    carta.splice(num, 1);

    num = Math.floor(Math.random()*carta.length);
    jogador2[i] = carta[num];
    carta.splice(num, 1);

    num = Math.floor(Math.random()*carta.length);
    jogador3[i] = carta[num];
    carta.splice(num, 1);

    num = Math.floor(Math.random()*carta.length);
    jogador4[i] = carta[num];
    carta.splice(num, 1);
}
document.write(`<p>Cartas do jogador 1:</p>`);
for(i=0; i<jogador1.length; i++) {
    document.write(`<img src='img/cartas/carta${jogador1[i]}.png'> `);
}
document.write(`<p>Cartas do jogador 2:</p>`);
for(i=0; i<jogador1.length; i++) {
    document.write(`<img src='img/cartas/carta${jogador2[i]}.png'> `);
}
document.write(`<p>Cartas do jogador 3:</p>`);
for(i=0; i<jogador1.length; i++) {
    document.write(`<img src='img/cartas/carta${jogador3[i]}.png'> `);
}
document.write(`<p>Cartas do jogador 4:</p>`);
for(i=0; i<jogador1.length; i++) {
    document.write(`<img src='img/cartas/carta${jogador4[i]}.png'> `);
}
