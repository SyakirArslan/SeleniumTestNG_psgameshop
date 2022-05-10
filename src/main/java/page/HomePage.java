package page;

import org.openqa.selenium.By;

public class HomePage {

    protected By loginBtn = By.className("icon-user");
    protected By regisBtn = By.className("icon-user");
    protected By homePage = By.className("header-logo-dark");
    protected By allProductBtn = By.cssSelector(".hide-for-medium > span");

    public By getRegisBtn(){
        return regisBtn;
    }

    public By getLoginBtn(){
        return loginBtn;
    }

    public By getHomePage() {
        return homePage;
    }

    public By getAllProductBtn() {
        return allProductBtn;
    }

}
