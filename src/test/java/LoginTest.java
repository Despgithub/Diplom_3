import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.CreateUserRequest;
import org.junit.Assert;
import org.junit.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static clients.UserApiClient.*;
import static helpers.DataGenerator.getUser;
import static helpers.UserHelper.userDeserialization;

public class LoginTest extends BaseTest {

    @DisplayName("Вход через кнопку 'Личный кабинет'")
    @Description("После успешной авторизации должен произойти редирект на главную страницу")
    @Test
    public void loginWithLoginButtonTest() {
        CreateUserRequest data = getUser();
        Response response = createUserRequest(data);
        userDeserialization(response);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickPersonalAccountButton();
        loginPage.loginUser(data.getEmail(), data.getPassword());
        Assert.assertTrue("Ошибка входа", mainPage.isMainPageVisiable());
        deleteUserRequest(getAuthToken(response));
    }

    @DisplayName("Вход по кнопке 'Войти в аккаунт' на главной")
    @Description("После успешной авторизации должен произойти редирект на главную страницу")
    @Test
    public void loginWithPersonalAccountButtonTest() {
        CreateUserRequest data = getUser();
        Response response = createUserRequest(data);
        userDeserialization(response);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickLoginButton();
        loginPage.loginUser(data.getEmail(), data.getPassword());
        Assert.assertTrue("Ошибка входа", mainPage.isMainPageVisiable());
        deleteUserRequest(getAuthToken(response));
    }

    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("После успешной авторизации должен произойти редирект на главную страницу")
    @Test
    public void loginWithRegisterFormButtonTest() {
        CreateUserRequest data = getUser();
        Response response = createUserRequest(data);
        userDeserialization(response);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegisterLink();
        registerPage.clickLoginLink();
        loginPage.loginUser(data.getEmail(), data.getPassword());
        Assert.assertTrue("Ошибка входа", mainPage.isMainPageVisiable());
        deleteUserRequest(getAuthToken(response));
    }

    @DisplayName("Вход через кнопку в форме восстановления пароля.")
    @Description("После успешной авторизации должен произойти редирект на главную страницу")
    @Test
    public void loginWithForgotPasswordFormButtonTest() {
        CreateUserRequest data = getUser();
        Response response = createUserRequest(data);
        userDeserialization(response);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        mainPage.clickPersonalAccountButton();
        loginPage.clickForgotPasswordLink();
        forgotPasswordPage.clikLogiLink();
        loginPage.loginUser(data.getEmail(), data.getPassword());
        Assert.assertTrue("Ошибка входа", mainPage.isMainPageVisiable());
        deleteUserRequest(getAuthToken(response));
    }
}
