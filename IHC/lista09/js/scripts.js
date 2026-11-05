const DURACAO_BUSCA = 2500;
let temporizador = null;
let autorJaSimulado = false;

const CATALOGO = [
    { titulo: "Dom Casmurro",                    autor: "Machado de Assis",  isbn: "978-85-0000-001-1", ano: 1899 },
    { titulo: "Memórias Póstumas de Brás Cubas", autor: "Machado de Assis",  isbn: "978-85-0000-002-8", ano: 1881 },
    { titulo: "Capitães da Areia",               autor: "Jorge Amado",       isbn: "978-85-0000-003-5", ano: 1937 },
    { titulo: "Vidas Secas",                     autor: "Graciliano Ramos",  isbn: "978-85-0000-004-2", ano: 1938 },
    { titulo: "A Hora da Estrela",               autor: "Clarice Lispector", isbn: "978-85-0000-005-9", ano: 1977 },
];

const campos = [
    { chave: "autor",  nome: "autor",  artigo: "o", input: document.getElementById("input-autor"),
      erro: document.getElementById("erro-autor") },
    { chave: "titulo", nome: "título", artigo: "o", input: document.getElementById("input-titulo"),
      erro: document.getElementById("erro-titulo") },
    { chave: "isbn",   nome: "ISBN",   artigo: "o", input: document.getElementById("input-isbn"),
      erro: document.getElementById("erro-isbn") },
];

const form = document.getElementById("form-busca");
const popupErro = document.getElementById("popup-erro");
const popupAjuda = document.getElementById("popup-ajuda");
const popupLimpar = document.getElementById("popup-limpar");
const btnLimpar = document.getElementById("btn-limpar");
const dicaUso = document.getElementById("dica-uso");

function mostrarTela(id) {
    document.querySelectorAll(".tela").forEach(t => { t.hidden = (t.id !== id); });
    const titulo = document.querySelector("#" + id + " h1, #" + id + " h2");
    if (titulo) { titulo.tabIndex = -1; titulo.focus(); }
}

function mostrarErroCampo(campo, texto) {
    campo.erro.textContent = texto;
    campo.erro.hidden = false;
    campo.input.classList.add("invalido");
    campo.input.setAttribute("aria-invalid", "true");
}

function limparErroCampo(campo) {
    campo.erro.textContent = "";
    campo.erro.hidden = true;
    campo.input.classList.remove("invalido");
    campo.input.removeAttribute("aria-invalid");
}

function limparTodosErros() {
    campos.forEach(limparErroCampo);
}

campos.forEach(campo => {
    campo.input.addEventListener("input", limparTodosErros);
});

form.addEventListener("reset", () => {
    setTimeout(() => {
        limparTodosErros();
        dicaUso.classList.add("destaque");
    }, 0);
});

form.addEventListener("submit", (evento) => {
    evento.preventDefault();
    verificar();
});

function lerFiltros() {
    const filtros = {};
    campos.forEach(c => {
        const valor = c.input.value.trim();
        if (valor !== "") filtros[c.chave] = valor;
    });
    return filtros;
}

function verificar() {
    limparTodosErros();
    const filtros = lerFiltros();

    if (Object.keys(filtros).length === 0) {
        campos.forEach(c => mostrarErroCampo(c, `Informe ${c.artigo} ${c.nome} ou preencha outro campo.`));
        popupErro.showModal();
        return;
    }

    const resumo = campos
        .filter(c => filtros[c.chave])
        .map(c => `${c.nome.charAt(0).toUpperCase() + c.nome.slice(1)}: ${filtros[c.chave]}`)
        .join(" | ");
    document.getElementById("resumo-busca").textContent = "Procurando por " + resumo;
    mostrarTela("tela-buscando");

    const barra = document.querySelector(".barra-preenchimento");
    barra.style.animation = "none";
    void barra.offsetWidth;
    barra.style.animation = "";

    temporizador = setTimeout(() => {
        const livros = buscarLivros(filtros);
        if (livros.length > 0) {
            exibirResultados(livros);
            mostrarTela("tela-encontrado");
        } else {
            mostrarTela("tela-nao-encontrado");
        }
    }, DURACAO_BUSCA);
}

popupErro.addEventListener("close", () => {
    campos[0].input.focus();
});

function normalizar(texto) {
    return texto
        .toLowerCase()
        .normalize("NFD").replace(/[\u0300-\u036f]/g, "")
        .replace(/\s+/g, " ")
        .trim();
}

function somenteDigitos(texto) {
    return texto.toLowerCase().replace(/[^0-9x]/g, "");
}

function buscarLivros(filtros) {
    return CATALOGO.filter(livro => {
        if (filtros.autor && !normalizar(livro.autor).includes(normalizar(filtros.autor))) return false;
        if (filtros.titulo && !normalizar(livro.titulo).includes(normalizar(filtros.titulo))) return false;
        if (filtros.isbn) {
            const digitos = somenteDigitos(filtros.isbn);
            if (digitos === "" || !somenteDigitos(livro.isbn).includes(digitos)) return false;
        }
        return true;
    });
}

function exibirResultados(livros) {
    document.getElementById("titulo-resultado").textContent =
        livros.length === 1 ? "Livro encontrado" : livros.length + " livros encontrados";

    const lista = document.getElementById("lista-resultados");
    lista.textContent = "";

    livros.forEach(livro => {
        const item = document.createElement("article");
        item.className = "livro";

        const nome = document.createElement("h3");
        nome.textContent = livro.titulo;
        item.appendChild(nome);

        const dados = document.createElement("dl");
        [["Autor", livro.autor], ["ISBN", livro.isbn], ["Publicação", livro.ano]].forEach(([rotulo, valor]) => {
            const dt = document.createElement("dt");
            dt.textContent = rotulo;
            const dd = document.createElement("dd");
            dd.textContent = valor;
            dados.append(dt, dd);
        });
        item.appendChild(dados);

        lista.appendChild(item);
    });
}

document.getElementById("btn-cancelar").addEventListener("click", () => {
    clearTimeout(temporizador);
    mostrarTela("tela-cancelada");
});

document.getElementById("btn-ajuda").addEventListener("click", () => {
    popupAjuda.showModal();
});

campos.forEach(campo => {
    campo.input.addEventListener("input", () => dicaUso.classList.remove("destaque"));
});

btnLimpar.addEventListener("click", () => {
    const temConteudo = campos.some(c => c.input.value.trim() !== "");

    if (!temConteudo) {
        form.reset();
        return;
    }
    popupLimpar.returnValue = "";
    popupLimpar.showModal();
});

popupLimpar.addEventListener("close", () => {
    if (popupLimpar.returnValue === "confirmar") {
        form.reset();
        campos[0].input.focus();
    } else {
        btnLimpar.focus();
    }
});

document.querySelectorAll("[data-ir]").forEach(botao => {
    botao.addEventListener("click", () => {
        if (botao.dataset.ir === "nova") {
            form.reset();
        }
        mostrarTela("tela-formulario");
        campos[0].input.focus();
    });
});