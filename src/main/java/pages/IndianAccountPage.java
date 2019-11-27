package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndianAccountPage {
    public WebDriver driver;
    private String categoryName;
    private By categoryPath;

    public IndianAccountPage(WebDriver driver) {
         this.driver = driver;
         PageFactory.initElements(driver, this);
    }

    public void clickCategory () {
        driver.findElement(categoryPath).click();
        System.out.println(categoryPath);
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        this.categoryPath = By.xpath("//a[contains(text(),'" + this.categoryName + "')]");
    }
}