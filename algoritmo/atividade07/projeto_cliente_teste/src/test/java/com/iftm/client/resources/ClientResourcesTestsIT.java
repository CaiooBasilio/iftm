package com.iftm.client.resources;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientResourcesTestsIT {

    @Autowired
    private MockMvc mockMvc; 

    @Test
    public void testarRetornarTodosOsNomesDosClientesCorreto() throws Exception {
        // arrange
        int quantidadeClientes = 12;
        int quantidadeLinhasPagina = 12;

        // act
        ResultActions resultados = mockMvc.perform(get("/clients/").accept(MediaType.APPLICATION_JSON));

        // assert
        resultados
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.content").exists())
            .andExpect(jsonPath("$.content").isArray())
            .andExpect(jsonPath("$.content[?(@.id == '%s')]", 7L).exists())
            .andExpect(jsonPath("$.content[?(@.id == '%s')]", 4L).exists())
            .andExpect(jsonPath("$.content[?(@.id == '%s')]", 8L).exists())
            .andExpect(jsonPath("$.content[?(@.name == '%s')]", "Toni Morrison").exists())
            
            .andExpect(jsonPath("$.content[?(@.id == 3 && @.name == 'Clarice Lispector')]").exists())
            .andExpect(jsonPath("$.content[?(@.cpf == '%s')]", "10919444522").exists())
            .andExpect(jsonPath("$.number").value(0))
            .andExpect(jsonPath("$.totalPages").value(1))
            .andExpect(jsonPath("$.totalElements").exists())
            .andExpect(jsonPath("$.totalElements").value(quantidadeClientes))
            .andExpect(jsonPath("$.numberOfElements").exists())
            .andExpect(jsonPath("$.numberOfElements").value(quantidadeLinhasPagina))
            .andExpect(jsonPath("$.content[*].id", containsInAnyOrder(4, 10, 3, 1, 6, 5, 12, 7, 2, 11, 8, 9)));
    }

    @Test
    public void testarBuscaPorIdExistenteRetornandoOClienteCorreto() throws Exception {
        // arrange
        long idExistente = 3L;

        // act
        ResultActions resultado = mockMvc.perform(
                get("/clients/id/{id}", idExistente).accept(MediaType.APPLICATION_JSON));

        // assert
        resultado
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(idExistente))
            .andExpect(jsonPath("$.name").value("Clarice Lispector"))
            .andExpect(jsonPath("$.cpf").value("10919444522"))
            .andExpect(jsonPath("$.income").value(3800.0))
            .andExpect(jsonPath("$.birthDate").value("1960-04-13T07:50:00Z"))
            .andExpect(jsonPath("$.children").value(2));
    }

    @Test
    public void testarBuscaPorIdQuandoIdNaoExisteRetornaNotFound() throws Exception {
        // arrange
        long idInexistente = 100L;

        // act
        ResultActions resultado = mockMvc.perform(
                get("/clients/id/{id}", idInexistente).accept(MediaType.APPLICATION_JSON));

        // assert
        resultado
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.status").value(404))
            .andExpect(jsonPath("$.error").value("Resource not found"))
            .andExpect(jsonPath("$.message").value("Entity not found"))
            .andExpect(jsonPath("$.path").value("/clients/id/" + idInexistente))
            .andExpect(jsonPath("$.timestamp").exists());
    }
}