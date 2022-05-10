package testpage;

import controller.pagecontroller.HomeController;
import controller.pagecontroller.ProductController;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;

public class ProductTest extends BaseTest {

    private HomeController homeController;
    private ProductController productController;

    @DataProvider(name = "Data Product")
    public Object[][] getDataProduct(){
        return new Object[][] {
                {"55346","3"},
                {"101859","2"}
        };
    }

    @DataProvider(name = "Data Assert")
    public Object[][] getDataAssert(){
        return new Object[][] {
                {"PS4 Dynasty Warriors 9 (R1/English)","375,000","3"},
                {"PS4 LEGO Harry Potter Collection (R2/English)","278,000","2"}
        };
    }

    @Test(priority = 0)
    public void navToAllProduct() {
        homeController = new HomeController(driver);
        homeController.toHomePage();
        homeController.toAllProductPage();
    }

    @Test(priority = 1 ,dependsOnMethods = {"navToAllProduct"}, dataProvider = "Data Product")
    public void addProduct(String dataProduct, String dataQuantity) {
        productController = new ProductController(driver);
        productController.selectProduct(dataProduct);
        productController.selectQntyProduct(dataQuantity);
        productController.clickBtnCart();
    }

    @Test(priority = 1, dependsOnMethods = {"navToAllProduct","addProduct"}, dataProvider = "Data Assert")
    public void productAssert(String productName, String priceProduct, String productQuantity) {
        productController = new ProductController(driver);
        productController.shopBasket();
        productController.verifProduct(productName, priceProduct, productQuantity);
    }
}
