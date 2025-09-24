btnEnvia = document.getElementById("envia");
btnLimpa = document.getElementById("limpa")
login = document.getElementById("login");
senha = document.getElementById("senha");
confirmaSenha = document.getElementById("confirmaSenha");

btnEnvia.addEventListener("click", verifica);
btnLimpa.addEventListener("click", limpa)
function verifica(){
    if(login.value==""){
        window.alert(`O campo "Login" esta vazio! Por favor preencha-o.`)
        senha.value="";
        confirmaSenha.value="";
    }
    else{
        if(senha.value!=confirmaSenha.value){
            senha.value="";
            confirmaSenha.value="";
            alert("Por favor digite a mesma senha em ambos os campos.");
        }else{
            alert("Todos os campos foram digitados corretamente!");
            senha.value="";
            confirmaSenha.value="";
            login.value="";
        }
    }
}
function limpa(){
    senha.value="";
    confirmaSenha.value="";
    login.value="";
}