package controller.pagecontroller;

import controller.BaseController;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.ProductPage;

public class ProductController extends BaseController {


    ProductPage productPage = new ProductPage();

    public ProductController(WebDriver driver) {
        super(driver);
    }

    public ProductController selectProduct(String dataProduct){
        mouseHover(productPage.getPickProduct(dataProduct));
        click(productPage.getPickProduct(dataProduct));
        return this;
    }

    public ProductController selectQntyProduct(String dataQuantity){
        click(productPage.getQuantityProduct());
        clearText(productPage.getQuantityProduct());
        sendText(productPage.getQuantityProduct(),dataQuantity);
        return this;
    }

    public ProductController clickBtnCart(){
        click(productPage.getAddToCartBtn());
        return this;
    }

    public ProductController shopBasket(){
        click(productPage.getShopBasketBtn());
        return this;
    }

    public ProductController verifProduct(String productName, String priceProduct, String productQuantity){
        Assert.assertTrue(getText(productPage.getProductName(productName)).equals(productName));
        Assert.assertTrue(getText(productPage.getPriceTag(priceProduct)).equals("Rp"+priceProduct+""));
        Assert.assertEquals(waitVisibility(productPage.getQuantityPrduct(productQuantity)).getAttribute("value"),productQuantity);
        return this;
    }
}
