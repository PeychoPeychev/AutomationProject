package saurce.demo.test;

import base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class addProductPOM extends TestUtil {

    @Test
    public void addItemToTheCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("problem_user", "secret_sauce");
        productPage.addItemToTheCart("backpack");
        productPage.addItemToTheCart("bike-light");

        Assert.assertEquals(productPage.getItemsInTheCart(),2);

        productPage.goToCheckOut();
    }


}