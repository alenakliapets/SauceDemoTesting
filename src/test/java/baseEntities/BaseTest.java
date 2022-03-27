package baseEntities;

import core.BrowserService;
import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import utils.Listener;

@Listeners(Listener.class)
public class BaseTest {
    public BrowserService browserService;
    protected User correctUser;
    protected User lockedUser;

    @BeforeSuite
    public void prepareDats(){
        correctUser = User.builder()
                .username("standard_user")
                .password("secret_sauce")
                .build();
        lockedUser = User.builder()
                .username("locked_out_user")
                .password("secret_sauce")
                .build();
    }

    @BeforeTest
    public void startBrowser(){
        browserService = new BrowserService();
      //  browserService.getDriver().get(ReadProperties.getInstance().getURL());
    }

    @AfterMethod
    public void closeBrowser(){
        browserService.getDriver().quit();
        browserService = null;
    }
}
