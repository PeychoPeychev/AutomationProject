package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends BasePage{

    @FindBy(id ="finish")
    WebElement finishbtn;
    public CheckoutOverviewPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void finishCheckout(){
        finishbtn.click();
    }

}
