nome = prompt("Qual o seu nome?", "Caio Basilio")
idade = parseInt(prompt("Qual sua idade?", "22"))

if (idade>=18)
    alert(`${nome}, você já POSSUI idade para tirar carteira.`)
else
    alert(`${nome}, você ainda NÂO POSSUI idade para tirar carteira, ainda falta(m) ${18 - idade} anos`)