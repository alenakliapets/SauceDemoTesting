package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.Waits;
import java.util.concurrent.TimeUnit;

public class BrowserService {
    private WebDriver driver;
    private Waits wait;

    public BrowserService(){
        switch (ReadProperties.getInstance().getBrowserName().toLowerCase()) {
            case "chrome" -> {
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            }
            case "firefox" -> {
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                driver = new FirefoxDriver();
            }
            case "safari" -> {
                WebDriverManager.getInstance(DriverManagerType.SAFARI).setup();
                driver = new SafariDriver();
            }
            default -> throw new AssertionError("Данный браузер не поддерживается");
        }
        wait = new Waits(driver);

    }
    public WebDriver getDriver() {
        return driver;
    }

    public Waits getWaiters(){
        return wait;
    }
    public void sleep(long millis){
        try{
            Thread.sleep(millis);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
