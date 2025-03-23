package page;

import io.github.bonigarcia.wdm.WebDriverManager;
import login.PortifolioAutomacaoLogin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PortifolioAutomacaoPage {

    //Todos os métodos e códigos criados por Bruno Lanna Faria.
    //Este projeto tem por fundamento a apresentação de script de automação web autoral.
    //Utilizadas classes com estilo DTO(Data Transfer Object), LOGIN, e PAGE.
    //Para uma próxima versão, será desenvolvido um feature file em linguagem Gherkin.

    private static WebDriver driver;
    private JavascriptExecutor js;
    private static WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        //IDE utilizada IntelliJ
        //Versão suportada para o ChromeDriver tem de ser Google Chrome 114
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void Test() throws InterruptedException {

    ecraPrincipal();
    ecraListaCompras();
    ecraCarrinhoCompras();

    }

    @AfterEach
    public void tearDown() {
        // Fechar o navegador após o teste
        if (driver != null) {
            driver.quit();
        }
    }

    public void ecraPrincipal () throws InterruptedException {

        //Declaração dos elementos
        WebElement titulo = Utils.buscarElemento(driver, "//*[@id=\"root\"]/div/div[1]");
        WebElement botaoLogin = Utils.buscarElemento(driver, "login-button");

        assertEquals("Swag Labs", titulo.getText());
        System.out.println("Título encontrato e esperado: " + titulo.getText());

        //Classe que faz o Login
        PortifolioAutomacaoLogin.autenticacao(driver);

        Utils.takeScreenshot(driver, "screenshot1");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", botaoLogin);

        Thread.sleep(4000);
        botaoLogin.click();

    }

    public void ecraListaCompras() throws InterruptedException {

        //Declaração dos elementos
        //Lista de produtos
        WebElement tituloProduto = Utils.buscarElemento(driver, "//*[@id=\"item_4_title_link\"]/div");
        WebElement descricaoProduto = Utils.buscarElemento(driver, "//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[1]/div");
        WebElement valorProduto = Utils.buscarElemento(driver, "//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
        WebElement adicionarBackPack = Utils.buscarElemento(driver, "add-to-cart-sauce-labs-backpack");
        WebElement carrinhoCompras = Utils.buscarElemento(driver, "//*[@id=\"shopping_cart_container\"]/a");

        //Validações de textos
        assertEquals("Sauce Labs Backpack", tituloProduto.getText());
        System.out.println("Produto esperado e encontrado: " + tituloProduto.getText());

        assertEquals("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                descricaoProduto.getText());
        System.out.println("Descrição esperada e encontrado: " + descricaoProduto.getText());

        assertEquals("$29.99", valorProduto.getText());
        System.out.println("Valor do produto esperado e encontrado: " + valorProduto.getText());

        assertEquals("Add to cart", adicionarBackPack.getText());
        System.out.println("Texto botão 'Add' esperado e encontrado: " + adicionarBackPack.getText() + "\n");

        adicionarBackPack.click();
        Thread.sleep(5000);
        carrinhoCompras.click();

    }

    public void ecraCarrinhoCompras () throws InterruptedException {

        //Declaração dos elementos
        //Aceder ao carrinho
        WebElement  tituloCarrinho = Utils.buscarElemento(driver, "//*[@id=\"header_container\"]/div[2]/span");
        WebElement  produtoCarrinho = Utils.buscarElemento(driver, "//*[@id=\"item_4_title_link\"]/div");
        WebElement  descricaoCarrinho= Utils.buscarElemento(driver, "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]");
        WebElement  valorProdutoCarrinho= Utils.buscarElemento(driver, "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");

        assertEquals("Your Cart", tituloCarrinho.getText());
        System.out.println("Título carrinho esperado e encontrado: " + tituloCarrinho.getText());

        assertEquals("Sauce Labs Backpack", produtoCarrinho.getText());
        System.out.println("Título produto carrinho esperado e encontrado: " + produtoCarrinho.getText());

        assertEquals("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                descricaoCarrinho.getText());
        System.out.println("Título descrição do produto no carrinho esperado e encontrado: " + descricaoCarrinho.getText());

        assertEquals("$29.99", valorProdutoCarrinho.getText());
        System.out.println("Título descrição do produto no carrinho esperado e encontrado: " + valorProdutoCarrinho.getText());
        Thread.sleep(5000);

    }

}
