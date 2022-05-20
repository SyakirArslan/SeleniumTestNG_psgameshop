package page;

import org.openqa.selenium.By;

public class ProductPage {



    protected By quantityProduct = By.xpath("//input[@type=\"number\" and @class=\"input-text qty text\"]");
    protected By addToCartBtn = By.xpath("//button[text()='Add to cart']");
    protected By shopBasketBtn = By.className("icon-shopping-basket");

    public By getPickProduct(String dataProduct) {
        return By.xpath("//a[@data-prod=\"" +dataProduct+ "\" and @href=\"#quick-view\"]");
    }

    public By getQuantityProduct() {
        return quantityProduct;
    }

    public By getAddToCartBtn() {
        return addToCartBtn;
    }

    public By getShopBasketBtn() {
        return shopBasketBtn;
    }

    //Assert
    public By getProductName(String productName) {
        return By.xpath("//a[contains(text(),'"+productName+"')]");
    }
    public By getPriceTag(String priceProduct) {
        return By.xpath("(//bdi[text()='"+priceProduct+"' and span='Rp'])[2]");
    }
    public By getQuantityPrduct(String productQuantity){
        return By.xpath("//input[@type='number' and @value='"+productQuantity+"']");
    }

}
