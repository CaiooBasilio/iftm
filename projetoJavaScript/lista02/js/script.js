document.addEventListener("DOMContentLoaded", function(){
    let vet = [12, 15, 18, 21, 23, 25, 27, 30, 32, 34, 36, 38, 40, 42, 45, 47, 50, 52, 54, 56, 58, 60];

    var sum;
    var maiorIdade
    var texto
    var cont
    
    let btn = document.getElementById("btn").addEventListener("click", function(){
        if(document.getElementById("slc").value=="1"){// LETRA A
            sum = 0;
            vet.forEach(somando);
            document.getElementById("resposta").value = sum 

        }else if(document.getElementById("slc").value=="2"){// LETRA B
            sum =0;
            vet.forEach(somando)
            var media = sum/vet.length;
            document.getElementById("resposta").value = media

        }else if(document.getElementById("slc").value=="3"){
            maiorIdade = 0;
            vet.forEach(maiorNumero)
            document.getElementById("resposta").value = maiorIdade;

        }else if(document.getElementById("slc").value=="4"){
            texto = "";
            let impares = vet.filter((n) => n %2!= 0)
            impares.forEach(mostraVetor)
            document.getElementById("resposta").value = texto;

        }else if(document.getElementById("slc").value=="5"){
            let todosMaiores18 = vet.every((item) => item >=18)
            document.getElementById("resposta").value = todosMaiores18;

        }else if(document.getElementById("slc").value=="6"){
            var numeroDigitado = prompt("Digite um numero");
            let todosMaioresQueTalNum = vet.every((item) => item >= numeroDigitado);
            document.getElementById("resposta").value = todosMaioresQueTalNum;

        }else if(document.getElementById("slc").value=="7"){
            var numeroDigitado = prompt("Digite um numero");
            texto = "São maiores ou igual a " + numeroDigitado +": ";
            vet.forEach((item) => compara(item, numeroDigitado))
            document.getElementById("resposta").value = texto;

        }else if(document.getElementById("slc").value=="8"){
            sum = 0;
            cont = 0;
            var numeroDigitado = prompt("Digite um numero");
            vet.forEach((item) => somarDigitado(item, numeroDigitado))
            var media = sum/cont;

            texto = "A media das idades maiores ou iguai a " + numeroDigitado +": " + media;
            document.getElementById("resposta").value = texto;
        }
    })

    const somando = (item) => sum+= item;

    const somarDigitado = (item, num) =>{
        if(item>=num){
            sum += item
            cont +=1
        }
    }

    const maiorNumero = (item) =>{
        if(item>=maiorIdade)
            maiorIdade = item
    }

    const mostraVetor = (item) =>{
        texto += item + " ";
    }

    const compara = (item, num) =>{
        if (item>=num)
            texto += item +" ";
    }

})
