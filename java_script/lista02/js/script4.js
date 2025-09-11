N = parseInt(prompt("Digite um número: "));
M = parseInt(prompt("Digite outro número: "));
nrAle = Math.floor(Math.random() * (M - N + 1)) + N;
document.write(nrAle);