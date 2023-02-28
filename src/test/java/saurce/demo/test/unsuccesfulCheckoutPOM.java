package saurce.demo.test;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class unsuccesfulCheckoutPOM extends TestUtil {
    @Test
    public void checkOutInformation(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("problem_user", "secret_sauce");
        productPage.addItemToTheCart("backpack");
        productPage.addItemToTheCart("bike-light");
        productPage.goToCheckOut();
        CartCheckoutPage cartCheckoutPage = new CartCheckoutPage(driver);
        cartCheckoutPage.goToCheckoutInformation();
        ProfilInformationPage profilInformationPage = new ProfilInformationPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = profilInformationPage.userInfromation("Peycho","Peycho","1111");
        profilInformationPage.unsuccesfulCheckout();

    }
}
