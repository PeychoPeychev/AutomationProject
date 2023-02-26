package saurce.demo.test;

import base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class successfulLoginPOM extends TestUtil {
    @Test(dataProvider = "correctUsers")
    public void succesfulLogin(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login(userName, password);
        productPage.findMenu();
    }

    @DataProvider(name = "correctUsers")
    public static Object[][] readUsersFromCsv() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/correctUsers.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObj = new Object[csvData.size()][1];
            for (int i = 0; i < csvData.size(); i++) {
                csvDataObj[i] = csvData.get(i);
            }
            return csvDataObj;
        } catch (IOException e) {
            System.out.println("Not Possible to find CSV!");
            return null;
        } catch (CsvException e) {
            return null;
        }
    }
}
