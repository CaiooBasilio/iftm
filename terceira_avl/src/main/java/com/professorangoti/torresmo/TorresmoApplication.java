package com.professorangoti.torresmo;

import org.springframework.boot.SpringApplication; // importa a classe que inicia a aplicação Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication; // importa a anotação que habilita a configuração automática do Spring Boot
import org.springframework.context.annotation.Bean;

import com.professorangoti.torresmo.model.Produto;
import com.professorangoti.torresmo.repository.ProdutoRepository;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication // anotação que marca a classe principal da aplicação e ativa configuração automática, varredura de componentes e configurações do Spring Boot
public class TorresmoApplication { // declaração da classe principal da aplicação

	public static void main(String[] args) { // método main: ponto de entrada da aplicação Java
		SpringApplication.run(TorresmoApplication.class, args); // chama o mecanismo do Spring Boot para inicializar o contexto da aplicação e iniciar o servidor embutido
	}

	@Bean // Diz ao Spring que este método retorna um bean gerenciado (CommandLineRunner).
	CommandLineRunner intiDatabase(ProdutoRepository produtoRepository){ // Cria um bean que executa código ao iniciar a aplicação, recebendo o repositório de produtos.
		return args ->{ // Função lambda que será executada na inicialização.
			if(produtoRepository.count()==0){ // Se não houver produtos no banco, executa o bloco abaixo.
				System.out.println("Inserindo dados iniciais na tabela produto"); // Exibe mensagem no console.

				Produto p1 = new Produto();//cria um novo produto 
				p1.setNome("Torresmo Tradicional");//define o nome do produto
				p1.setDescricao("Torresmo crocante feito com a melhor carne suína.");//define a descrição
				p1.setPreco(19.90);//define o preço
				p1.setTamanho("500g");//define o tamanho
				p1.setDisponivel(true);//marca como disponível
				p1.setDestaque(true);
				produtoRepository.save(p1);//salva o produto p1 no banco

				Produto p2 = new Produto();//cria outro produto
				p2.setNome("Torresmo Apimentado");//define o nome
				p2.setDescricao("Torresmo crocante com um toque picante para os amantes de emoção.");//define a descrição
				p2.setPreco(21.90);//define o preço
				p2.setTamanho("500g");//define o tamanho
				p2.setDisponivel(false);//marca como disponível
				p2.setDestaque(false);
				produtoRepository.save(p2);//salva o produto p2 no banco

				Produto p3 = new Produto();//cria outro produto
				p3.setNome("Torresmo Gourmet");//define o nome
				p3.setDescricao("Torresmo premium preparado com ingredientes selecionados para um sabor excepcional.");//define a descrição
				p3.setPreco(29.90);//define o preço
				p3.setTamanho("300g");//define o tamanho
				p3.setDisponivel(true);//marca como disponível
				p3.setDestaque(true);
				produtoRepository.save(p3);//salva o produto p3 no banco

				Produto p4 = new Produto();//cria outro produto
				p4.setNome("Torresmo com Queijo");//define o nome
				p4.setDescricao("Delicioso torresmo coberto com queijo derretido para um sabor irresistível.");//define a descrição
				p4.setPreco(24.90);//define o preço
				p4.setTamanho("400g");//define o tamanho
				p4.setDisponivel(false);//marca como disponível
				p4.setDestaque(false);
				produtoRepository.save(p4);//salva o produto p4 no banco

				Produto p5 = new Produto();//cria outro produto
				p5.setNome("Torresmo Barbecue");//define o nome
				p5.setDescricao("Torresmo crocante com um sabor defumado de barbecue irresistível.");//define a descrição
				p5.setPreco(22.90);//define o preço
				p5.setTamanho("500g");//define o tamanho
				p5.setDisponivel(true);//marca como disponível
				p5.setDestaque(true);
				produtoRepository.save(p5);//salva o produto p5 no banco
			}
		};
	}

}
