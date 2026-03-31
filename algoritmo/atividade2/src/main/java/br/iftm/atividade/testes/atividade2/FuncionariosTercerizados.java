package br.iftm.atividade.testes.atividade2;

public class FuncionariosTercerizados extends Funcionario {

    private double despesasAdicionais;

    public FuncionariosTercerizados(String nome) {
        super(nome);
    }

    public void setDespesasAdicionais(double despesasAdicionais) {
        if (despesasAdicionais>1000.00 || despesasAdicionais<0.0) {
            throw new IllegalArgumentException("O valor das despesas tem que ser abaxio de R$1000,00");
        }
        this.despesasAdicionais = despesasAdicionais;
    }

    @Override
    public double calcularPagamento() {
        double resp = super.calcularPagamento()+despesasAdicionais;
        if (resp > 10000.00) {
            throw new IllegalArgumentException("O valor do salario esta à cima do salario maximo de R$10.000,00");
        }else if(resp <1518.00){
            throw new IllegalArgumentException("O valor do salario esta à baixo do salario minimo de R$1518,00");
        }
        return resp;
    }
}
