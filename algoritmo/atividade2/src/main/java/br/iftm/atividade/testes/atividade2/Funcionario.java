package br.iftm.atividade.testes.atividade2;

public class Funcionario {
    private String nome;
    private int horasTrabalhas;
    private double valorHoras;

    public Funcionario(String nome){
        this.nome = nome;
    }

    public void setHorasTrabalhadas(int horasTrabalhas) {
        if (horasTrabalhas>40 || horasTrabalhas<5) {
            throw new IllegalArgumentException("O número de horas trabalhadas esperadas é de no minimo 5 horas e no maximo 40 horas");
        }
        this.horasTrabalhas = horasTrabalhas;
    }

    public void setValorHoras(double valorHoras) {
        if (valorHoras< 15.18 || valorHoras>1000.00) {
            throw new IllegalArgumentException("O valor recebido por hora não pode ser abaixo de R$15,28 e acima de R$1000,00");
        }
        this.valorHoras = valorHoras;
    }

    public double calcularPagamento(){
        double resp = (horasTrabalhas * 4)*valorHoras;
        if (resp > 10000.00) {
            throw new IllegalArgumentException("O valor do salario esta à cima do salario maximo de R$10.000,00");
        }else if(resp <1518.00){
            throw new IllegalArgumentException("O valor do salario esta à baixo do salario minimo de R$1518,00");
        }
        return resp;
    }
}
