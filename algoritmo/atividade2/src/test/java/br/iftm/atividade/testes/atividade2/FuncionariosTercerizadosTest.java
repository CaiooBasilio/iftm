package br.iftm.atividade.testes.atividade2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class FuncionariosTercerizadosTest {
    
    @Test
    public void testarModificarDespesaAcimadoLimiteGeraErro(){
        String nome = "Caio";
        int horasTrabalhadas = 6;
        double valorHora = 15.28;
        double despesasAdicionais = 1500.00;

        FuncionariosTercerizados ft = new FuncionariosTercerizados(nome);
        ft.setHorasTrabalhadas(horasTrabalhadas);
        ft.setValorHoras(valorHora);
        
        String mensagemEsperada = "O valor das despesas tem que ser abaxio de R$1000,00";
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> {
            ft.setDespesasAdicionais(despesasAdicionais);
        });
        String mensagemRecebida = erro.getMessage();

        assertEquals(mensagemEsperada, mensagemRecebida);
    }

    @Test
    public void testarModificarDespesageraPagamentoacimaLimiteSalarioGerandoErro(){
        String nome = "Caio";
        int horasTrabalhadas = 20;
        double valorHora = 120;
        double despesasAdicionais = 1000.00;

        FuncionariosTercerizados ft = new FuncionariosTercerizados(nome);
        ft.setHorasTrabalhadas(horasTrabalhadas);
        ft.setValorHoras(valorHora);
        ft.setDespesasAdicionais(despesasAdicionais);

        String mensagemEsperada = "O valor do salario esta à cima do salario maximo de R$10.000,00";
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> {
            ft.calcularPagamento();
        });
        String mensagemRecebida = erro.getMessage();

        assertEquals(mensagemEsperada, mensagemRecebida);
    }

    @Test
    public void testarModificarDespesaGeraPagementoValido(){
        String nome = "Caio";
        int horasTrabalhadas = 20;
        double valorHora = 110;
        double despesasAdicionais = 1000.00;

        FuncionariosTercerizados ft = new FuncionariosTercerizados(nome);
        ft.setHorasTrabalhadas(horasTrabalhadas);
        ft.setValorHoras(valorHora);
        ft.setDespesasAdicionais(despesasAdicionais);
        double resultadoEsperado = 9800.00;

        assertEquals(resultadoEsperado, ft.calcularPagamento());

    }
}