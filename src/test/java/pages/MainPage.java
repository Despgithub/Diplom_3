package pages;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class MainPage {

    private static final By PERSONAL_ACCOUNT_BUTTON = By.xpath("//p[text()='Личный Кабинет']");
    private static final By LOGIN_BUTTON = By.xpath("//button[text()='Войти в аккаунт']");
    private static final By bunTab = By.xpath("//div[span[text()='Булки']]");
    private static final By souseTab = By.xpath("//div[span[text()='Соусы']]");
    private static final By fillingTab = By.xpath("//div[span[text()='Начинки']]");
    private static final By MAIN_PAGE_LOCATOR = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']");


    private final WebDriver driver;

    @Step("Нажатие кнопки 'Личный кабинет'")
    public void clickPersonalAccountButton() {
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
    }

    @Step("Нажатие кнопки 'Войти в аккаунт'")
    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Выбор вкладки 'Булки'")
    public void clickBunTab() {
        driver.findElement(bunTab).click();
    }

    @Step("Выбор вкладки 'Соусы'")
    public void clickSouseTab() {
        driver.findElement(souseTab).click();
    }

    @Step("Выбор вкладки 'Начинки'")
    public void clickFillingTab() {
        driver.findElement(fillingTab).click();
    }

    @Step("Получение атрибута класса 'Булки'")
    public String getBunsAttribute() {
        return driver.findElement(bunTab).getAttribute("class");
    }

    @Step("Получение атрибута класса 'Соусы'")
    public String getSaucesAttribute() {
        return driver.findElement(souseTab).getAttribute("class");
    }

    @Step("Получение атрибута класса 'Начинки'")
    public String getFillingsAttribute() {
        return driver.findElement(fillingTab).getAttribute("class");
    }

    @Step("Проверка отображения главной страницы")
    public boolean isMainPageVisiable() {
        return (driver.findElement(MAIN_PAGE_LOCATOR).isDisplayed());
    }

}
