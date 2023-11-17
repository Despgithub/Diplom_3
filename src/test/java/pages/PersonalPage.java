package pages;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class PersonalPage {
    private static final By LOGOUT_BUTTON = By.xpath("//button[text()='Выход']");
    private static final By CONSTRUCTOR_BUTTON = By.xpath("//p[contains(text(),'Конструктор')]");
    private static final By LOGO = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    private static final By PERSONAL_PAGE_LOCATOR = By.xpath("//div[@class='Account_account__vgk_w']");


    private final WebDriver driver;


    @Step("Нажатие кнопки 'Выход'")
    public void clickLogOutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
    }


    @Step("Нажатие ссылки 'Конструктор'")
    public void clickConstructorButton() {
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }

    @Step("Нажатие на логотип")
    public void clickLogo() {
        driver.findElement(LOGO).click();
    }

    @Step("Проверка отображения личной страницы")
    public boolean isPersonalPageVisiable() {
        return (driver.findElement(PERSONAL_PAGE_LOCATOR).isDisplayed());
    }
}
