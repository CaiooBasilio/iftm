package org.iftm.gerenciadorveterinarios.servicies;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iftm.gerenciadorveterinarios.entities.Veterinario;
import org.iftm.gerenciadorveterinarios.repositories.VeterinarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VeterinarioServiceTest {

    // cria a simulação/mock de todas as classes que serão injetadas na classe a ser testada
    @Mock
    private VeterinarioRepository repositorio;

    //classe a ser testada que receberá todas as injeções de classes mock
    @InjectMocks
    private VeterinarioService service;

    /*Validar se a busca por veterinario retorna o veterinário correto e o nome com no máximo 10 caracteres. */
    @Test
    public void testarBuscarVeterinarioPorIDExistenteRetornaVeterinarioComTruncado(){
        //arrange
        String nomeExistente = "Erica Queiroz Pinto";
        int tamanhoEsperadoNome = 10;        
        String nomeEsperado = "Erica Quei";
        Veterinario veterinarioEsperado = new Veterinario(null, nomeExistente, "", "", BigDecimal.valueOf(0));

        //configurar o mock - criando o cenário de teste
        when(repositorio.findById(Mockito.anyInt())).thenReturn(Optional.of(veterinarioEsperado));

        //act
        Optional<Veterinario> resposta = service.buscaVeterinariosPeloId(Mockito.anyInt());   
        Veterinario veterinarioRetornado = resposta.get();

        //assert
        assertTrue(resposta.isPresent());
        assertEquals(tamanhoEsperadoNome, veterinarioRetornado.getNome().length());
        assertEquals(nomeEsperado, veterinarioRetornado.getNome());

        verify(repositorio).findById(Mockito.anyInt());
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

        verify(repositorio).delete(veterinarioExcluido);

    }

    @Test
    public void  buscaVeterinariosComParteNome(){
        // cria a parte do nome a ser buscado
        String nomeASerBuscado = "Basilio";

        // crio o 1° veterinario 
        Veterinario primeiroVeterinario = new Veterinario();
        primeiroVeterinario.setNome("Fulano Basilio");

        // crio o 2° veterinario
        Veterinario segundoVeterinario = new Veterinario();
        segundoVeterinario.setNome("Ciclano Basilio");

        // Cria um "Banco" imaginario para uso da atividade
        List<Veterinario> listaDeVeterinarios = new ArrayList<Veterinario>();
        listaDeVeterinarios.add(primeiroVeterinario);
        listaDeVeterinarios.add(segundoVeterinario);

        // configurando o mockito afim de que se chamar tal metodo ele deve retornar a lista criada
        when(service.buscaVeterinariosComParteNome(nomeASerBuscado)).thenReturn(listaDeVeterinarios);

        // a ação, onde realmente o test chama o metodo
        List<Veterinario> respostaObtida = service.buscaVeterinariosComParteNome(nomeASerBuscado);

        assertTrue(respostaObtida.size() == listaDeVeterinarios.size());
        assertEquals(listaDeVeterinarios.get(0), respostaObtida.get(0));
        assertEquals(listaDeVeterinarios.get(1), respostaObtida.get(1));

        verify(repositorio).findByNomeContains(Mockito.any());
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

        when(repositorio.findById(idNãoExistente)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, ()-> {
            service.deletar(idNãoExistente);
        });

        verify(repositorio, never()).delete(Mockito.any());
    }
}
