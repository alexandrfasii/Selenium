package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndianLoginPage {
    public WebDriver driver;

    public IndianLoginPage (WebDriver driver) {
         this.driver = driver;
         PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    @CacheLookup
    WebElement email;

    @FindBy(xpath = "//input[@id='input-password']")
    @CacheLookup
    WebElement password;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    @CacheLookup
    WebElement loginBtn;

    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    @CacheLookup
    WebElement myAccountDropDown;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(text(),'Logout')]")
    @CacheLookup
    WebElement logoutBtn;

    public void loginWithValidCredentials() {
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        driver.manage().window().maximize();
        setEmail("afasii@gmail.com");
        setPassword("0123");
        clickLogin();
    }

    public void setEmail(String email) {
        this.email.clear();
        this.email.sendKeys(email);
    }

    public void setPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void clickLogin() {
        loginBtn.click();
    }

    public void clickMyAccountDropDown() throws Exception {
        myAccountDropDown.click();
        Thread.sleep(1000);
    }

    public void clickLogout() {
        logoutBtn.click();
    }
}
