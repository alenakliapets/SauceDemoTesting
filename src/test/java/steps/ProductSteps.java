package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import pages.ProductsPage;

import java.util.ArrayList;

public class ProductSteps extends BaseStep {
    public ProductSteps(BrowserService browserService) {
        super(browserService);
    }

    public ProductSteps addItemToCart(String productName){
      new ProductsPage(browserService, false).getAddToCartButtonForProduct(productName).click();
        return this;
    }
    public ProductSteps addItemsToCart(ArrayList<String> itemsList){
        for (String item:itemsList) {
            addItemToCart(item);
        }
        return this;
    }
    public CheckOutSteps moveToCart(){
        new ProductsPage(browserService, false).clickCartButton();
        return new CheckOutSteps(browserService);
    }
}
