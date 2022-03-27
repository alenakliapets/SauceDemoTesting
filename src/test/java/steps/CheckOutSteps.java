package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import pages.CartPage;
import pages.CheckOutCompletionPage;

public class CheckOutSteps extends BaseStep {
    public CheckOutSteps(BrowserService browserService) {
        super(browserService);
    }

    public CheckOutCompletionPage completeOrder(){
        return new CartPage(browserService, false).clickCheckOutButton()
                .setFirstName("fff")
                .setLastName("rrr")
                .setPostalCode("3423")
                .clickContinueButton()
                .clickFinishButton();
    }
}
