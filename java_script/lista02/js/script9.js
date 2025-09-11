nroPessoas = parseInt(prompt("Número de pessoas:"));
nomes = [];
for(i=0; i<nroPessoas; i++) {
    nomes[i] = prompt("Nome da pessoa: ");
}
posi = 1;
document.write("<h2>Ordem de apresentação:</h2>");
for(i=0; i<nroPessoas; i++) {
    idiceSorteado = Math.floor(Math.random()*nomes.length);
    document.write(`<p>${posi}° - ${nomes[idiceSorteado]}</p>`);
    nomes.splice(idiceSorteado, 1);
    posi++;
}
