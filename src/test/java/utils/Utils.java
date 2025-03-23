package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Utils {

    public static void takeScreenshot(WebDriver driver, String fileName) {
        // Tirar o screenshot e armazenar no tipo File
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshotFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            // Copiar o arquivo para o diretório de destino
            FileUtils.copyFile(screenshotFile, new File(fileName));
            System.out.println("Screenshot salva com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o screenshot: " + e.getMessage());
        }
    }

    public static WebElement buscarElemento (WebDriver driver, String elemento) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element;
        if (elemento.startsWith("//")) {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elemento)));
        } else {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elemento)));
        }
        return element;
    }


}
