export function cadastro(key, value){//exportar essa função la pro script
    let chave = localStorage.getItem(key);

    if(chave==null){//verificando se possui mais usuarios
        let text= value//criando um novo vetor para armazenar o texto que for digitado pelo usuario

        localStorage.setItem(key, text); //usando o JSON para colocar o tal texto e dentro do local storage
    }
}