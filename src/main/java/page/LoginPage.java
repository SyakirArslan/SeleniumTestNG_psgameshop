package page;

import org.openqa.selenium.By;

public class LoginPage {

    protected By emailField = By.id("username");
    protected By passField = By.id("password");
    protected By loginBtn = By.name("login");

    //Assert Text
    protected By notifText = By.cssSelector(".message-container");

    public By getEmailField() {
        return emailField;
    }

    public By getPassField() {

        return passField;
    }

    public By getLoginBtn() {

        return loginBtn;
    }

    //Error Return
    public By getNullError() {
        return notifText;
    }

    public By getPassEmpty() {
        return notifText;
    }

    public By getUnKnownEmail() {
        return notifText;
    }

    public By getPasssIncorrect() {
        return notifText;
    }
}
