package saurce.demo.test;

import base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class unSuccesfulLogin extends TestUtil {
    @Test(dataProvider = "wrongUsers")
    public void unSuccesfulLogin(String userName, String password) {

        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement paswordInput = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));


        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys(userName);
        paswordInput.click();
        paswordInput.clear();
        paswordInput.sendKeys(password);
        loginBtn.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals(errorMessage.getText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @DataProvider(name = "wrongUsers")
    public static Object[][] readUsersFromCsv() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/wrongUsers.csv"));
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
