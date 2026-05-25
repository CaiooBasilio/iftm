package org.iftm.gerenciadorveterinarios.servicies;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.iftm.gerenciadorveterinarios.entities.Veterinario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VeterinarioServiceITest {

    //fazendo a injeção de dependencia da classe original
    @Autowired
    private VeterinarioService service;

    /*Validar se a busca por veterinario retorna o veterinário correto e o nome com no máximo 10 caracteres. */
    @Test
    @Transactional/*Serve para não "Sujar" o codigo, ele sempre volta o banco para o normal caso o teste seja de um save */
    public void testarBuscarVeterinarioPorIDExistenteRetornaVeterinarioComTruncado(){
        //arrange
        int tamanhoEsperadoNome = 10;        
        String nomeEsperado = "Erica Quei";
        int idExistente = 2;

        //act
        Optional<Veterinario> resposta = service.buscaVeterinariosPeloId(idExistente);   
        Veterinario veterinarioRetornado = resposta.get();

        //assert
        assertTrue(resposta.isPresent());
        assertEquals(tamanhoEsperadoNome, veterinarioRetornado.getNome().length());
        assertEquals(nomeEsperado, veterinarioRetornado.getNome());
    }

    @Test
    public void testarApagarRealmenteApagaRegistro(){
        //Arrange
        Integer idExistente = 2;
        String nomeExistente = "Erica Queiroz Pinto";
        Veterinario veterinarioExcluido = new Veterinario(idExistente, nomeExistente, "", "", null);

        //act and assert
        assertDoesNotThrow(
            ()->{
            service.apagar(veterinarioExcluido);
        }
        );

    }

    @Test
    public void  buscaVeterinariosComParteNome(){
        // cria a parte do nome a ser buscado
        String nomeASerBuscado = "Evaristo";
        int sizeEsperado = 1;
        String nomeEsperado = "Conceição Evaristo";


        // // crio o 1° veterinario 
        // Veterinario primeiroVeterinario = new Veterinario();
        // primeiroVeterinario.setNome("Fulano Basilio");

        // // crio o 2° veterinario
        // Veterinario segundoVeterinario = new Veterinario();
        // segundoVeterinario.setNome("Ciclano Basilio");

        // a ação, onde realmente o test chama o metodo
        List<Veterinario> respostaObtida = service.buscaVeterinariosComParteNome(nomeASerBuscado);

        assertTrue(respostaObtida.size() == sizeEsperado);
        assertEquals(respostaObtida.get(0).getNome(), nomeEsperado);

    }

    @Test
    public void deveLancarExcecaoAoApagarQuandoIdNaoExistir(){
        // crio o id ficticio que não existe
        Integer idNãoExistente= 1000;

        // //criando os salarios em bigDecimal
        // BigDecimal salarioVeterinarioUm = BigDecimal.valueOf(10000.0);
        // BigDecimal salarioVeterinarioDois = BigDecimal.valueOf(5200.0);

        // // criando o veterinario um
        // Veterinario primeiroVeterinario = new Veterinario(1, "Caio Fulano", "emailtop@email2com", "Ser o melhor", salarioVeterinarioUm);

        // // criando o veterinario dois
        // Veterinario segundoVeterinario = new Veterinario(2, "Fulano Caio", "omelhoremail@domundo", "Ser o segundo melhor", salarioVeterinarioDois);

        // // criando o "banco" onde tem os veterinarios
        // List<Veterinario> listaDeVeterinarios = new ArrayList<Veterinario>();


        assertThrows(RuntimeException.class, ()-> {
            service.deletar(idNãoExistente);
        });

    }
}
