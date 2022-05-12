package testpage;

import controller.pagecontroller.HomeController;
import controller.pagecontroller.ProductController;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;

public class ProductTest extends BaseTest {

    private HomeController homeController;
    private ProductController productController;

    String[] prodCode = {"105554","90505"};
    String[] QntProduct = {"3","2"};
    String[] prodName = {"PS5 Autobahn Police Simulator 3 (R2/English) 31 May 22",
                        "PS5 HotWheels / Hot Wheels Unleashed (R3/English)"};
    String[] prodPrice = {"359,000","428,000"};

    @DataProvider(name = "Data Product")
    public Object[][] getDataProduct(){
        return new Object[][] {
                {prodCode[0],QntProduct[0]},
                {prodCode[1],QntProduct[1]},

        };
    }

    @DataProvider(name = "Data Assert")
    public Object[][] getDataAssert(){
        return new Object[][] {
                {prodName[0],prodPrice[0],QntProduct[0]},
                {prodName[1],prodPrice[1],QntProduct[1]}
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
