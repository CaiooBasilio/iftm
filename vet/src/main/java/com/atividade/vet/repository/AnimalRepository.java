package com.atividade.vet.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atividade.vet.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{
}
