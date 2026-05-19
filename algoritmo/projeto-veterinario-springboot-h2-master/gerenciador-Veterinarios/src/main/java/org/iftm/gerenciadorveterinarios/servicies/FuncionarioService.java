package org.iftm.gerenciadorveterinarios.servicies;

import java.util.Optional;

import org.iftm.gerenciadorveterinarios.entities.Funcionario;
import org.iftm.gerenciadorveterinarios.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repositorio;

    public Funcionario cadastrarFuncionario(Funcionario funcionario) {

        if (funcionario.getSalario() < 1600) {
            throw new IllegalArgumentException("Salário abaixo do mínimo.");
        }
        if (funcionario.getEmFerias().equals(true)) {
            throw new IllegalArgumentException("Não é possivel cadastrar um funcionario em ferias");
        }
        funcionario.setEmFerias(false);
        return repositorio.save(funcionario);
    }

    public Funcionario concederFerias(Integer id) {

        Optional<Funcionario> funcionario = repositorio.findById(id);
        
        if (!funcionario.isPresent()) {
            throw new IllegalArgumentException("O funcionario de ID " + id + " não existe!!");
        }
        
        funcionario.get().setEmFerias(true);

        return repositorio.save(funcionario.get());
    }

}
