package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductPage extends BasePage {
    private final static String PRODUCT_ID = "add-to-cart-sauce-labs-";
    @FindBy(xpath = "//span[@class='title']")
    WebElement productsPageHeading;
    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement cartBadge;
    @FindBy(className = "bm-burger-button")
    WebElement profilMenu;
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;
    @FindBy(id = "react-burger-cross-btn")
    WebElement profilMenuXBtn;
    @FindBy(xpath = "//span[text()='Products']")
    WebElement productsPageTitle;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void findMenu(){
        profilMenu.click();
        logoutLink.isDisplayed();
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(10));
        fluentWait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        Assert.assertTrue(logoutLink.isDisplayed());
        profilMenuXBtn.click();
        productsPageTitle.isDisplayed();
        Assert.assertEquals(productsPageTitle.getText(), "Products");
    }

    public void addItemToTheCart(String itemName) {
        WebElement itemToBeAdded = driver.findElement(By.id(PRODUCT_ID + itemName));
        itemToBeAdded.click();
    }

    public int getItemsInTheCart() {
        return Integer.parseInt(cartBadge.getText());
    }

    public void goToCheckOut(){
        cartBadge.click();
    }

}
