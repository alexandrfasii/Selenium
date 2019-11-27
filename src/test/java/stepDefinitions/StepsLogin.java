package stepDefinitions;

import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.IndianLoginPage;

public class StepsLogin {
    private WebDriver driver;
    private IndianLoginPage indianLoginPage;

    @Given("^a User launches Chrome Browser$")
    public void a_User_launches_Chrome_Browser() {
        System.setProperty("webdriver.chrome.driver", "C:\\projects\\testCucumberEndava\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        indianLoginPage = new IndianLoginPage(driver);
    }

    @When("^the User opens the following URL: (.*)$")
    public void the_User_opens_the_following_URL(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("^enters Email as '(.*)' and Password as '(.*)'$")
    public void enters_Email_as_and_Password_as(String email, String password) {
        indianLoginPage.setEmail(email);
        indianLoginPage.setPassword(password);
    }

    @When("^clicks on the Login button$")
    public void clicks_on_the_Login_button() {
        indianLoginPage.clickLogin();
    }

    @Then("^the Page Title should be (.*)$")
    public void the_Page_Title_should_be(String title) {
        Assert.assertEquals(title, driver.getTitle());
        System.out.println(driver.getTitle());
    }

    @When("^the User clicks on the Log Out link$")
    public void the_User_clicks_on_th_Log_Out_link() throws Exception {
        indianLoginPage.clickMyAccountDropDown();
        indianLoginPage.clickLogout();
        Thread.sleep(3000);
    }

    @Then("^the Page Title is (.*)$")
    public void the_Page_Is(String title) {
        Assert.assertEquals(title, driver.getTitle());
        System.out.println(driver.getTitle());
    }

    @Then("^close Browser$")
    public void close_Browser() {
        driver.quit();
    }

}
