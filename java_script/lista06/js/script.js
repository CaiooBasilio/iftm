vetCartas = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27];
pares = [];

for(i=0; i<4; i++){
    par = vetCartas[Math.floor(Math.random()*vetCartas.length)];//adiciona um valor aleatorio no vetor;
    pares.push(par, par);//adiciona o mesmo valor no vetor para que assim haja os pares no mesmo vetor
    vetCartas.splice(vetCartas.indexOf(par), 1);//pega o indice do valor que foi sorteado e retira do vetor principal
}

function embaralharVetor(vet){
    for(i=pares.length-1; i>0; i--){//vai passar de tras pra fente no vetor de pares
        j = Math.floor(Math.random()*(i+1));//sortear qualquer indice do vetor
        [vet[i], vet[j]]=[vet[j],vet[i]];//aqui ele faz a troca sem precisar de uma outra variavel tipo aquele temp que usa no java.
    }
    return vet;
}
embaralharVetor(pares);
for(i=0; i<pares.length; i++){
    document.getElementById(`carta${i}`).src = `img/carta${pares[i]}.png`;
}