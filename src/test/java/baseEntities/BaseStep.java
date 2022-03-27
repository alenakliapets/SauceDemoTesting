package baseEntities;

import core.BrowserService;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class BaseStep {

    protected BrowserService browserService;

    public BaseStep(BrowserService browserService){
        this.browserService = browserService;
    }

    public ProductsPage getProductsPage(){
        return new ProductsPage(browserService, false);
    }

    public LoginPage getLoginPage(){
        return new LoginPage(browserService, false);
    }

    public CartPage getShoppingCartPage(){
        return new CartPage(browserService, false);
    }
}
