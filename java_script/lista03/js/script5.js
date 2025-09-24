btn = document.getElementById("btnTop");
nota1 = document.getElementById("bimestre1");
nota2 = document.getElementById("bimestre2");

btn.addEventListener("click", mostraResul);

function mostraResul(){
    n1 = parseFloat(nota1.value);
    n2 = parseFloat(nota2.value);
    if(n1>50 || n2>50)
        alert("O bimestre deve ter no maximo 50 pontos")
    else{
        resul = n1+n2;
        if(resul>=60)
            alert(`Aluno aprovado!! Passou com ${resul} pontos.`);
        else
            alert(`Aluno Reprovado!! faltou ${60-resul} pontos.`);
    }
}