package org.iftm.gerenciadorveterinarios.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.iftm.gerenciadorveterinarios.entities.Veterinario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest // faz o teste sem precisar subir o servidor inteiro, faz apenas naquela classe
@TestMethodOrder(OrderAnnotation.class)
public class VeterinarioRepositoryTest {

    @Autowired
    private VeterinarioRepository repository;

    @Test
    //(Exato) Tente buscar um nome existente usando letras minúsculas (ex: "pedro") quando no banco está "PEDRO". O teste deve falhar. Ou seja, busca por valor exato. Testar um nome que exista também.
    public void testarBuscarVeterianiroComNomeExistentePoremComNomeTodoMaisculoNoBancoPassandoTudoMinusculoRetornaErro(){
        String nomeErrado = "caio basilio";

        List<Veterinario> veterinarioEncontrado = repository.findByNome(nomeErrado);

        assertEquals(0, veterinarioEncontrado.size());
    }

    // (Exato) Tente buscar um nome existente usando letras minúsculas (ex: "PEDRO") quando no banco está "PEDRO". O teste deve retornar o veterinário correspondente.
    @Test
    public void testarBuscarVeterianiroComNomeTodoMaisculoNoBancoPassandoTudoMaiusculoRetornaCerto(){
        String nomeDigitado = "CAIO BASILIO";

        List<Veterinario> veterinarioEncontrado = repository.findByNome(nomeDigitado);

        assertNotEquals(0, veterinarioEncontrado.size());
        assertEquals(nomeDigitado, veterinarioEncontrado.get(0).getNome());
    }

    @Test
    //(case insensitive) Tente buscar um nome existente usando letras minúsculas(ex: “jose”) quando no banco não existe veterinário com esse nome. O teste deve falhar.
    public void testarBuscarVeterinarioUsandoLetrasMinusculasComEsseNomeNaoExistente(){
        String nomeNaoExiste = "caio basilio";

        List<Veterinario> veterinarioEncontrado = repository.findByNome(nomeNaoExiste);

        assertEquals(0, veterinarioEncontrado.size());
    }

    @Test
    // (case insensitive) Tente buscar um nome existente usando letras minúsculas(ex: “joao”) quando no banco existe veterinário com esse nome em caixa alta. O teste retorna o veterinário
    public void testarBuscaNomeComIgnoreCaseRetornaCorreto(){
        String nomeDigitado = "nicolas barbosa";
        int idEsperado = 13;
        String emailEsperado = "nicolas@gmail.com";


        List<Veterinario> veterinarioEncontrado = repository.findByNomeIgnoreCase(nomeDigitado);

        assertNotEquals(0, veterinarioEncontrado.size());
        assertEquals(idEsperado, veterinarioEncontrado.get(0).getId());
        assertEquals(emailEsperado, veterinarioEncontrado.get(0).getEmail());
    }

    // ciclo 2
    // 01
    @Test
    public void testeBuscarNomePorSilabaRetornaCorreto(){
        String like = "ed";
        String nomeEsperado1 = "Carlos Eduardo";
        String nomeEsperado2 = "Eduardo Lima";
        int tamanhoEsperado = 2;

        List<Veterinario> listaDeVeterinarios = repository.findByNomeContainsIgnoreCase(like);

        assertEquals(tamanhoEsperado, listaDeVeterinarios.size());
        assertEquals(nomeEsperado1, listaDeVeterinarios.get(0).getNome());
        assertEquals(nomeEsperado2, listaDeVeterinarios.get(1).getNome());
    }

    @Test
    public void testarBuscarSilabaNãoEncontraUsuario(){
        String like = "Fulano";
        int tamanhoEsperado = 0;

        List<Veterinario> listaDeVeterinarios = repository.findByNomeContainsIgnoreCase(like);

        assertEquals(tamanhoEsperado, listaDeVeterinarios.size());
    }

    @Test
    public void testeParametroNuloRetornaTodosVeterinarios(){
        String like = "";
        int tamanhoEsperado = 45;

        List<Veterinario> listaDeVeterinarios = repository.findByNomeContains(like);

        assertEquals(tamanhoEsperado, listaDeVeterinarios.size());
    }

    // ciclo 3
    // cenario a
    @Test
    public void testeBuscaVeterinariosComSalariosSuperioAX(){
        Double salarioASerSuperado = 5000.0;
        int tamanhoEsperado = 24;

        List<Veterinario> listaDeVeterinarios = repository.findBySalarioGreaterThan(BigDecimal.valueOf(salarioASerSuperado));

        assertEquals(tamanhoEsperado, listaDeVeterinarios.size());
    }

    @Test
    public void testeBuscaVeterinariosComSalariosInferioAX(){
        Double salarioASerSuperado = 3800.0;
        int tamanhoEsperado = 15;

        List<Veterinario> listaDeVeterinarios = repository.findBySalarioLessThan(BigDecimal.valueOf(salarioASerSuperado));

        assertEquals(tamanhoEsperado, listaDeVeterinarios.size());
    }

    @Test
    public void testeBuscaVeterinariosComSalariosEntreXY(){
        int tamanhoEsperado = 6;
        Double salarioMinimo = 3800.0;
        Double salarioMaximo = 5000.0;

        List<Veterinario> listaDeVeterinarios = repository.findBySalarioBetween(BigDecimal.valueOf(salarioMinimo), BigDecimal.valueOf(salarioMaximo));

        assertEquals(tamanhoEsperado, listaDeVeterinarios.size());
    }

    @Test
    public void testeBuscaValidaUpdate(){
        int idParaSerAlterado = 11;
        String nomeAlterado = "Fulaninho Br";
        BigDecimal salarioAalterado = BigDecimal.valueOf(1200.0);
        int tamanhoEsperado = 1;

        Veterinario veterinarioParaSerAlterado = repository.findById(idParaSerAlterado);

        veterinarioParaSerAlterado.setNome(nomeAlterado);
        veterinarioParaSerAlterado.setSalario(salarioAalterado);
        repository.save(veterinarioParaSerAlterado);

        List<Veterinario> veterinarioEncontrado = repository.findByNome(nomeAlterado);

        assertEquals(tamanhoEsperado, veterinarioEncontrado.size());
        assertEquals(nomeAlterado, veterinarioEncontrado.get(0).getNome());
        assertEquals(salarioAalterado, veterinarioEncontrado.get(0).getSalario()); 
    }
}
