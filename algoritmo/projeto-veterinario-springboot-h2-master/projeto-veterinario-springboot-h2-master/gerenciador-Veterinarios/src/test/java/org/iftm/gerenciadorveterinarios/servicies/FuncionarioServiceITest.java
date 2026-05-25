package org.iftm.gerenciadorveterinarios.servicies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.iftm.gerenciadorveterinarios.entities.Funcionario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FuncionarioServiceITest {

    @Autowired
    private FuncionarioService service;

    @Test
    public void verificaCadastroFuncionarioEmFeriasDeveRetornarException(){
        Funcionario funcionarioParaTeste = new Funcionario(); 
        funcionarioParaTeste.setEmFerias(true);
        funcionarioParaTeste.setSalario(3000.0);

        assertThrows(IllegalArgumentException.class, () -> {
            service.cadastrarFuncionario(funcionarioParaTeste);
        });

    }

    @Test
    public void verificaCadastroFuncionarioSalarioMenorDeveRetornarException(){
        Funcionario funcionarioParaTeste = new Funcionario(); 
        funcionarioParaTeste.setEmFerias(false);
        funcionarioParaTeste.setSalario(1000.0);

        assertThrows(IllegalArgumentException.class, () -> {
            service.cadastrarFuncionario(funcionarioParaTeste);
        });

    }

    @Test
    public void verificarCadastrarNovoFuncionario(){
        Funcionario funcionarioParaTeste = new Funcionario(); 
        funcionarioParaTeste.setEmFerias(false);
        funcionarioParaTeste.setSalario(3000.0);

        Funcionario funcionarioRecebido = service.cadastrarFuncionario(funcionarioParaTeste);

        assertEquals(funcionarioParaTeste, funcionarioRecebido);

    }

    @Test
    public void testaConcederFeriasComIdInvalidoDeveRetornarUmaExcetion(){
        int idNaoExiste = 9850;
        // Funcionario primeiroFuncionario = new Funcionario();
        // primeiroFuncionario.setId(1);

        // Funcionario segundoFuncionario = new Funcionario();
        // segundoFuncionario.setId(2);

        // List<Funcionario> listaDeFuncionarios = new ArrayList<Funcionario>();
        // listaDeFuncionarios.add(primeiroFuncionario);
        // listaDeFuncionarios.add(segundoFuncionario);

        assertThrows(IllegalArgumentException.class, ()->{
            service.concederFerias(idNaoExiste);
        });

    }

    @Test
    public void testaConcederFeriasComIdValido(){
        int idValido = 1;
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1);
        funcionario.setEmFerias(false);

        Funcionario funcionarioObitido= service.concederFerias(idValido);

        assertEquals(funcionario.getId(), funcionarioObitido.getId());
    }
}
