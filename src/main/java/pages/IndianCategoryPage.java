package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class IndianCategoryPage {
    public WebDriver driver;
    private String productName;
    private By productPath;

    public IndianCategoryPage(WebDriver driver) {
         this.driver = driver;
         PageFactory.initElements(driver, this);
    }

    public void clickProduct () {
        driver.findElement(productPath).click();
        System.out.println(productPath);
    }


    public void setProductName(String productName) {
        this.productName = productName;
        this.productPath = By.xpath("//div[@class='caption']//a[contains(text(),'" + this.productName + "')]");
    }
}
