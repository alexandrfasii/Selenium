package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndianProductPage {
    public WebDriver driver;

    public IndianProductPage(WebDriver driver) {
         this.driver = driver;
         PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//button[@id='button-cart']")
    @CacheLookup
    WebElement addToCartBtn;

    @FindBy (xpath = "//div[@class='alert alert-success alert-dismissible']")
    @CacheLookup
    WebElement alertSuccessMessage;

    @FindBy (xpath = "//span[contains(text(),'Shopping Cart')]")
    @CacheLookup
    WebElement shoppingCartLink;

    public void clickAddToCart () {
        addToCartBtn.click();
    }

    public String getMessage() {
        return alertSuccessMessage.getText().replace("×", "").trim();
    }

    public void clickShoppingCartLink() {
        shoppingCartLink.click();
    }
}
