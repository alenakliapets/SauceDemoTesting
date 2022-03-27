package wrappers;

import core.BrowserService;
import org.openqa.selenium.*;
import utils.Waits;

import java.util.List;

public class UIElement implements WebElement {

    private final BrowserService browserService;
    private final WebElement webElement;
    private Waits waits;

    public UIElement(BrowserService browserService, WebElement webElement){
        this.browserService = browserService;
        this.waits = browserService.getWaiters();
        this.webElement = webElement;
    }

    public UIElement(BrowserService browserService, By by) {
        this.browserService = browserService;
        this.waits = browserService.getWaiters();
        this.webElement = waits.presenceOfElementLocated(by);
    }

    @Override
    public void click() {
        try{webElement.click();}
        catch (ElementNotVisibleException elementNotVisibleException){
            ((JavascriptExecutor) browserService.getDriver()).
                    executeScript("arguments[0].scrollIntoView(true);", webElement);
            waits.waitForClickable(webElement);
            webElement.click();
        }
    }

    @Override
    public void submit() {
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        ((JavascriptExecutor) browserService.getDriver()).
                executeScript("arguments[0].scrollIntoView(true);", webElement);
        webElement.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        webElement.clear();
    }

    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return webElement.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String s) {
        return webElement.getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return webElement.getScreenshotAs(outputType);
    }

    public WebElement getParent (){
        return (WebElement) ((JavascriptExecutor) browserService).executeScript("return arguments[0].parentNode;", webElement);
    }
}

