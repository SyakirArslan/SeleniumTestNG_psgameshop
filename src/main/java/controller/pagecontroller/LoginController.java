package controller.pagecontroller;

import controller.BaseController;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import page.LoginPage;

public class LoginController extends BaseController {

    LoginPage loginPage = new LoginPage();
    SoftAssert softAssert = new SoftAssert();


    public LoginController(WebDriver driver) {
        super(driver);
    }

    public LoginController fillEmail(String email) {
        clearText(loginPage.getEmailField());
        sendText(loginPage.getEmailField(), email);
        return this;
    }

    public LoginController fillPassword(String password) {
        clearText(loginPage.getPassField());
        sendText(loginPage.getPassField(), password);
        return this;
    }

    public LoginController clickLogin(){
        click(loginPage.getLoginBtn());
        return this;
    }

    public LoginController verifError(String expected){
        if ("FAILED null".equals(expected)) {
            softAssert.assertEquals(getText(loginPage.getNullError()),
                    "Error: Username is required.");
        } else if ("FAILED Password Empty".equals(expected)) {
            softAssert.assertEquals(getText(loginPage.getPassEmpty()),
                    "Error: The password field is empty.");
        } else if ("FAILED Unknown Email".equals(expected)) {
            softAssert.assertEquals(getText(loginPage.getUnKnownEmail()),
                    "Unknown email address. Check again or try your username.");
        } else if ("FAILED Pass Incorrect".equals(expected)) {
            softAssert.assertEquals(getText(loginPage.getPasssIncorrect()),
                    ": The password you entered for the email address ");
        } else if ("PASSED".equals(expected)) {
            softAssert.assertFalse(
                    true);
        }
        return this;
    }


}
