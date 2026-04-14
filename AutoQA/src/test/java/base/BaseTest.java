package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.*;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = DriverFactory.initDriver();

        driver.manage().window().maximize();
        driver.get(ConfigReader.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.getDriver().quit();
    }
}