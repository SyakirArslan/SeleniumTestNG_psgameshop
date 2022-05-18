package testpage;

import controller.pagecontroller.HomeController;
import controller.pagecontroller.RegisterController;
import jdk.jfr.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.BaseTest;


public class RegisterTest extends BaseTest {

    private HomeController homeController;
    private RegisterController registerController;

    //Sebelum ditest harus ganti email dummy
    String email = "test_auto23b8@yahoo.com";
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
