package pages;

import baseEntities.BasePage;
import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import wrappers.Button;
import wrappers.UIElement;

import java.util.ArrayList;

public class ProductsPage extends BasePage {
    private final static String ENDPOINT = "/inventory.html";

    private final static By titleLabelByClass = By.className("title");
    private final static By menuButtonById = By.id("react-burger-menu-btn");
    private final static By menuListByClass = By.className("bm-menu");
    private final static By cartButtonByClass = By.className("shopping_cart_link");
    private final static By cartQuantityLabelByClass = By.className("shopping_cart_badge");
    private final static By filterSelectByClass = By.className("product_sort_container");
    private final static By firstProductButtonByPartialText = By.partialLinkText("Backpack");
    private final static By addFirstProductCartButtonById = By.id("add-to-cart-sauce-labs-backpack");
    private final static String addFirstProductCartButton =
            "//div[.='replace']/ancestor::div[@class='inventory_item_description']//button";
    private final static By photoFirstProductButtonByXpath =
            By.xpath("//*[@src = '/static/media/sauce-backpack-1200x1500.34e7aa42.jpg']");

    public ProductsPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browserService.getDriver().get(ReadProperties.getInstance().getURL() + ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getTitleLabel().isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }
    public UIElement getTitleLabel(){return new UIElement(browserService, titleLabelByClass);}
    public String  getTitleText(){return getTitleLabel().getText();}
    public Button getAddToCartButtonForProduct(String productName){
        return new Button(browserService, By.xpath(addFirstProductCartButton.replace("replace", productName)));}
    public UIElement getButtonMenu(){return new UIElement(browserService, menuButtonById);}
    public UIElement getMenuList(){return new UIElement(browserService, menuListByClass);}
    public UIElement getCart(){return new UIElement(browserService, cartButtonByClass);}
    public UIElement getCartQuantityLabel(){return new UIElement(browserService, cartQuantityLabelByClass);}
    public UIElement getFilter(){return new UIElement(browserService, filterSelectByClass);}
    public UIElement getFirstProduct(){return new UIElement(browserService, firstProductButtonByPartialText);}
    public UIElement getAddFirstProductCart(){return new UIElement(browserService, addFirstProductCartButtonById);}
    public UIElement getPhotoFirstProduct(){return new UIElement(browserService, photoFirstProductButtonByXpath);}

    public CartPage clickCartButton(){
        getCart().click(); return new CartPage(browserService, false);
    }
    public ProductsPage addItemToCart(String productName){
        getAddToCartButtonForProduct(productName).click();
        return this;
    }
    public ProductsPage addItemsToCart(ArrayList<String> itemsList){
        for (String item:itemsList) {
            addItemToCart(item);
        }
        return this;
    }
    public void clickMenuButton(){
        getButtonMenu().click();
    }
}

