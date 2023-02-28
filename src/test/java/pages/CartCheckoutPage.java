package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartCheckoutPage extends BasePage{

    @FindBy(css = "[data-test='checkout']")
    WebElement goTocheckout;

    public CartCheckoutPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToCheckoutInformation(){
        goTocheckout.click();
    }

}