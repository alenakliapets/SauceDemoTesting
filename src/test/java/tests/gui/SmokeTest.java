package tests.gui;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import steps.LoginSteps;

import java.util.ArrayList;

public class SmokeTest extends BaseTest {
    @Test
    public void criticalPathTest(){
        CheckOutCompletionPage checkOutCompletionPage = new LoginPage(browserService, true)
                .setUserName(correctUser.getUsername())
                .setPassword(lockedUser.getPassword())
                .successLoginBtnClick()
                .addItemToCart("Sauce Labs Backpack")
                .clickCartButton()
                .clickCheckOutButton()
                .setFirstName("fff")
                .setLastName("rrr")
                .setPostalCode("3423")
                .clickContinueButton()
                .clickFinishButton();

        Assert.assertEquals(checkOutCompletionPage.getCompletionMessage().trim(),
                "THANK YOU FOR YOUR ORDER");
    }

    //Test
    @Test
    public void criticalPathStepsTest(){
        CheckOutCompletionPage checkOutCompletionPage = new LoginSteps(browserService)
                .successLogin(correctUser)
                .addItemToCart("Sauce Labs Backpack")
                .moveToCart()
                .completeOrder();
        Assert.assertEquals(checkOutCompletionPage.getCompletionMessage().trim(),
                "THANK YOU FOR YOUR ORDER");
    }

    @Test
    public void loginFailedTest(){
        LoginPage loginPage = new LoginPage(browserService, true)
                .setUserName(lockedUser.getUsername())
                .setPassword(lockedUser.getPassword())
                .loginBtnClick();
        Assert.assertEquals(loginPage.getErrorLabel().getText().trim(),
                "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void removeItemFromCartTest(){
        ArrayList <String> itemList = new ArrayList<>();
        itemList.add("Sauce Labs Backpack");
        itemList.add("Sauce Labs Bolt T-Shirt");
        CartPage cartPage = new LoginPage(browserService, true)
                .setUserName(correctUser.getUsername())
                .setPassword(correctUser.getPassword())
                .successLoginBtnClick()
                .addItemsToCart(itemList)
                .clickCartButton()
                .clickRemoveButton(itemList.get(0));

        Assert.assertEquals(Integer.parseInt(cartPage.displayQuantity()), 1);
    }

    @Test
    public void removeItemFromCartStepsTest(){
        ArrayList <String> itemList = new ArrayList<>();
        itemList.add("Sauce Labs Backpack");
        itemList.add("Sauce Labs Bolt T-Shirt");

        CartPage cartPage = new LoginSteps(browserService)
                .successLogin(correctUser)
                .addItemsToCart(itemList)
                .moveToCart()
                .getShoppingCartPage()
                .clickRemoveButton(itemList.get(1));
        Assert.assertEquals(Integer.parseInt(cartPage.displayQuantity()), 1);
    }
}
