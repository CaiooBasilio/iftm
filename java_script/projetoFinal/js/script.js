window.addEventListener("DOMContentLoaded", function(){

    var niveis = [4,8,12]; //quantidade de cardas por nivel.
    var btnJogo = document.getElementById("jogar");
    var nivelSelec = document.getElementById("niveis");
    btnJogo.addEventListener("click", main);//enquanto não selecionar a dificuldae ele não vai rodar o jogo.
    let totalCarta;
    let parCertos;


    const CARTAS_TOTAL = 19;//const equivale a algo constante que não sera alterada
    function main(){
        let musica = new Audio("audio/HolyName x Heal The Hurt - Stained Glass (Official Audio).mp3");
        musica.loop = true;
        musica.play();

        btnJogo.disabled= true;
        var vetCartas = [];//var significa variavel, ou seja, ele pode ser alterado mais pra frente
        var cartasDoJogo=[];
        let nivel = nivelSelecionado();//chama o valor do nivel selecionado e armazena ele nessa variavel
        criaVetorCartas(vetCartas);
        cartasDoJogo = sorteiaCartas(vetCartas, nivel);
        cartasDoJogo= embaralharVetor(cartasDoJogo);//chama a função para o vetor ser embaralhado.
        mostrarCarta(cartasDoJogo);
        rodarCronometro(zeraCronometro(nivelSelec));
        totalCarta = cartasDoJogo.length/2;
        parCertos = 0;    
    }

    let minInterface = document.getElementById("min");
    let segInterface = document.getElementById("seg");

    let min;
    let seg;
    let idCronometro;

    function zeraCronometro(nivel) {
        if(nivel.value=="fac"){
            min = 10
            seg = 0
            segInterface.innerHTML = "0" + seg;
        }
        if(nivel.value == "med"){
            min = 5
            seg = 0
            minInterface.innerHTML = "0" + min;
            segInterface.innerHTML = "0" + seg;
        }
        if(nivel.value == "dif"){
            min = 3
            seg = 30
            minInterface.innerHTML = "0" + min;
        }
    }

    //gerando o cronometro de acordo com o nivel selecionado
    function rodarCronometro(nivel){
        idCronometro = setInterval(play, 1000)
    }
    
    function play(){
        seg--
        if(seg>=0 && seg<=9){
            segInterface.innerHTML = "0" + seg;
        }
        if(seg<0){
            min--
            seg = 59;
            minInterface.innerHTML = min
        }
        segInterface.innerHTML = seg
        if(min<=0 && seg<=0){
            clearInterval(idCronometro)
            mostraAlerta("ACABOU!! VOCE NÃO CONSEGUIU ACHAR TODAS")
            return;
        }
    }
    
    //gerando o nivel selecionado
    function nivelSelecionado(){
        let nivel;
        if(nivelSelec.selectedIndex==0){
            mostraAlerta("Selecione um nível de dificuldade para jogar!");
            reset();
        }
        else if(nivelSelec.selectedIndex==1)
            nivel = niveis[0];
        else if(nivelSelec.selectedIndex==2)
            nivel = niveis[1];
        else if(nivelSelec.selectedIndex==3)
            nivel = niveis[2];
        return nivel;
    }

    //gerando o vetor com as cartas 
    function criaVetorCartas(vetor){
        for(let i=0; i<CARTAS_TOTAL; i++){//o let indica que a variavel i so existe dentro do for/local
            vetor.push(i+1);//usando o push para adicionar um valor dentro do vetor.
        }
    }

    //linpando o tabuleiro
    function limpaTabuleiro(){
        document.getElementById("tabuleiro").innerHTML="";
    }

    //função para sortear as cartas
    function sorteiaCartas(vetor, nivel){
        limpaTabuleiro();
        let pares = [];//vetor que ira receber os pares sorteados
        for(let i=0; i<nivel; i++){
            
            var par = vetor[Math.floor(Math.random()*vetor.length)];//adiciona um valor aleatorio no vetor
            pares.push(par, par);//adiciona o mesmo valor no vetor para que assim haja os pares no mesmo vetor
            vetor.splice(vetor.indexOf(par), 1);//pega o indice do valor que foi sorteado e retira do vetor principal
        }
        return pares;
    }

    //embaralha o vetor
    function embaralharVetor(vet){
        for(let i=vet.length-1; i>0; i--){//vai passar de tras pra fente no vetor de pares
            j = Math.floor(Math.random()*(i+1));//sortear qualquer indice do vetor
            [vet[i], vet[j]]=[vet[j],vet[i]];//aqui ele faz a troca sem precisar de uma outra variavel tipo aquele temp que usa no java.
        }
        return vet;
    }

    //mostrando as cartas na tela
    function mostrarCarta(pares){
        for(let i = 0; i<pares.length; i++){
            let img = new Image();// 
            img.src = "img/verso.webp";// deixando a carta virada para baixo
            //img.alt = `img/carta${pares[i]}.webp` // serve para deixar salvo qual carta é essa
            img.dataset.valor = pares[i];

            img.addEventListener("click", () => /*Isso daí serve para "atrasar", pq sem isso ele ja revela as cartas direto*/revelarCarta(img))

            document.getElementById("tabuleiro").appendChild(img);//adiciono a imagem ao html naquele id.
        }
    }

    let controle = false; // usando para o controle na hora de verificar 
    let cartaPri;// criando para comparar as duas cartas 
    let cartaSeg;

    //usando para as cartas serem viradas para cima
    function revelarCarta(imagem){

        if (controle == true)
            return;//uso para que o usuario não pode virar outras cartas ao ineves das 2 normais
        if(imagem.src.includes("carta"))
            return; //aqui verifico se a carta ja esta virada, pois ela virada vai ter a palavra carta nela

        imagem.src = `img/carta${imagem.dataset.valor}.webp`;

        if(cartaPri == null)
            cartaPri = imagem;//aqui eu coloco a carta no primeiro item antes de comparar
        else{//cas a cartaPri ja tenha algum eu coloco ela na segunda
            cartaSeg = imagem;
            controle = true;
            setTimeout(() => verificaPares(cartaPri, cartaSeg), 999);
        }

    }

    //verificando se são pares 
    function verificaPares(carta01, carta02){
        if(carta01.src === carta02.src){//pergunto se são iguais em tudo
            parCertos+=1;
            cartaPri = null;//se forem eu "zero" tudo
            cartaSeg = null;
            controle = false;

            if(parCertos == totalCarta){
                venceu();
            }
        }else {//se não forem....
            cartaPri.src= "img/verso.webp";//viro as cartas e mudop o controle para o usuario poder virar as cartas novamente
            cartaPri = null;
            cartaSeg.src = "img/verso.webp";
            cartaSeg = null;
            controle = false;
        }
    }

    function venceu(){
        clearInterval(idCronometro);
        mostraAlerta("Parabens!! Vc ganhou 🔥🔥");
        reset();
    }

    //fazendo para resetar o jogo
    function reset(){

        clearInterval(idCronometro);
        parCertos = 0;
        cartaPri = null;
        cartaSeg = null;
        controle = false;

        document.getElementById("tabuleiro").innerHTML = "";

        minInterface.innerHTML = "00";
        segInterface.innerHTML = "00";
        btnJogo.disabled = false;
    }
    
    window.mostraAlerta = function (message) {
        document.getElementById("msgAlerta").textContent = message;
        document.getElementById("alertaDoom").style.display = "flex";
    }

    window.fechaAlerta = function () {
        document.getElementById("alertaDoom").style.display = "none";
    }
});

