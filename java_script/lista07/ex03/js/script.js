document.addEventListener("DOMContentLoaded", function(){

    let val = parseInt(prompt("Qual o valor de X?", "2"))
    let seg = document.getElementById("seg");
    seg.innerHTML = val;
        
    let interv = setInterval(segundos, 1000)
    function segundos(){
        val--
        if(val==0)
            setTimeout(google, 0);
        seg.innerHTML = val;
    }
    
    function google(){
        clearInterval(interv)
        window.location.href="https://www.google.com/"
    }
})