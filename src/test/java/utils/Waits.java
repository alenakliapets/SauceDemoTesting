package utils;

import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waits {

    private WebDriverWait wait;

    public Waits(WebDriver driver){
        wait = new WebDriverWait(driver, ReadProperties.getInstance().getTimeOut());
    }

    public WebElement waitForVisibility(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement presenceOfElementLocated(By by){
        return  wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForVisibilityElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> waitForVisibilityAll(By by){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public Boolean waitForInvisibility(By by){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public Boolean waitForInvisibility(WebElement webElement){
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

}
