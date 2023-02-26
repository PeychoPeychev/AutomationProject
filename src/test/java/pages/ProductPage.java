package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Collections;
import java.util.NoSuchElementException;

public class ProductPage extends BasePage {
    private final static String PRODUCT_ID = "add-to-cart-sauce-labs-";
    @FindBy(xpath = "//span[@class='title']")
    WebElement productsPageHeading;
    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement cartBadge;


    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void findMenu(){
        WebElement profilMenu = driver.findElement(By.className("bm-burger-button"));
        profilMenu.click();
        WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
        logoutLink.isDisplayed();
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(20))
                .ignoreAll(Collections.singleton(Collections.singleton(NoSuchElementException.class)));
        fluentWait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        WebElement profilMenuXBtn = driver.findElement(By.id("react-burger-cross-btn"));
        profilMenuXBtn.click();
        WebElement productsPageTitle = driver.findElement(By.xpath("//span[text()='Products']"));
        productsPageTitle.isDisplayed();
    }

    public void addItemToTheCart(String itemName) {
        WebElement itemToBeAdded = driver.findElement(By.id(PRODUCT_ID + itemName));
        itemToBeAdded.click();
    }

    public int getItemsInTheCart() {
        return Integer.parseInt(cartBadge.getText());
    }

    public void goToCheckOut(){
        WebElement shopingCart = driver.findElement(By.id("shopping_cart_container"));
        shopingCart.click();
    }

}
