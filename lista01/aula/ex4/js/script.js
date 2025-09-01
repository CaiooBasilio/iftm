nota1 = parseFloat(prompt("Digite sua nota do 1° bimestre:"));//usamos o prompt para que o usuario digite oq lhe é pedido.
// o parseFloat serve para transformar o prompt, que tudo que vem dele é uma string, em real parseInt para inteiro.
nota2 = parseFloat(prompt("Digite sua nota do 2° bimestre:"));
notaTotal= nota1 + nota2;
resto = 60 - notaTotal;

if(notaTotal>= 60) 
    alert(`Parabens você passou!! Você tirou ${notaTotal.toFixed(1)} pontos`); //usa-se o ".toFixed(n) para definir o numeros de casa apos o ".", ele sempre retornara o numero em string, porem fica subentendido que ele é um number" 
else 
    alert(`Infelizmente você reprovou. Você tirou ${notaTotal.toFixed(1)} pontos, ficaram faltando ${resto.toFixed(1)} pontos `);