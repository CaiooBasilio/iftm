export function cadastrar(key, value) {//export para exporta-la

    let user = localStorage.getItem(key);//pegando a key 

    if(user==null){//irá verificar se ja possui usuarios castrado
        let vetorUser = [value];//pega e cria um novo vet para colocar os usuarios
        localStorage.setItem(key, JSON.stringify(vetorUser));//o JSON.stringify() tranforma a variavel desejada em uma string
    }else{//existe ao meno 1 castrado
        user = JSON.parse(user);//volta o vetor para o padrão normal
        user.push(value);
        localStorage.setItem(key, JSON.stringify(user));//o JSON.stringify() tranforma a variavel desejada em uma string
    }
}

export function login(key, value) {
    //let verifica = localStorage.getItem(key); retornando o valor como uma string

    let user = localStorage.getItem(key);//pegando a key 

    if(user==null){//irá verificar se ja possui usuarios castrado
        //alert("Usuario inexistente");
    }else{//existe ao meno 1 castrado
        let verifica = JSON.parse(user);//retorna a string como objeto
        for(let i=0; i<verifica.length; i++){
            if(verifica[i].usr===value.usr && verifica[i].pwd===value.pwd)
                return true;
        }
        return false;

    }
}


