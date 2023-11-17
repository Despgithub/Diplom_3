import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {
    Faker faker = new Faker();

    @DisplayName("Регистрация пользователя с корректными данными")
    @Description("Должна отобразиться страница логина")
    @Test
    public void registrationTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegisterLink();
        registerPage.registerUser(faker.funnyName().name(), faker.internet().emailAddress(), faker.internet().password());
        Assert.assertTrue("Пользователь не зарегистрирован", loginPage.isLoginPageVisiable());
    }

    @DisplayName("Регистрация пользователя с некорректными паролем")
    @Description("Должно отобразиться сообщение Некорректный пароль")
    @Test
    public void errorRegistrationTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegisterLink();
        registerPage.registerUser(faker.funnyName().name(), faker.internet().emailAddress(), faker.internet().password(1, 5));
        Assert.assertTrue("Пользователь зарегистрирован", registerPage.isErrorMessageVisible());
    }
}
