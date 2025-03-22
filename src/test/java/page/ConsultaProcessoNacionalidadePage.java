package page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsultaProcessoNacionalidadePage {

    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://justica.gov.pt/Servicos/Consultar-estado-do-processo-de-nacionalidade");
    }

    @Test
    public void call() {

        WebElement titulo = driver.findElement(By.xpath("//div//h1"));
        WebElement botao = driver.findElement(By.id("dnn_ctr19326_HtmlModule_lblContent"));

        assertEquals("Consultar estado do processo de nacionalidade", titulo);

        Utils.scroll(driver, js, String.valueOf(botao));
        Utils.wait(driver);

        botao.click();


    }

    @AfterEach
    public void tearDown() {
        // Fechar o navegador após o teste
        if (driver != null) {
            driver.quit();
        }

    }
}
