document.addEventListener("DOMContentLoaded", function(){

    const btn = document.getElementById("btnTransport");
    var txt1 = document.getElementById("txt1");

    btn.addEventListener("click", aconteca)

    function aconteca(){
        var num = document.getElementById("temp").value + "000";
        var tempo = parseInt(num);
        setTimeout(transporte, tempo)
    }
    function transporte(){
        var txt2 = document.getElementById("txt2");
        txt2.value = txt1.value;
        txt1.value = "";
    }
})