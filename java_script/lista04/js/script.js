btnGera = document.getElementById("gera");
btnGera.addEventListener("click",geraCandi)


function geraCandi(){
    candidatos=[
        {nome:"Simone Tebet", partido:"MDB", img:"Candidato4.png"},
        {nome:"Jair Bolsonaro", partido:"PL", img:"Candidato1.png"},
        {nome:"Ciro Gomes", partido:"PDT", img:"Candidato3.png"},
        {nome:"Lula", partido:"PT", img:"Candidato2.png"}
    ];

    indices = [0,1,2,3];
    nroVotos = Math.round(Math.random()*100);
    vetVotos = [nroVotos, 100-nroVotos];
    indiceSorteado=[];

    for (i=1; i<=2; i++) {
        indice = indices.splice(Math.floor(Math.random()*indices.length), 1)[0];
        indiceSorteado [i-1] = indice;
        document.getElementById(`nomeSorteio${i}`).innerHTML = candidatos[indice].nome;
        document.getElementById(`partidoCandi${i}`).innerHTML = candidatos[indice].partido;
        document.getElementById(`imagemCandi${i}`).src = `img/${candidatos[indice].img}`;
        document.getElementById(`votos${i}`).innerHTML = vetVotos[i-1].toFixed(1);
    }
    if(vetVotos[0] == vetVotos[1]){
        document.getElementById("resultado").innerHTML = "Empate";
    }else if (vetVotos[0] > vetVotos[1]){
        document.getElementById("resultado").innerHTML = candidatos[indiceSorteado[0]].nome;
    }else
        document.getElementById("resultado").innerHTML = candidatos[indiceSorteado[1]].nome;

    // nroVotos = Math.round(Math.random()*100);
    // vetVotos = [nroVotos, 100-nroVotos]

    // sorteo = vet.splice(indiceCad1 = Math.floor(Math.random()*vet.length), 1)[0];
    // document.getElementById("nomeSorteio").innerHTML = candidatos[sorteo].nome;
    // document.getElementById("partidoCandi").innerHTML = candidatos[sorteo].partido;
    // document.getElementById("imagemCandi").src = `img/${candidatos[sorteo].img}`;
    // document.getElementById("votos1").innerHTML = vetVotos[-1].toFixed(1);


    // sorteo2 = vet.splice(indiceCad1 = Math.floor(Math.random()*vet.length), 1)[0];
    // document.getElementById("nomeSorteio2").innerHTML = candidatos[sorteo2].nome;
    // document.getElementById("partidoCandi2").innerHTML = candidatos[sorteo2].partido;
    // document.getElementById("imagemCandi2").src = `img/${candidatos[sorteo2].img}`;
}
geraCandi();