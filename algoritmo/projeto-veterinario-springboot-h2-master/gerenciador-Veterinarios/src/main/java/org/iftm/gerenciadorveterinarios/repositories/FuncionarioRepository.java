package org.iftm.gerenciadorveterinarios.repositories;

import org.iftm.gerenciadorveterinarios.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

    
}
