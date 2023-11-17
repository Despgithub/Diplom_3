package pages;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class ForgotPasswordPage {
    private static final By LOGIN_LINK = By.xpath("//a[@href='/login']");

    private final WebDriver driver;


    @Step("Нажатие кнопки 'Войти'")
    public void clikLogiLink() {
        driver.findElement(LOGIN_LINK).click();
    }
}
