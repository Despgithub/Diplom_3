import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static config.DriverConfig.createDriver;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void startUp() {
        driver = createDriver();
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown() {
        driver.close();
        driver.quit();
    }
}
