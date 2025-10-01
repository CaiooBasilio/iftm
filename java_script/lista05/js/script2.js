cand1 = document.getElementById("conta");
cand2 = document.getElementById("conta2");
cand3 = document.getElementById("conta3");
cand4 = document.getElementById("conta4");

conta1 =0;
conta2 =0;
conta3 =0;
conta4 =0;

cand1.addEventListener("click", ad1);
function ad1(){
    document.getElementById("votos").innerHTML = ++conta1;
}

cand2.addEventListener("click", ad2);
function ad2(){
    document.getElementById("votos2").innerHTML = ++conta2;
}

cand3.addEventListener("click", ad3);
function ad3(){
    document.getElementById("votos3").innerHTML = ++conta3;
}

cand4.addEventListener("click", ad4);
function ad4(){
    document.getElementById("votos4").innerHTML = ++conta4;
}