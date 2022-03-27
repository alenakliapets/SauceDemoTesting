package pages;

import baseEntities.BasePage;
import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import wrappers.Button;
import wrappers.Input;
import wrappers.UIElement;

public class LoginPage extends BasePage {

    private final static String ENDPOINT = "/";

    //селекторы
    private final static By userNameInputBy = By.id("user-name");
    private final static By passwordInputBy = By.id("password");
    private final static By loginButtonBy = By.id("login-button");
    private final static By errorLabelByTag = By.tagName("h3");

    //конструктор

    public LoginPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browserService.getDriver().get(ReadProperties.getInstance().getURL() + ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        try{
            return new UIElement(browserService, loginButtonBy).isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }
    //геттеры
    public Input getUserNameInput(){return new Input(browserService, userNameInputBy);}
    public Input getPasswordInput(){return new Input (browserService, passwordInputBy);}
    public Button getLoginButton(){return new Button (browserService, loginButtonBy);}
    public UIElement getErrorLabel(){return new UIElement (browserService, errorLabelByTag);}

    public ProductsPage successLoginBtnClick(){
        loginBtnClick();
        return new ProductsPage(browserService, false);
    }
    public LoginPage loginBtnClick(){
        getLoginButton().click();
        return this;
    }
    public LoginPage setUserName(String userName){
        getUserNameInput().sendKeys(userName);
        return this;
    }
    public LoginPage setPassword(String password){
        getPasswordInput().sendKeys(password);
        return this;
    }
}

