package saurce.demo.test;

import base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class successfulLogin extends TestUtil {
    @Test(dataProvider = "correctUsers")
    public void succesfulLoginSauce(String userName, String password) throws InstantiationException {

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

        WebElement profilMenu = driver.findElement(By.className("bm-burger-button"));
        WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
        WebElement profilMenuXBtn = driver.findElement(By.id("react-burger-cross-btn"));
        WebElement productsPageTitle = driver.findElement(By.xpath("//span[text()='Products']"));
        WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));

        profilMenu.click();

        wait10.until(ExpectedConditions.visibilityOf(logoutLink));
        Assert.assertTrue(logoutLink.isDisplayed(), "Logout link was not displayed");
        profilMenuXBtn.click();
        Assert.assertTrue(productsPageTitle.isDisplayed());
        Assert.assertEquals(productsPageTitle.getText(), "PRODUCTS");
    }
        @DataProvider(name = "correctUsers")
        public static Object[][] readUsersFromCsv () {
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

