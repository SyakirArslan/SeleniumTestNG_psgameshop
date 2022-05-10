package page;

import org.openqa.selenium.By;

public class LoginPage {

    protected By emailField = By.id("username");
    protected By passField = By.id("password");
    protected By loginBtn = By.name("login");

    //Selector By Classname
//    protected By nullError = By.className("message-icon icon-close");
//    protected By passEmpty = By.className("message-icon icon-close");
//    protected By unKnownEmail = By.linkText("Unknown email address. Check again or try your username.");
//    protected By passsIncorrect = By.className("message-icon");

    //Assert Text
    protected By nullError = By.cssSelector(".message-container");
    protected By passEmpty = By.cssSelector(".message-container");
    protected By unKnownEmail = By.cssSelector(".message-container");
    protected By passsIncorrect = By.cssSelector(".message-container");

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
        return nullError;
    }

    public By getPassEmpty() {
        return passEmpty;
    }

    public By getUnKnownEmail() {
        return unKnownEmail;
    }

    public By getPasssIncorrect() {
        return passsIncorrect;
    }
}
