window.addEventListener("DOMContentLoaded", function(){

    let dtNascimento = document.getElementById("dataNascimento");
    document.getElementById("btnBrabo").addEventListener("click", function(){
        let padraoNascimento = /^[0-3]\d[/][0-1]\d[/](\d{2}|\d{4})$/;
        (padraoNascimento.test(dtNascimento.value))?alert("Valido"):alert("Invalido");
    });
    
    let cpf = document.getElementById("cpf");
    document.getElementById("btnCpf").addEventListener("click", function(){
        let cpfPadrao = /^\d{3}[.]\d{3}[.]\d{3}[-]\d{2}$/;
        (cpfPadrao.test(cpf.value))?alert("CPF valido"):alert("CPF invalido");
    });

    let numMatricula = document.getElementById("matricula");
    document.getElementById("btnMatricula").addEventListener("click", function(){
        let matriculaPadrao = /^(IFTM|iftm)[-]\d{3}[/]\d{3}[-]\w{2}$/;
        (matriculaPadrao.test(numMatricula.value))?alert("Matricula valida"):alert("Matricula invalido");
    });
    
    let codDiciplina = document.getElementById("diciplina");
    document.getElementById("btnDiciplina").addEventListener("click", function(){
        let diciplinaPadrao = /^MT[-]\d{2}[.]\d{3}[-]IFTM$/i;
        (diciplinaPadrao.test(codDiciplina.value))?alert("Diciplina valida"):alert("Diciplina invalido");
    });
    
    let diciplina2 = document.getElementById("diciplina2");
    document.getElementById("btnDiciplina2").addEventListener("click", function(){
        let diciplinaPadrao = /^MT[-]\d{2}[.]\d{3}[-](I|i)(F|f)(T|t)(M|m)$/;
        (diciplinaPadrao.test(diciplina2.value))?alert("Diciplina valida"):alert("Diciplina invalido");
    });

    let diciplina3 = document.getElementById("diciplina3");
    document.getElementById("btnDiciplina3").addEventListener("click", function(){
        let diciplinaPadrao = /^M[ ]?T[-]\d{2}[.]\d{3}[-]I[ ]?F[ ]?T[ ]?M$/i;
        (diciplinaPadrao.test(diciplina3.value))?alert("Diciplina valida"):alert("Diciplina invalido");
    });
    
    let diciplina4 = document.getElementById("diciplina4");
    document.getElementById("btnDiciplina4").addEventListener("click", function(){
        let diciplinaPadrao = /^(M|m)\s?(T|t)[-]\d{2}[.]\d{3}[-](I|i)\s?(F|f)\s?(T|t)\s?(M|m) (Uberlândia Centro|Uberlândia)$/;
        (diciplinaPadrao.test(diciplina4.value))?alert("Diciplina valida"):alert("Diciplina invalido");
    });

    let campus = document.getElementById("campus");
    document.getElementById("btnCampus").addEventListener("click", function(){
        let campusPadrao = /^IFTM campus Uberlândia(| Centro)$/;
        (campusPadrao.test(campus.value))?alert("Campus valido"):alert("Campus invalido");
    });

    let telefone = document.getElementById("telefone");
    document.getElementById("btnTelefone").addEventListener("click", function(){
        let telefonePadrao = /^[+]\d{2}[(]\d{2}[)]\d{5}[-]\d{4}$/;
        (telefonePadrao.test(telefone.value))?alert("telefone valido"):alert("telefone invalido");
    });

    let telefone2 = document.getElementById("telefone2");
    document.getElementById("btnTelefone2").addEventListener("click", function(){
        let telefone2Padrao = /^[(]\d{2,3}[)]\d{5}[-]\d{4}$/;
        (telefone2Padrao.test(telefone2.value))?alert("telefone valido"):alert("telefone invalido");
    });

    let altura = document.getElementById("altura");
    document.getElementById("btnAltura").addEventListener("click", function(){
        let alturaPadrao = /^(1(,|.)[3-9]\d?|2(,|.)[0-5]\d?)$/;
        (alturaPadrao.test(altura.value))?alert("Altura valida"):alert("Altura invalida");
    });
    
    let faturamento = document.getElementById('faturamento');
    document.getElementById('btnFaturamento').addEventListener('click', function(){
        let padraoFaturamento = /^R\$\d{1,3}(\.\d{3}){0,4},\d{2}$/;
        (padraoFaturamento.test(faturamento.value))?alert('Faturamento valido'):alert('Faturamento invalido')
    })

    let cronometro = document.getElementById('cronometro');
    document.getElementById('btnCronometro').addEventListener('click', function(){
        let padraoCronometro = /^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9]):\d{2}$/;
        (padraoCronometro.test(cronometro.value))?alert('Cronometro valido'):alert('Cronometro invalido');
    })
    
    let senha  = document.getElementById('senha');
    document.getElementById('btnSenha').addEventListener('click', function(){
        let padraoSenha = /^\w{1,5}\.&[A-Za-z]+\.[aeiou]+\.[A-Za-z]+[0-5]?-\D+,\W{2}\.[^ab01]+$/;
        (padraoSenha.test(senha.value))?alert('Senha valida'):alert('Senha invalida');
    })
});