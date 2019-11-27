package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndianShoppingCartPage {
    public WebDriver driver;
    private String productName;
    private By productPath;

    public IndianShoppingCartPage(WebDriver driver) {
         this.driver = driver;
         PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//i[@class='fa fa-times-circle']")
    @CacheLookup
    WebElement deleteBtn;

    @FindBy (xpath = "//span[@id='cart-total']")
    @CacheLookup
    WebElement cartTotalBtn;

    public void clickDelete() throws Exception {
        deleteBtn.click();
        Thread.sleep(1500);
    }

    public void clickCartTotal() throws Exception {
        cartTotalBtn.click();
        Thread.sleep(1500);
    }

    public String cartIsEmptyMessage() {
        return driver.findElement(By.xpath("//p[@class='text-center']")).getText().trim();
    }

    public By getProductPath() {
        return productPath;
    }

    public void setProductName(String productName) {
        this.productName = productName;
        this.productPath = By.xpath("//table[@class='table table-bordered']//a[contains(text(),'"+ this.productName + "')]");
    }

    public String productDisplayed() {
        return driver.findElement(productPath).getText();
    }
}
