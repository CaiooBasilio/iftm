import { cadastro } from "./storage.js";//importando o storage

document.addEventListener("DOMContentLoaded", function (){

    const btnEnvia = document.getElementById("btnEnvia");
    
    btnEnvia.addEventListener("click", function(){
    
        let textUser = document.getElementById("inputText");
        cadastro("textoUsuario", textUser.value);
        window.location.href="analisarTxt.html";
    });
});