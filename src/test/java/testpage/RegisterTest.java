package testpage;

import controller.pagecontroller.HomeController;
import controller.pagecontroller.RegisterController;
import jdk.jfr.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import java.util.Random;

public class RegisterTest extends BaseTest {

    private HomeController homeController;
    private RegisterController registerController;

    Random random = new Random();
    int number = random.nextInt(100) + 5;

    String email = "test_regis" +number+ "@yahoo.com";
    String password = "PassW0r.d78";
    String confirmPass = "PassW0r.d78";

    @DataProvider(name = "Data Register")
    public Object[][] getData(){
        return new Object[][] {
                {"","","","Failed : null email and password"},
                {email,"","","Failed : null Password"},
                {email, "test","test","Failed : Week Pass"},
                {email, password, confirmPass, "Passed : Registered"},
                {email, password, confirmPass, "Failed : Already Register"}
        };
    }

    @Test(priority = 0)
    @Description("Navigate to Register")
    public void navToUserPage() {
        homeController = new HomeController(driver);
        homeController.toRegisPage();
    }

    @Test(priority = 1,dependsOnMethods = {"navToUserPage"}, dataProvider = "Data Register")
    @Description("Register an Account")
    public void regisAccount(String email, String password, String confirmPass, String expected){
        registerController = new RegisterController(driver);
        registerController.selectFavGenre();
        registerController.selectFavConsole();
        registerController.selectHobAndIntrs();
        registerController.selectGender();
        registerController.fillEmail(email);
        registerController.fillPass(password);
        registerController.fillconfirmPass(confirmPass);
        registerController.registerBtn();
        registerController.regisAssertion(expected);
        homeController.toRegisPage();
    }
}
