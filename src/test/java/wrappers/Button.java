package wrappers;

import core.BrowserService;
import org.openqa.selenium.By;

public class Button {
    private final UIElement uiElement;

    public Button(BrowserService browserService, By by){
        this.uiElement = new UIElement(browserService, by);
    }

    public void click(){this.uiElement.click();}

    public void submit(){this.uiElement.submit();}

    public boolean isDisplayed(){return this.uiElement.isDisplayed();}
}
