package features.stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;



public class Login_Portal_Steps extends Base_PO {

    private WebDriver driver = getDriver();
    @Given("I access the webdriver university login-portal page")
    public void i_access_the_webdriver_university_login_portal_page() {
        navitageTo_URL("https://webdriveruniversity.com/Login-Portal/index.html");
    }
    @When("I enter a Username of {word}")
    public void i_enter_ausername(String text) {
        sendKeys(By.id("text"), text);
    }
    @And("I enter a Password of {word}")
    public void i_enter_a_password(String password) {
        sendKeys(By.id("password"), password);
    }

    @And("I press the login button")
    public void i_press_the_login_button(){

        //driver.findElement(By.id("login-button")).click();
        waitForWebElementAndClick(By.id("login-button"));
    }

    @Then("I should be presented with a login popup of {}")
    public void i_should_be_presented_login_popup(String loginMessage) {
        String actualResult = driver.switchTo().alert().getText();
     Assert.assertEquals(actualResult,loginMessage);
    }

    @And("I press the OK button on the alert box")
    public void i_press_the_ok_button_on_the_alert_box() {
        driver.switchTo().alert().accept();

    }
}
