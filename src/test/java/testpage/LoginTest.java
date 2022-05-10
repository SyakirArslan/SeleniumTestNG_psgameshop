package testpage;

import controller.pagecontroller.HomeController;
import controller.pagecontroller.LoginController;
import jdk.jfr.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.BaseTest;

public class LoginTest extends BaseTest {

    private HomeController homeController;
    private LoginController loginController;

    String email = "silalet121@3dinews.com";
    String password = "SyakirAlvar0";

    @DataProvider(name = "credentials")
    public Object[][] getData(){
        return new Object[][] {
                {"", "","FAILED null"},
                {email, "", "FAILED Password Empty"},
                {"email@yahoo.com", "iasais86sa", "FAILED Unknown Email" },
                {email, "iasais86sa", "FAILED Pass Incorrect"},
                {email, password, "PASSED"}
        };
    }

    @Test(priority = 0)
    @Parameters("environment")
    @Description("Navigate to Login Page")
    public void navToUserPage() {
        homeController = new HomeController(driver);
        homeController.toLoginPage();
    }

    @Test(priority = 1, dataProvider = "credentials", dependsOnMethods = {"navToUserPage"})
    @Description("Login an Account")
    public void LoginAccount(String email, String password, String expected){
        loginController = new LoginController(driver);
        loginController.fillEmail(email);
        loginController.fillPassword(password);
        loginController.clickLogin();
        loginController.verifError(expected);
        homeController.toLoginPage();

    }
}
