package org.iftm.gerenciadorveterinarios.servicies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iftm.gerenciadorveterinarios.entities.Funcionario;
import org.iftm.gerenciadorveterinarios.entities.Veterinario;
import org.iftm.gerenciadorveterinarios.repositories.FuncionarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServiceTest {
    
    @Mock
    private FuncionarioRepository repositorio;

    @InjectMocks
    private FuncionarioService service;

    @Test
    public void verificaCadastroFuncionarioEmFeriasDeveRetornarException(){
        Funcionario funcionarioParaTeste = new Funcionario(); 
        funcionarioParaTeste.setEmFerias(true);
        funcionarioParaTeste.setSalario(3000.0);

        assertThrows(IllegalArgumentException.class, () -> {
            service.cadastrarFuncionario(funcionarioParaTeste);
        });

        verify(repositorio, never()).save(Mockito.any());
    }

    @Test
    public void verificaCadastroFuncionarioSalarioMenorDeveRetornarException(){
        Funcionario funcionarioParaTeste = new Funcionario(); 
        funcionarioParaTeste.setEmFerias(false);
        funcionarioParaTeste.setSalario(1000.0);

        assertThrows(IllegalArgumentException.class, () -> {
            service.cadastrarFuncionario(funcionarioParaTeste);
        });

        verify(repositorio, never()).save(Mockito.any());
    }

    @Test
    public void verificarCadastrarNovoFuncionario(){
        Funcionario funcionarioParaTeste = new Funcionario(); 
        funcionarioParaTeste.setEmFerias(false);
        funcionarioParaTeste.setSalario(3000.0);

        when(repositorio.save(funcionarioParaTeste)).thenReturn(funcionarioParaTeste);

        Funcionario funcionarioRecebido = service.cadastrarFuncionario(funcionarioParaTeste);

        assertEquals(funcionarioParaTeste, funcionarioRecebido);

        verify(repositorio).save(Mockito.any());
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

        verify(repositorio, never()).save(Mockito.any());
    }

    @Test
    public void testaConcederFeriasComIdValido(){
        int idValido = 1;
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1);
        funcionario.setEmFerias(false);

        when(repositorio.findById(idValido)).thenReturn(Optional.of(funcionario));

        Funcionario funcionarioObitido= service.concederFerias(idValido);

        assertEquals(funcionario.getId(), funcionarioObitido.getId());
    }
}
