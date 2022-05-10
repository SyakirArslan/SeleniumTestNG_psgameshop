package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    String webUrl = "https://www.psegameshop.com/";
    String driverPath = "src/test/resources/chromedriver.exe";

    public WebDriver driver;
    public WebDriver closeDriver() {
        return this.driver;
    }

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(webUrl);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        closeDriver().quit();
    }
}
