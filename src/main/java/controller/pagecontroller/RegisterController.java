package controller.pagecontroller;

import controller.BaseController;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import page.RegisterPage;

public class RegisterController extends BaseController {

    RegisterPage registerPage = new RegisterPage();
    SoftAssert softAssert = new SoftAssert();

    public RegisterController(WebDriver driver) {
        super(driver);
    }

    public RegisterController selectFavGenre(){
        click(registerPage.getFavGenre());
        return this;
    }

    public RegisterController selectFavConsole(){
        click(registerPage.getFavConsole());
        return this;
    }

    public RegisterController selectHobAndIntrs(){
        click(registerPage.getHobAndIntrs());
        return this;
    }

    public RegisterController selectGender(){
        click(registerPage.getGender());
        return this;
    }

    public RegisterController fillEmail(String email){
        clearText(registerPage.getEmailAdrs());
        sendText(registerPage.getEmailAdrs(), email);
        return this;
    }

    public RegisterController fillPass(String password) {
        clearText(registerPage.getPassword());
        sendText(registerPage.getPassword(), password);
        return this;
    }

    public RegisterController fillconfirmPass(String confirmPass){
        clearText(registerPage.getConfirmPass());
        sendText(registerPage.getConfirmPass(), confirmPass);
        return this;
    }

    public RegisterController registerBtn(){
        click(registerPage.getRegisBtn());
        return this;
    }

    public RegisterController regisAssertion(String expected){
         //   click(registerPage.getRegisBtn());
        if ("Failed : null email and password".equals(expected)) {
            click(registerPage.getRegisBtn());
            softAssert.assertEquals(getText(registerPage.getNotifText()), "Error: Please provide a valid email address.");
        }
        else if ("Failed : null Password".equals(expected)) {
           // click(registerPage.getRegisBtn());
            softAssert.assertEquals(getText(registerPage.getNotifText()), "Error: Please enter an account password.");
        }
        else if ("Failed : Week Pass".equals(expected)) {
            softAssert.assertEquals(getText(registerPage.getWeekPass()),"Very weak - Please enter a stronger password.");
                 if (getText(registerPage.getWeekPass()).equals("Very weak - Please enter a stronger password.")){
                   //  mouseHover(registerPage.getCloseBtn());
                     click(registerPage.getCloseBtn());
                 }
        }
        else if ("Passed : Registered".equals(expected)) {
          //  click(registerPage.getRegisBtn());
            softAssert.assertEquals(getText(registerPage.getNotifText()), "Thank you for registering. Your account has to be activated before you can login. Please check your email.");
        }
        else if ("Failed : Already Register".equals(expected)) {
           // click(registerPage.getRegisBtn());
            softAssert.assertEquals(getText(registerPage.getNotifText()), "Error: An account is already registered with your email address. Please log in.");
        }
        return this;
    }

}
