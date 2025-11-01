/*
PRODUTO {
    BIGSERIAL id_produto PK
    VARCHAR   nome
    TEXT      descricao
    NUMERIC   preco
    VARCHAR   tamanho
    BOOLEAN   disponivel
  }
*/

package com.professorangoti.torresmo.model; // declara o pacote onde a entidade Produto está localizada

import jakarta.persistence.Entity; // importa a anotação que marca uma classe como entidade JPA
import jakarta.persistence.GeneratedValue; // importa a anotação que indica geração automática de valor para o id
import jakarta.persistence.GenerationType; // importa a enumeração que define estratégias de geração de id
import jakarta.persistence.Id; // importa a anotação que marca o campo como chave primária
import lombok.Data; // importa a anotação Lombok que gera getters, setters, equals, hashCode e toString automaticamente
import lombok.NoArgsConstructor; // importa a anotação Lombok que gera um construtor sem argumentos

@Entity//ela cria a tabela 
@Data // gera automaticamente métodos boilerplate (get/set, toString, equals, hashCode)
@NoArgsConstructor // gera um construtor sem argumentos, necessário para JPA
public class Produto {//nome da tabela
    @Id//define a proxima coluna como id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//define que o id sera de auto incrementado
    private Long idProduto; //nome da coluna que representa a chave primária (id)
    private String nome; // coluna para armazenar o nome do produto
    private String descricao; // coluna para armazenar descrição detalhada do produto
    private Double preco; // coluna para armazenar o preço (usar Double para valores numéricos com casas decimais)
    private String tamanho; // coluna para armazenar o tamanho ou variação do produto
    private Boolean disponivel; // coluna que indica se o produto está disponível (true/false)
    private Boolean destaque;
}
