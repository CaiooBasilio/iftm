package com.example.a2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.example.a2.Calculadora;

public class TestCalculadora {
    private Calculadora calculadoraIniciada;

    @BeforeEach
    public void setup(){
        int valorInicialDaMemoria = 5;
        calculadoraIniciada = new Calculadora(valorInicialDaMemoria);
    }

    // 01- Construtor Vazio:
    @Test
    public void testarSeOConstrutorPossuiAMemoriaVazia(){
        Calculadora calculadora = new Calculadora();
        int memoriaQueSeEspera = 0;
        int memoriaPresenteNaCalculadora = calculadora.getMemoria();
        Assertions.assertEquals(memoriaQueSeEspera, memoriaPresenteNaCalculadora);
    }

    @Test
    public void testarIniciadorComNumeroPositivo(){
        int valorPositivoParaOConstrutor = 5;
        Calculadora calculadora = new Calculadora(valorPositivoParaOConstrutor);
        int memoriaPresenteNaCalculadora = calculadora.getMemoria();
        Assertions.assertEquals(valorPositivoParaOConstrutor, memoriaPresenteNaCalculadora);
    }

    @Test
    public void testarIniciadorComNumeroNegativo(){
        int valorNegativoParaOConstrutor = -3;
        Calculadora calculadora = new Calculadora(valorNegativoParaOConstrutor);
        int memoriaPresenteNaCalculadora = calculadora.getMemoria();
        Assertions.assertEquals(valorNegativoParaOConstrutor, memoriaPresenteNaCalculadora);
    }

    @Test
    public void testarSomaComNumeroPositivo(){
        int valorASerSomado = 3;
        int memoriaEsperadaPosSoma = 8;
        calculadoraIniciada.somar(valorASerSomado);
        int memoriaPresenteNaCalculadora = calculadoraIniciada.getMemoria();
        Assertions.assertEquals(memoriaEsperadaPosSoma, memoriaPresenteNaCalculadora);
    }

    @Test
    public void testarSomaComNumeroNegativo(){
        int valorASerSomado = -3;
        int memoriaEsperadaPosSoma = 2;
        calculadoraIniciada.somar(valorASerSomado);
        int memoriaPresenteNaCalculadora = calculadoraIniciada.getMemoria();
        Assertions.assertEquals(memoriaEsperadaPosSoma, memoriaPresenteNaCalculadora);
    }

    @Test
    public void testarSubtracaoComNumeroPositivo(){
        int valorASerSubtraido = 3;
        int memoriaEsperadaPosSubtracao = 2;
        calculadoraIniciada.subtrair(valorASerSubtraido);
        int memoriaPresenteNaCalculadora = calculadoraIniciada.getMemoria();
        Assertions.assertEquals(memoriaEsperadaPosSubtracao, memoriaPresenteNaCalculadora);
    }

    @Test
    public void testarSubtracaoComNumeroNegativo(){
        int valorASerSubtraido = -3;
        int memoriaEsperadaPosSubtracao = 8;
        calculadoraIniciada.subtrair(valorASerSubtraido);
        int memoriaPresenteNaCalculadora = calculadoraIniciada.getMemoria();
        Assertions.assertEquals(memoriaEsperadaPosSubtracao, memoriaPresenteNaCalculadora);
    }

    @Test
    public void testarMultiplicacaoComNumeroPositivo(){
        int valorASerMultiplicado = 3;
        int memoriaEsperadaPosMultiplicacao = 15;
        calculadoraIniciada.multiplicar(valorASerMultiplicado);
        int memoriaPresenteNaCalculadora = calculadoraIniciada.getMemoria();
        Assertions.assertEquals(memoriaEsperadaPosMultiplicacao, memoriaPresenteNaCalculadora);
    }

    @Test
    public void testarMultiplicacaoComNumeroNegativo(){
        int valorASerMultiplicado = -3;
        int memoriaEsperadaPosMultiplicacao = -15;
        calculadoraIniciada.multiplicar(valorASerMultiplicado);
        int memoriaPresenteNaCalculadora = calculadoraIniciada.getMemoria();
        Assertions.assertEquals(memoriaEsperadaPosMultiplicacao, memoriaPresenteNaCalculadora);
    }

    @Test
    public void testarDivisaoComNumeroPositivo() throws Exception {
        int valorASerDividido = 5;
        int memoriaEsperadaPosDivisao = 1;
        calculadoraIniciada.dividir(valorASerDividido);
        int memoriaPresenteNaCalculadora = calculadoraIniciada.getMemoria();
        Assertions.assertEquals(memoriaEsperadaPosDivisao, memoriaPresenteNaCalculadora);
    }

    @Test
    public void testarDivisaoComNumeroNegativo() throws Exception {
        int valorASerDividido = -5;
        int memoriaEsperadaPosDivisao = -1;
        calculadoraIniciada.dividir(valorASerDividido);
        int memoriaPresenteNaCalculadora = calculadoraIniciada.getMemoria();
        Assertions.assertEquals(memoriaEsperadaPosDivisao, memoriaPresenteNaCalculadora);
    }

    @Test
    public void testarDivisaoPorZero() throws Exception {
        int valorASerDividido = 0;
        int memoriaEsperadaPosDivisao = -1;
        calculadoraIniciada.dividir(valorASerDividido);
        int memoriaPresenteNaCalculadora = calculadoraIniciada.getMemoria();
        Assertions.assertEquals(memoriaEsperadaPosDivisao, memoriaPresenteNaCalculadora);
    }

    @Test
    public void testarExponenciacaoElevadoA1() throws Exception {
        int valorDoExpoente = 1;
        int memoriaEsperadaPosExponenciacao = 5;
        calculadoraIniciada.exponenciar(valorDoExpoente);
        int memoriaPresenteNaCalculadora = calculadoraIniciada.getMemoria();
        Assertions.assertEquals(memoriaEsperadaPosExponenciacao, memoriaPresenteNaCalculadora);
    }

    @Test
    public void testarExponenciacaoElevadoA10() throws Exception {
        int valorDoExpoente = 10;
        int memoriaEsperadaPosExponenciacao = 9765625;
        calculadoraIniciada.exponenciar(valorDoExpoente);
        int memoriaPresenteNaCalculadora = calculadoraIniciada.getMemoria();
        Assertions.assertEquals(memoriaEsperadaPosExponenciacao, memoriaPresenteNaCalculadora);
    }

    @Test
    public void testarExponenciacaoElevadoA20() throws Exception {
        int valorDoExpoente = 20;
        int memoriaEsperadaPosExponenciacao = 953674316;
        calculadoraIniciada.exponenciar(valorDoExpoente);
        int memoriaPresenteNaCalculadora = calculadoraIniciada.getMemoria();
        Assertions.assertEquals(memoriaEsperadaPosExponenciacao, memoriaPresenteNaCalculadora);
    }

    @Test
    public void testeParaZerarAMemoriaDaCalculadora(){
        int memoriaQueSeEspera = 0;
        calculadoraIniciada.zerarMemoria();
        int memoriaPresenteNaCalculadora = calculadoraIniciada.getMemoria();
        Assertions.assertEquals(memoriaQueSeEspera, memoriaPresenteNaCalculadora);
    }
}

