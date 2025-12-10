import {cadastrar} from './storage.js';//usa essa {} pois não foi usado o defult la no storage.js


window.addEventListener("DOMContentLoaded", function(){

    let nomeCadastro = document.getElementById("nome");
    let senha = document.getElementById("senha");
    let key = "Users";
    let senhaCon = document.getElementById("senhaCon");
    let musica = new Audio("audio/musica2.weba");
    musica.loop = true;
    musica.play();

    document.getElementById("btn").addEventListener("click", function(){
        if(senha.value == senhaCon.value){
            if(nomeCadastro.value.trim() == "" || senha.value.trim() == ""){
                mostraAlerta("Algo deu errado!! Por favor revise suas informações");
            }else{
                let novoUsuario = {usr:nomeCadastro.value, pwd: senha.value};
                cadastrar(key, novoUsuario);
                mostraAlerta("Usuario cadastrado com sucesso");
            }
        }else{
            mostraAlerta("Algo deu errado!! Por favor revise suas informações");
        }
    })

    window.mostraAlerta = function (message) {
        document.getElementById("msgAlerta").textContent = message;
        document.getElementById("alertaDoom").style.display = "flex";
    }

    window.fechaAlerta = function () {
        document.getElementById("alertaDoom").style.display = "none";
    }
})