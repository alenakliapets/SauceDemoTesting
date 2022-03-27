package pages;

import baseEntities.BasePage;
import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import wrappers.Button;
import wrappers.Input;
import wrappers.UIElement;

public class CheckOutPage extends BasePage {

    private final static String ENDPOINT = "checkout-step-one.html";
    private final static By menuButtonById = By.id("react-burger-menu-btn");
    private final static By cartButtonByClass = By.className("shopping_cart_link");
    private final static By firstNameInputById = By.id("first-name");
    private final static By lastNameInputById = By.id("last-name");
    private final static By postalCodeInputById = By.id("postal-code");
    private final static By cancelButtonById = By.id("cancel");
    private final static By continueButtonById = By.id("continue");
    private final static By errorLabelByTag = By.tagName("h3");


    public CheckOutPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browserService.getDriver().get(ReadProperties.getInstance().getURL()+ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getFirstName().isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public UIElement getButtonMenu(){return new UIElement(browserService, menuButtonById);}
    public UIElement getCart(){return new UIElement(browserService, cartButtonByClass);}
    public Input getFirstName(){return new Input(browserService, firstNameInputById);}
    public Input getLastName(){return new Input(browserService, lastNameInputById);}
    public Input getPostalCode(){return new Input(browserService, postalCodeInputById);}
    public Button getCancelButton(){return new Button(browserService, cancelButtonById);}
    public Button getContinueButton(){return new Button(browserService, continueButtonById);}
    public UIElement getErrorLabel(){return new UIElement(browserService, errorLabelByTag);}

    public CheckOutPage setFirstName(String text){
        getFirstName().sendKeys(text);
        return this;
    }
    public CheckOutPage setLastName(String text){
        getLastName().sendKeys(text); return this;
    }
    public CheckOutPage setPostalCode(String text){
        getPostalCode().sendKeys(text); return this;
    }
    public CheckOutOverviewPage clickContinueButton(){
        getContinueButton().click(); return new CheckOutOverviewPage(browserService, false);
    }
    public void clickCancel(){
        getCancelButton().click();
    }
}

