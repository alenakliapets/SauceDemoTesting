package wrappers;

import core.BrowserService;
import org.openqa.selenium.By;

public class Input {
    private final UIElement uiElement;

    public Input(BrowserService browserService, By by){
        this.uiElement = new UIElement(browserService, by);
    }

    public void sendKeys(CharSequence... charSequences){
        uiElement.sendKeys(charSequences);
    }

    public boolean isDisplayed(){return this.uiElement.isDisplayed();}
}
