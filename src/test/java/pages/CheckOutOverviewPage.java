package pages;

import baseEntities.BasePage;
import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import wrappers.Button;
import wrappers.UIElement;

import java.util.Locale;

public class CheckOutOverviewPage extends BasePage {

    private final static String ENDPOINT = "checkout-step-two.html";
    private final static By checkOutOverviewTitleBy = By.xpath("//span[@class = 'title']");
    private final static By checkOutFinishBy = By.id("finish");

    public CheckOutOverviewPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browserService.getDriver().get(ReadProperties.getInstance().getURL()+ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getOverviewMessage().isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public Button getFinishButton(){return new Button(browserService, checkOutFinishBy);}
    public UIElement getOverviewMessage(){return new UIElement(browserService, checkOutOverviewTitleBy);}
    public String displayOverviewMessage(){return getOverviewMessage().getText().toUpperCase(Locale.ROOT);}

    public CheckOutCompletionPage clickFinishButton(){
        getFinishButton().click();
        return new CheckOutCompletionPage(browserService, false);
    }
}
