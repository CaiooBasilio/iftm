package br.iftm.atividade.testes.atividade2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class FuncionariosTest {
    

    //teste de calcular pagamento
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

    @Test
    public void validaOSalarioDoFuncionarioErradoAbaixo(){
        String nome = "Caio";
        int horasTrabalhadas = 6;
        double valorHora = 15.28;

        Funcionario f = new Funcionario(nome);
        f.setHorasTrabalhadas = horasTrabalhadas;
        f.setValorHora = valorHora;
        String mensagemEsperada = "O valor do salario esta à baixo do salario minimo de R$1518,00";
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> {
            f.calcularPagamento();
        });
        String mensagemRecebida = erro.getMessage();

        assertEquals(mensagemEsperada, mensagemRecebida);
    }

    @Test
    public void validaOSalarioDoFuncionarioErradoAcima(){
        String nome = "Caio";
        int horasTrabalhadas = 39;
        double valorHora = 1000;

        Funcionario f = new Funcionario(nome);
        f.setHorasTrabalhadas = horasTrabalhadas;
        f.setValorHora = valorHora;
        String mensagemEsperada = "O valor do salario esta à cima do salario maximo de R$10.000,00";
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> {
            f.calcularPagamento();
        });
        String mensagemRecebida = erro.getMessage();

        assertEquals(mensagemEsperada, mensagemRecebida);
    }


    // teste de horas trabalhadas
    @Test
    public void testarModificarHorasAbaixoLimiteInferiorGeraErro(){
        String nome = "Caio";
        int horasTrabalhadas = 3;
        double valorHora = 100;

        Funcionario f = new Funcionario(nome);
        f.setHorasTrabalhadas(horasTrabalhadas);
        String menssagemEsperada = "O número de horas trabalhadas esperadas é de no minimo 5 horas e no maximo 40 horas";
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> {
            f.setHorasTrabalhadas(horasTrabalhadas);
        });
        String mensagemRecebida = erro.getMessage();

        assertEquals(mensagemRecebida, menssagemEsperada);
    }

    @Test
    public void testarModificarHorasAcimaLimiteSuperiorGeraErro(){
        String nome = "Caio";
        int horasTrabalhadas = 67;
        double valorHora = 100.00;

        Funcionario f = new Funcionario(nome);
        f.setValorHora(valorHora);
        String menssagemEsperada = "O número de horas trabalhadas esperadas é de no minimo 5 horas e no maximo 40 horas";
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> {
            f.setValorHora(valorHora);
        });
        String mensagemRecebida = erro.getMessage();

        assertEquals(mensagemRecebida, menssagemEsperada);
    }

    @Test
    public void testarModificarHorasValorValidoGeraPagamentoCorreto(){
        String nome = "Caio";
        int horasTrabalhadas = 10;
        double valorHora = 100;

        Funcionario f = new Funcionario(nome);
        f.setHorasTrabalhadas = horasTrabalhadas;
        f.setValorHora = valorHora;
        double valorEsperadoParaOResultado = 4000;

        assertEquals(valorEsperadoParaOResultado, f.calcularPagamento);
    }

    
    // teste de valor das horas
    @Test
    public void testarModificarValorPorHoraAcimaLimiteSuperiorGeraErro(){
        String nome = "Caio";
        int horasTrabalhadas = 5;
        double valorHora = 1500.00;

        Funcionario f = new Funcionario(nome);
        f.setValorHora(valorHora);
        String menssagemEsperada = "O valor recebido por hora não pode ser abaixo de R$15,28 e acima de R$1000,00";
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> {
            f.setValorHora(valorHora);
        });
        String mensagemRecebida = erro.getMessage();

        assertEquals(mensagemRecebida, menssagemEsperada);
    }

    @Test
    public void testarModificarValorPorHoraAbaixoLimiteSuperiorGeraErro(){
        String nome = "Caio";
        int horasTrabalhadas = 5;
        double valorHora = 14.00;

        Funcionario f = new Funcionario(nome);
        f.setHorasTrabalhadas(horasTrabalhadas);
        String menssagemEsperada = "O valor recebido por hora não pode ser abaixo de R$15,28 e acima de R$1000,00";
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> {
            f.setHorasTrabalhadas(horasTrabalhadas);
        });
        String mensagemRecebida = erro.getMessage();

        assertEquals(mensagemRecebida, menssagemEsperada);
    }

    @Test
    public void testarModificarValorPorHoraComValoresValidosProduzPagamentoEsperado(){
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
