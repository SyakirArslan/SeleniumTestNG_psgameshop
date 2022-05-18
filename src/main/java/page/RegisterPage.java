package page;

import org.openqa.selenium.By;

public class RegisterPage {

    protected By favGenre = By.id("acf-field_5e758bca4e8cc");
    protected By favConsole = By.id("acf-field_5e75905014c81");
    protected By hobAndIntrs = By.id("acf-field_5ea976d054e4e");
    protected By gender = By.id("acf-field_5ea3be750efb3-male");
    protected By emailAdrs = By.id("reg_email");
    protected By password = By.id("reg_password");
    protected By confirmPass = By.id("reg_confirm_password");
    protected By regisBtn = By.name("register");
    protected By closeBtn = By.xpath("//button[@title=\"Close (Esc)\"]");

    //Assert Text
    protected By notifText = By.cssSelector(".message-container");
    protected By weekPass = By.xpath("//div[contains(text(),'Very weak - Please enter a stronger password.')]");

    public By getFavGenre() {
        return favGenre;
    }

    public By getFavConsole() {
        return favConsole;
    }

    public By getHobAndIntrs() {
        return hobAndIntrs;
    }

    public By getGender() {
        return gender;
    }

    public By getEmailAdrs() {
        return emailAdrs;
    }

    public By getPassword() {
        return password;
    }

    public By getConfirmPass() {
        return confirmPass;
    }

    public By getRegisBtn() {
        return regisBtn;
    }

    public By getCloseBtn() {
        return closeBtn;
    }

    public By getNotifText() {
        return notifText;
    }

    public By getWeekPass() {
        return weekPass;
    }
}
