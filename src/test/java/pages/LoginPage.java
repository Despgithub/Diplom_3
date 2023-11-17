package pages;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class LoginPage {
    private static final By EMAIL_FIELD = By.xpath("//input[@name='name']");
    private static final By PASSWORD_FIELD = By.xpath("//input[@name='Пароль']");
    private static final By LOGIN_BUTTON = By.xpath("//button[text()='Войти']");
    private static final By REGISTER_LINK = By.xpath("//a[@href='/register']");
    private static final By FORGOT_PASSWORD_LINK = By.xpath("//a[@href='/forgot-password']");
    private static final By LOGIN_PAGE_LOCATOR = By.xpath("//div[@class='Auth_login__3hAey']");

    private final WebDriver driver;

    @Step("Заполнение поля ввода логина")
    public void fillLoginField(String email) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    @Step("Заполнение поля ввода пароля")
    public void fillPasswordField(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    @Step("Нажатие кнопки 'Войти'")
    public void cliklogin() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Вход клиента")
    public void loginUser(String email, String password) {
        fillLoginField(email);
        fillPasswordField(password);
        cliklogin();
    }

    @Step("Нажатие ссылки 'Зарегистрироваться'")
    public void clickRegisterLink() {
        driver.findElement(REGISTER_LINK).click();
    }

    @Step("Нажатие ссылки 'Восстановить пароль'")
    public void clickForgotPasswordLink() {
        driver.findElement(FORGOT_PASSWORD_LINK).click();
    }

    @Step("Проверка отображения страницы входа")
    public boolean isLoginPageVisiable() {
        return (driver.findElement(LOGIN_PAGE_LOCATOR).isDisplayed());
    }
}
