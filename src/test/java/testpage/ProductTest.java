package testpage;

import controller.pagecontroller.HomeController;
import controller.pagecontroller.LoginController;
import controller.pagecontroller.ProductController;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.BaseTest;

public class ProductTest extends BaseTest {

    private HomeController homeController;
    private ProductController productController;
    private LoginController loginController;

    String[] prodCode = {"88625","85197"};
    String[] qntProduct = {"3","2"};
    String[] prodName = {"PS5 Elden Ring (R3/English)",
                        "PS5 Hades (R3/English)"};
    String[] prodPrice = {"689,000","289,000"};

    @DataProvider(name = "Data Product")
    public Object[][] getDataProduct(){
        return new Object[][] {
                {prodCode[0],qntProduct[0]},
                {prodCode[1],qntProduct[1]},
        };
    }

    @DataProvider(name = "Data Assert")
    public Object[][] getDataAssert(){
        return new Object[][] {
                {prodName[0],prodPrice[0],qntProduct[0]},
                {prodName[1],prodPrice[1],qntProduct[1]}
        };
    }

    @Test(priority = 0)
    public void navLoginPage(){
        homeController = new HomeController(driver);
        homeController.toLoginPage();
    }

    @Parameters({"email","password"})
    @Test(priority = 1, dependsOnMethods = {"navLoginPage"})
    public void loginAccount(String email, String password){
        loginController = new LoginController(driver);
        loginController.fillEmail(email);
        loginController.fillPassword(password);
        loginController.loginBtn();
    }

    @Test(priority = 2)
    public void navToAllProduct() {
        homeController = new HomeController(driver);
        homeController.toHomePage();
        homeController.toAllProductPage();
    }

    @Test(priority = 3 ,dependsOnMethods = {"navToAllProduct"}, dataProvider = "Data Product")
    public void addProduct(String dataProduct, String dataQuantity) {
        productController = new ProductController(driver);
        productController.selectProduct(dataProduct);
        productController.selectQntyProduct(dataQuantity);
        productController.clickBtnCart();
    }

    @Test(priority = 4, dependsOnMethods = {"navToAllProduct","addProduct"}, dataProvider = "Data Assert")
    public void productAssert(String productName, String priceProduct, String productQuantity) {
        productController = new ProductController(driver);
        productController.shopBasket();
        productController.verifProduct(productName, priceProduct, productQuantity);
    }
}
