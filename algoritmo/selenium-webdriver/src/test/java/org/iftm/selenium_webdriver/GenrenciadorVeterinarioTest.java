package org.iftm.selenium_webdriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenrenciadorVeterinarioTest {
    private WebDriver driver;

    @BeforeEach
    public void stup(){
        // configurando o google chrome para test
        WebDriverManager.chromedriver().setup();

        // defino o web driver é relacionado ao chrome
        driver = new ChromeDriver();
    }

    @Test
    public void testarTelaInicialCarregaDadosExistenteNoDB(){

        String urlDeTeste = "http://localhost:8080/home";
        String nomeNaPrimeiraLinha = "ConceiÃ§Ã£o Evaristo";
        String nomeNaSegundaLinha = "Erica Queiroz Pinto";
        String tituloEsperado = "Gerenciador de Veterinários";

        driver.get(urlDeTeste);
        WebElement primeiroNomeNaTela = driver.findElement(By.cssSelector("body > div:nth-child(2) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > span:nth-child(1)"));
        WebElement segundoNomeNaTela = driver.findElement(By.cssSelector("body > div:nth-child(2) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2) > span:nth-child(1)"));

        assertEquals(tituloEsperado, driver.getTitle());
        assertEquals(primeiroNomeNaTela.getText(), nomeNaPrimeiraLinha);
        assertEquals(segundoNomeNaTela.getText(), nomeNaSegundaLinha);
    }

    @Test
    public void testarBuscarVeterinariosExistentes() {
        String urlTestado = "http://localhost:8080/home";
        
        driver.get(urlTestado);
        WebElement btnConsultar = driver.findElement(By.xpath("//button[contains(text(),'Consultar')]"));
        btnConsultar.click();

        WebElement campoNome = driver.findElement(By.id("nome"));

        campoNome.sendKeys("ConceiÃ§Ã£o Evaristo");

        WebElement btnPesquisar = driver.findElement(By.cssSelector("button[type='submit']"));

        assertEquals("ConceiÃ§Ã£o Evaristo", campoNome.getAttribute("value"));
        btnPesquisar.click();
    }

     @Test
    public void testarCadatrarDeNovoVeterinario() {
        String urlTestado = "http://localhost:8080/home";
        driver.get(urlTestado);

        WebElement btnAdicionar = driver.findElement(By.xpath("//button[contains(text(),'Adicionar')]"));
        btnAdicionar.click();

        WebElement noemeTexto = driver.findElement(By.id("nome"));
        WebElement emailTxt = driver.findElement(By.id("inputEmail"));
        WebElement especieTxt = driver.findElement(By.id("inputEspecialidade"));
        WebElement salValor = driver.findElement(By.id("inputSalario"));

        noemeTexto.sendKeys("Caio Basilio");
        emailTxt.sendKeys("emailTest@gmail.com");
        especieTxt.sendKeys("exotico");
        salValor.sendKeys("15000.00");

        assertEquals("Caio Basilio", noemeTexto.getAttribute("value"));
        assertEquals("emailTest@gmail.com", emailTxt.getAttribute("value"));
        assertEquals("exotico", especieTxt.getAttribute("value"));
        assertEquals("15000.00", salValor.getAttribute("value"));

        WebElement botaoCadastrar = driver.findElement(By.xpath("//button[normalize-space()='Cadastrar']"));
        botaoCadastrar.click();
        assertTrue(driver.getCurrentUrl().contains("/home"));


        WebElement nomeNaUltimaLinha = driver.findElement(By.xpath("//tbody/tr[last()]/td[1]"));
        assertEquals("Caio Basilio", nomeNaUltimaLinha.getText());
    }

    @Test
    public void testarAlterarOCadastroDeCertoVeterinario() throws InterruptedException{

        String urlTestado = "http://localhost:8080/home";
        driver.get(urlTestado);

        WebElement btnAlterar = driver.findElement(By.xpath("//tbody/tr[2]/td[5]/a[1]/i[1]"));
        btnAlterar.click();
        Thread.sleep(1000);

        WebElement textoNome = driver.findElement(By.name("nome"));
        WebElement textoEmail = driver.findElement(By.name("email"));
        WebElement textoEspecialidade = driver.findElement(By.name("especialidade"));
        WebElement textoSalario = driver.findElement(By.name("salario"));

        textoNome.clear();
        textoEmail.clear();
        textoEspecialidade.clear();
        textoSalario.clear();

        textoNome.sendKeys("Caio Fulano");
        textoEmail.sendKeys("teste@gmail.com");
        textoEspecialidade.sendKeys("Grandes");
        textoSalario.sendKeys("25000");

        WebElement btnAtualizar = driver.findElement(By.xpath("//button[normalize-space()='Atualizar']"));
        btnAtualizar.click();


        WebElement ultimoNome = driver.findElement(By.xpath("//tbody/tr[last()]/td[1]"));
        assertEquals("Caio Basilio",ultimoNome.getText());
    }

    @Test
    public void testarDeletarCadastroDeVeterinarios(){
        String urlTestado = "http://localhost:8080/home";
        driver.get(urlTestado);

        WebElement ultimoNome = driver.findElement(By.xpath("//tbody/tr[last()]/td[1]"));
        String nomeVeterinario = ultimoNome.getText();

        WebElement btnDeletar = driver.findElement(By.xpath("//tbody/tr[last()]/td[5]/a[2]"));
        btnDeletar.click();
    
        assertFalse(driver.getPageSource().contains(nomeVeterinario));
    }

    @AfterEach
    public void exit(){
        driver.close();
    }
}
