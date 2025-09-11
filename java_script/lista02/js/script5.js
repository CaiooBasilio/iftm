nrPessoa = parseInt(prompt("Digite o número de pessoas:"));
nome = [];
soma =0;
for (i=0; i<nrPessoa; i++) {
    pessoa = prompt("Digite o nome da pessoa:");
    idade = parseInt(prompt("Digite a idade da pessoa:"));
    nome[i] = pessoa;
    soma += idade;
}
media = soma/nrPessoa;
document.write(`<p> A média de idade é: ${media}</p>`);
posiAleatoria = Math.floor(Math.random()*nrPessoa);
ganhador = nome[posiAleatoria];
document.write(`<p>O ganhador do almoço é: ${ganhador}</p>`);