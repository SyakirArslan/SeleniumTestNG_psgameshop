package controller.pagecontroller;

import controller.BaseController;
import org.openqa.selenium.WebDriver;
import page.HomePage;

public class HomeController extends BaseController {

    HomePage homePage = new HomePage();

    public HomeController(WebDriver driver){
        super(driver);
    }

    public HomeController toLoginPage() {
        click(homePage.getLoginBtn());
        return this;
    }

    public HomeController toRegisPage() {
        click(homePage.getRegisBtn());
        return this;
    }

    public HomeController toHomePage() {
        click(homePage.getHomePage());
        return this;
    }

    public HomeController toAllProductPage() {
        click(homePage.getAllProductBtn());
        return this;
    }
}
