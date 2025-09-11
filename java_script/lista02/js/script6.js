vet = [];
for(i=0; i<60; i++)
    vet[i] = 1*(i+1);
console.log(vet)
for(i=0; i<6; i++){
//gera um numero aleatorio entre 0 e 59
indiceVet = Math.floor(Math.random()*vet.length)
nroSorte = vet[indiceVet];

//remove o elemento sorteado
vet.splice(indiceVet, 1);
console.log(nroSorte)
}
