package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    public static void scroll(WebDriver driver, JavascriptExecutor js, String pageElement){
        WebElement elemento;
       if (pageElement.startsWith("//") || pageElement.startsWith("(//")){
        elemento = new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageElement)));
       } else {
           elemento = new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(By.id(pageElement)));
       }
       js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", pageElement);
    }

    public static void wait(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
