package login;

import dto.PortifolioAutomacaoDto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class PortifolioAutomacaoLogin {

    public static PortifolioAutomacaoDto autenticacao (WebDriver driver) {
        PortifolioAutomacaoDto dto = new PortifolioAutomacaoDto();
        WebElement inputUsuario = Utils.buscarElemento(driver, "user-name");
        WebElement inputSenha = Utils.buscarElemento(driver, "password");

            dto.setUsuario("standard_user");
            dto.setSenha("secret_sauce");

        inputUsuario.sendKeys(dto.getUsuario());
        System.out.println("Usuário: " + dto.getUsuario());

        inputSenha.sendKeys(dto.getSenha());
        System.out.println("Senha: " + dto.getSenha() + "\n");

        return dto;
    }
}
