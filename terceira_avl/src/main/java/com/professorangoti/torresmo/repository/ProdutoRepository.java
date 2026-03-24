package com.professorangoti.torresmo.repository; // declara o pacote deste arquivo Java, organizando-o no namespace do projeto

import org.springframework.data.jpa.repository.JpaRepository; // importa a interface JpaRepository do Spring Data que fornece métodos CRUD prontos
import org.springframework.stereotype.Repository; // importa a anotação @Repository usada para marcar componentes de persistência

import com.professorangoti.torresmo.model.Produto; // importa a entidade Produto usada como tipo da entidade no repositório

@Repository // anotação que informa ao Spring que esta interface é um bean do tipo repositório (opcional com Spring Data, mas comum)
public interface ProdutoRepository extends JpaRepository<Produto, Long> { // define uma interface de repositório que herda operações CRUD e de paginação do JpaRepository
  // JpaRepository<Produto, Long> diz que o repositório gerencia entidades Produto com chave primária do tipo Long
  
} // fim da declaração da interface
