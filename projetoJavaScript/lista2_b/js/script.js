import tabelaUsuarios from "./users.js";

document.addEventListener("DOMContentLoaded", function(){
    var sumM;
    var sumF;
    document.getElementById("btn").addEventListener("click", function(){
        if(document.getElementById("slc").value==1){
            tabelaUsuarios.filter(item => item.idade >=18).forEach((item) => console.log(`${item.nome} possui ${item.idade} anos`))

        }else if(document.getElementById("slc").value==2){
            tabelaUsuarios.filter(item => item.sexo.match("M")).forEach(item => console.log(`${item.nome}`));

        }else if(document.getElementById("slc").value==3){
            let val = tabelaUsuarios.reduce((maior, users) => {
                return maior>users.salario ? maior:users.salario
            }, tabelaUsuarios[0]);
            console.log(`O maior salario é de R$${val} reais`)
        }else if(document.getElementById("slc").value==4){
            let valida = tabelaUsuarios.some(item => {
                if(item.sexo.match("F") && item.salario>5000)
                    return true;
            })
            console.log(valida)
        }else if(document.getElementById("slc").value==5){
            sumM =0;
            sumF =0;
            let vetM = tabelaUsuarios.filter(item => item.sexo.match("M"))
            vetM.forEach(item => {
                return sumM += item.salario;
            });
            console.log(`Media de salario masculina ${sumM/vetM.length}`)

            let vetF = tabelaUsuarios.filter(item => item.sexo.match("F"))
            vetF.forEach(item => {
                return sumF += item.salario;
            });
            console.log(`Media de salario feminino ${sumF/vetF.length}`)
        }
    })
})
    