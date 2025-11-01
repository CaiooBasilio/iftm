package com.professorangoti.torresmo.controller; // declara o pacote deste controller

import java.util.List; // importa a interface List usada para manipular coleções de Produto

import org.springframework.beans.factory.annotation.Autowired; // importa a anotação que permite injeção automática de dependências
import org.springframework.stereotype.Controller; // importa a anotação que marca a classe como um controller Spring MVC
import org.springframework.ui.Model; // importa a interface Model usada para passar dados para a view (Thymeleaf, por exemplo)
import org.springframework.web.bind.annotation.GetMapping; // importa a anotação para mapear requisições HTTP GET

import com.professorangoti.torresmo.model.Produto; // importa a entidade Produto
import com.professorangoti.torresmo.service.ProdutoService; // importa o serviço que encapsula lógica de negócio relacionada a Produto

@Controller // marca esta classe como componente Spring MVC que trata requisições web
public class ProdutoController {

  @Autowired // instrui o Spring a injetar automaticamente uma instância do ProdutoService (injeção por campo)
  ProdutoService produtoService; // campo que contém a referência ao serviço de produtos

  @GetMapping("/produtos") // mapeia requisições GET para '/produtos' para este método
  public String exibeProdutos(Model model) { // método que prepara dados e retorna o nome da view a ser renderizada
    List<Produto> produtos = produtoService.findAll(); // obtém a lista de produtos consultando o serviço
    System.out.println("Qtde: " + produtos.size()); // imprime no console a quantidade de produtos retornados (útil para debug)
    for (Produto produto : produtos) { // itera sobre cada produto na lista
      System.out.println("Produto: " + produto.getNome()); // imprime no console o nome de cada produto (debug)
    }
    model.addAttribute("produtos", produtos); // adiciona a lista de produtos ao modelo para que a view possa acessá-la
    return "produtos"; // retorna o nome da view (por exemplo, produtos.html no Thymeleaf)
  }

  @GetMapping("/") // mapeia requisições GET para a raiz '/' para este método
  public String home(Model model) { // método que prepara os dados para a página inicial
    List<Produto> produtos = produtoService.findAll(); // busca os produtos novamente para exibir na home
    model.addAttribute("produtos", produtos); // adiciona a lista ao modelo para uso na view 'home'
    List<Produto> produtosEmDestaque = produtos.stream()
        .filter(Produto::getDestaque)
        .toList();
      model.addAttribute("destaque", produtosEmDestaque);
      return "home"; 
      // retorna o nome da view da página inicial (home.html)
  // Removido método toList() desnecessário
  }

}
