import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void startUp() {
        // Chrome
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        // Яндекс Браузер
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);

        //Общее
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
