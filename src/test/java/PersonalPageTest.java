import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.CreateUserRequest;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PersonalPage;

import static clients.UserApiClient.*;
import static helpers.DataGenerator.getUser;
import static helpers.UserHelper.userDeserialization;

public class PersonalPageTest extends BaseTest {

    @DisplayName("Переход по клику на 'Личный кабинет'")
    @Description("Должна отобразиться страница личного кабинета")
    @Test
    public void PersonalAccountClickTest() {
        CreateUserRequest data = getUser();
        Response response = createUserRequest(data);
        userDeserialization(response);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalPage personalPage = new PersonalPage(driver);
        mainPage.clickPersonalAccountButton();
        loginPage.loginUser(data.getEmail(), data.getPassword());
        mainPage.clickPersonalAccountButton();
        Assert.assertTrue("Ошибка перехода", personalPage.isPersonalPageVisiable());
        deleteUserRequest(getAuthToken(response));
    }

    @DisplayName("Переход из личного кабинета в конструктор по клику на 'Конструктор'")
    @Description("Должен отобразиться конструктор на главной странице")
    @Test
    public void constructorCLickTest() {
        CreateUserRequest data = getUser();
        Response response = createUserRequest(data);
        userDeserialization(response);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalPage personalPage = new PersonalPage(driver);
        mainPage.clickPersonalAccountButton();
        loginPage.loginUser(data.getEmail(), data.getPassword());
        mainPage.clickPersonalAccountButton();
        personalPage.clickConstructorButton();
        Assert.assertTrue("Ошибка перехода", mainPage.isMainPageVisiable());
        deleteUserRequest(getAuthToken(response));
    }

    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    @Description("Должен отобразиться конструктор на главной странице")
    @Test
    public void logoClickTest() {
        CreateUserRequest data = getUser();
        Response response = createUserRequest(data);
        userDeserialization(response);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalPage personalPage = new PersonalPage(driver);
        mainPage.clickPersonalAccountButton();
        loginPage.loginUser(data.getEmail(), data.getPassword());
        mainPage.clickPersonalAccountButton();
        personalPage.clickLogo();
        Assert.assertTrue("Ошибка перехода", mainPage.isMainPageVisiable());
        deleteUserRequest(getAuthToken(response));
    }

    @DisplayName("Выход из аккаунта")
    @Description("Должна отобразиться страница входа")
    @Test
    public void logOutTest() {
        CreateUserRequest data = getUser();
        Response response = createUserRequest(data);
        userDeserialization(response);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalPage personalPage = new PersonalPage(driver);
        mainPage.clickPersonalAccountButton();
        loginPage.loginUser(data.getEmail(), data.getPassword());
        mainPage.clickPersonalAccountButton();
        personalPage.clickLogOutButton();
        Assert.assertTrue("Ошибка выхода из аккаунта", loginPage.isLoginPageVisiable());
        deleteUserRequest(getAuthToken(response));
    }

}
