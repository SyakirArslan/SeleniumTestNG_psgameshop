package page;

import org.openqa.selenium.By;

public class ProductPage {



    protected By quantityProduct = By.xpath("//input[@type=\"number\" and @class=\"input-text qty text\"]");
    protected By addToCartBtn = By.xpath("//button[text()='Add to cart']");

    //Assert
//    protected By productName = By.xpath("//a[contains(text(),'Travel Bag The Legend Of Zelda (Hyrule)')]");
//    protected By priceTag = By.xpath("(//bdi[text()='99,000'])[2]");
//    protected By quantityPrduct = By.xpath("//input[@type='number' and @value='2']");

    protected By shopBasketBtn = By.className("icon-shopping-basket");

    public By getPickProduct(String dataProduct) {
       // By pickProduct = By.xpath("//a[@data-prod=\"90434\" and @href=\"#quick-view\"]");
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
