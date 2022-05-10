package testpage;

import controller.BaseController;
import controller.pagecontroller.HomeController;
import controller.pagecontroller.RegisterController;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.RegisterPage;
import test.BaseTest;


public class RegisterTest extends BaseTest {

    private HomeController homeController;
    private RegisterController registerController;


    //Sebelum ditest harus ganti email dummy
    String email = "test_auto298@yahoo.com";
    String password = "PassW0r.d78";
    String confirmPass = "PassW0r.d78";

    @DataProvider(name = "Data Register")
    public Object[][] getData(){
        return new Object[][] {
                {"","","","FAILED null"},
                {email,"","","FAILED null Password"},
               // {email, "test","test", null,"FAILED Week Pass"},
                {email, password, confirmPass, "PASSED"},
                {email, password, confirmPass, "FAILED Already Register"}
        };
    }

    @Test(priority = 0)
    @Parameters("environtment")
    @Description("Navigate to Register")
    public void navToUserPage() {
        homeController = new HomeController(driver);
        homeController.toRegisPage();
    }

    @Test(priority = 1, dataProvider = "Data Register" ,dependsOnMethods = {"navToUserPage"})
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
        registerController.clickRegisBtn();
        registerController.verifError(expected);
        homeController.toRegisPage();
    }
}
