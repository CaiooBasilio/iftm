package com.atividade.vet.model; // Define o pacote da classe

import jakarta.persistence.Entity; // Importa anotação para marcar como entidade JPA
import jakarta.persistence.GeneratedValue; // Importa anotação para geração automática de ID
import jakarta.persistence.GenerationType; // Importa tipos de geração de ID
import jakarta.persistence.Id; // Importa anotação para campo identificador
import jakarta.persistence.JoinColumn; // Importa anotação para definir coluna de junção
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table; // Importa anotação para definir tabela
import jakarta.persistence.ForeignKey; // Importa anotação para definir chave estrangeira
import lombok.Data; // Importa anotação para gerar métodos automaticamente
import lombok.NoArgsConstructor; // Importa anotação para construtor sem argumentos

@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "usuarios") // Define o nome da tabela no banco de dados
@Data // Gera automaticamente getters/setters, equals, hashCode e toString
@NoArgsConstructor // Gera automaticamente um construtor sem argumentos
public class Usuario {
    @Id // Indica que este campo é o identificador único
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o ID automaticamente
    private Long id; // Identificador do usuário
    private String nome; // Nome do usuário
    private String email; // Email do usuário
    private String senha; // Senha do usuário

    @ManyToOne//indica que o usuario pode ter mts animais
    @JoinColumn(name = "animal_id", nullable = false, foreignKey = @ForeignKey(name = "fk_usuario_animal")) // Define a coluna de junção para o animal
    private Animal animal; // Referência ao animal associado ao usuário

    // Construtor que inicializa todos os campos
    public Usuario(String nome, String email, String senha, Animal animal) {
        this.nome = nome; // Inicializa o nome
        this.email = email; // Inicializa o email
        this.senha = senha; // Inicializa a senha
        this.animal = animal; // Inicializa o animal
    }
}
