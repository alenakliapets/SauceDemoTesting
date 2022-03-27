package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import models.User;
import pages.LoginPage;

public class LoginSteps extends BaseStep {

    public LoginSteps(BrowserService browserService) {
        super(browserService);
    }

    public ProductSteps successLogin(User user){
        new LoginPage(browserService, true)
                .setUserName(user.getUsername())
                .setPassword(user.getPassword())
                .successLoginBtnClick();
        return new ProductSteps(browserService);
    }
    public LoginSteps incorrectLogin(User user){
        new LoginPage(browserService, true)
                .setUserName(user.getUsername())
                .setPassword(user.getPassword())
                .successLoginBtnClick();
        return this;
    }
}
