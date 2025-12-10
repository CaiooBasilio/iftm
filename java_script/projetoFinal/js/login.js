import {login, cadastrar} from "./storage.js";

window.addEventListener("DOMContentLoaded", function(){
    
    let user = document.getElementById("user");
    let senha = document.getElementById("pass");
    let key = "Users";
    let musica = new Audio("audio/videoplayback.weba");
    musica.loop = true;
    musica.play();

    document.getElementById("btn").addEventListener("click", function(){

        let usuarios = {usr:user.value, pwd: senha.value};
        
        if(login(key, usuarios)){
            cadastrar("Pessoa", usuarios.usr);
            window.location.href="index.html";
        }else
            mostraAlerta("Usuario não existente, por favor faça um cadastro para jogar!!")
    })
    

    window.mostraAlerta = function (message) {
        document.getElementById("msgAlerta").textContent = message;
        document.getElementById("alertaDoom").style.display = "flex";
    }

    window.fechaAlerta = function () {
        document.getElementById("alertaDoom").style.display = "none";
    }
})