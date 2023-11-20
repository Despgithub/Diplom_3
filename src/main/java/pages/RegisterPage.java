package pages;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class RegisterPage {
    private static final By REGISTRATION_BUTTON = By.xpath("//button[text()='Зарегистрироваться']");
    private static final By NAME_INPUT = By.xpath("//label[text()='Имя']/following::input");
    private static final By EMAIL_INPUT = By.xpath("//label[text()='Email']/following::input");
    private static final By PASS_INPUT = By.xpath("//input[@type='password']");
    private static final By LOGIN_LINK = By.xpath("//a[@href='/login']");
    private final By passwordErrorMessage = By.xpath("//p[text()='Некорректный пароль']");

    private final WebDriver driver;

    @Step("Заполнение поля ввода имени")
    public void fillName(String name) {
        driver.findElement(NAME_INPUT).sendKeys(name);
    }

    @Step("Заполнение поля ввода email")
    public void fillEmail(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    @Step("Заполнение поля ввода логина")
    public void fillPassword(String password) {
        driver.findElement(PASS_INPUT).sendKeys(password);
    }

    @Step("Нажатие кнопки 'Зарегистрироваться'")
    public void clickRegisterButton() {
        driver.findElement(REGISTRATION_BUTTON).click();
    }

    @Step("Регистрация пользователя")
    public void registerUser(String name, String email, String password) {
        fillName(name);
        fillEmail(email);
        fillPassword(password);
        clickRegisterButton();
    }

    @Step("Нажатие ссылки 'Войти'")
    public void clickLoginLink() {
        driver.findElement(LOGIN_LINK).click();
    }

    @Step("Проверка отображения ошибки")
    public boolean isErrorMessageVisible() {
        return (driver.findElement(passwordErrorMessage).isDisplayed());
    }
}
