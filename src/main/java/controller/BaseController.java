package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseController {

    public Actions action;
    public WebDriver driver;
    Duration durationWait = Duration.ofSeconds(10);
    WebDriverWait waitTime;

    public BaseController(WebDriver driver) {
        this.driver = driver;
        waitTime = new WebDriverWait(driver, durationWait);
    }

    public void click(By by) {
        waitVisibility(by).click();
    }

    public void sendText(By by, String text) {
        waitVisibility(by).sendKeys(text);
    }

    public void clearText(By by) {
        waitVisibility(by).clear();
    }

    public String getText(By by) {
        return waitVisibility(by).getText();
    }

    public void mouseHover(By by) {
        driver.manage().timeouts().implicitlyWait(durationWait);
        action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).build().perform();
    }

    public WebElement waitVisibility(By by) {
        return waitTime.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}
