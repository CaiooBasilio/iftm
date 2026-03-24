package br.iftm.atividade.testes.atividade2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FuncionariosTest {
    
    @Test
    public void validaOSalarioDoFuncionarioCorreto(){
        String nome = "Caio";
        int horasTrabalhadas = 10;
        double valorHora = 100;

        Funcionario f = new Funcionario(nome);
        f.setHorasTrabalhadas = horasTrabalhadas;
        f.setValorHora = valorHora;
        double valorEsperadoParaOResultado = 4000;

        assertEquals(valorEsperadoParaOResultado, f.calcularPagamento);
    }
}
