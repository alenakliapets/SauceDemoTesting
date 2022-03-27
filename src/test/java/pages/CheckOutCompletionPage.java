package pages;

import baseEntities.BasePage;
import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import wrappers.UIElement;

public class CheckOutCompletionPage extends BasePage {

    private final static String ENDPOINT = "checkout-complete.html";
    private final static By checkOutCompletionBy = By.className("complete-header");

    public CheckOutCompletionPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browserService.getDriver().get(ReadProperties.getInstance().getURL()+ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getCompletionTitle().isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }
    public UIElement getCompletionTitle(){return new UIElement(browserService, checkOutCompletionBy);}
    public String getCompletionMessage(){
        return getCompletionTitle().getText();
}
}
