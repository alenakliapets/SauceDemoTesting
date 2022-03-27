package pages;

import baseEntities.BasePage;
import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import wrappers.Button;
import wrappers.UIElement;

public class CartPage extends BasePage {
    private final static String ENDPOINT = "/cart.html";

    private final static By menuButtonById = By.id("react-burger-menu-btn");
    private final static By cartButtonByClass = By.className("shopping_cart_link");
    private final static By continueShoppingButtonById = By.id("continue-shopping");
    private final static By checkOutButtonById = By.id("checkout");
    private final static By purchaseInfoByClass = By.className("inventory_item_name");
    private final static By removePurchaseButtonById = By.id("remove-sauce-labs-backpack");
    private final static String cartItemRemoveButton =
            "//div[. = 'replace']/following::div[@class = 'item_pricebar']//button";
    private final static By cartQuantityIdentifier = By.className("cart_quantity");

    public CartPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browserService.getDriver().get(ReadProperties.getInstance().getURL()+ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getCheckOut().isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public UIElement getButtonMenu(){return new UIElement(browserService, menuButtonById);}
    public UIElement getCart(){return new UIElement(browserService, cartButtonByClass);}
    public UIElement getContinueShopping(){return new UIElement(browserService, continueShoppingButtonById);}
    public UIElement getCheckOut(){return new UIElement(browserService, checkOutButtonById);}
    public UIElement getPurchaseInfo(){return new UIElement(browserService, purchaseInfoByClass);}
    public UIElement getRemovePurchaseButton(){return new UIElement(browserService, removePurchaseButtonById);}
    public Button getRemoveItemButton(String productName)
    {return new Button(browserService, By.xpath(cartItemRemoveButton.replace("replace", productName)));}
public UIElement getCartQuantityIdentifier(){return new UIElement(browserService, cartQuantityIdentifier);}

    public CartPage clickRemoveButton(String productName){
        getRemoveItemButton(productName).click();
        return this;
    }
    public CheckOutPage clickCheckOutButton(){
        getCheckOut().click(); return new CheckOutPage(browserService, false);
    }

    public String displayQuantity(){return getCartQuantityIdentifier().getText();}
}

