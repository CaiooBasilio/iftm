document.addEventListener("DOMContentLoaded", function(){

    const btn = document.getElementById("btnTransport");

    btn.addEventListener("click", tempo)

    function tempo(){
        setTimeout(transporte, 2000)
    }
    function transporte(){
        var txt1 = document.getElementById("txt1");
        var txt2 = document.getElementById("txt2");
        txt2.value = txt1.value;
        txt1.value ="";
    }
})