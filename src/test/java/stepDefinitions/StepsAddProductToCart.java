package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class StepsAddProductToCart {
    private WebDriver driver;
    private IndianLoginPage indianLoginPage;
    private IndianAccountPage indianAccountPage;
    private IndianCategoryPage indianCategoryPage;
    private IndianProductPage indianProductPage;
    private IndianShoppingCartPage indianShoppingCartPage;

    @Before
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\projects\\testCucumberEndava\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("^a user logs in with valid credentials$")
    public void aUserLogsInWithValidCredentials() {
        indianLoginPage = new IndianLoginPage(driver);
        indianLoginPage.loginWithValidCredentials();
    }

    @And("^the '(.*)' page is displayed$")
    public void theTitlePageIsDisplayed(String title) {
        Assert.assertEquals(title, driver.getTitle());
        System.out.println(driver.getTitle());
    }

    @When("^the user clicks on the '(.*)' category$")
    public void theUserClicksOnTheTabletsCategory(String categoryName) {
        indianAccountPage = new IndianAccountPage(driver);
        indianAccountPage.setCategoryName(categoryName);
        indianAccountPage.clickCategory();
    }

    @When("^the user clicks on the '(.*)' product$")
    public void theUserClicksOnTheProduct(String productName) {
        indianCategoryPage = new IndianCategoryPage(driver);
        indianCategoryPage.setProductName(productName);
        indianCategoryPage.clickProduct();
    }

    @When("^the user clicks on the 'Add to cart' button$")
    public void theUserClicksOnTheAddToCartButton() throws InterruptedException {
        indianProductPage = new IndianProductPage(driver);
        indianProductPage.clickAddToCart();
        Thread.sleep(2000);
    }

    @Then("^the following message is displayed: '(.*)'$")
    public void theFollowingMessageIsDisplayed(String message) {
        Assert.assertEquals(message, indianProductPage.getMessage());
    }

    @When("^the user clicks on the 'Shopping Cart' button$")
    public void theUserClicksOnTheShoppingCartButton() {
        indianProductPage.clickShoppingCartLink();
    }

    @And("^the '(.*)' is displayed in the shopping cart products table$")
    public void theProductIsDisplayedInTheShoppingCartProductsTable(String productName) {
        indianShoppingCartPage = new IndianShoppingCartPage(driver);
        indianShoppingCartPage.setProductName(productName);
        Assert.assertEquals(productName, indianShoppingCartPage.productDisplayed());
    }

    @When("^the user clicks on the 'Delete' button$")
    public void theUserClicksOnTheDeleteButton() throws Exception {
        indianShoppingCartPage.clickDelete();
    }

    @And("^clicks on the 'Cart Total' button$")
    public void clicksOnTheCartTotalButton() throws Exception {
        indianShoppingCartPage.clickCartTotal();
    }

    @Then("^the '(.*)' message is displayed$")
    public void theMessageIsDisplayed(String message) {
        Assert.assertEquals(message, indianShoppingCartPage.cartIsEmptyMessage());
    }

    @And("^the Chrome Browser closes$")
    public void theChromeBrowserCloses() {
        driver.close();
    }
}
