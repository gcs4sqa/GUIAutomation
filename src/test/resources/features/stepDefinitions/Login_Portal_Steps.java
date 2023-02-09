package features.stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Base_PO;
import pageObjects.Login_PO;


public class Login_Portal_Steps extends Base_PO {

    private final Login_PO loginPo;
    public Login_Portal_Steps(Login_PO loginPo){
        this.loginPo = loginPo;
    }
    @Given("I access the webdriver university login-portal page")
    public void i_access_the_webdriver_university_login_portal_page() {
        loginPo.navigateTo_WebDriverUniversity_login_page();
    }
    @When("I enter a Username of {word}")
    public void i_enter_ausername(String text) {
        loginPo.setUsername(text);
    }
    @And("I enter a Password of {word}")
    public void i_enter_a_password(String password) {
        loginPo.setPassword(password);
    }

    @And("I press the login button")
    public void i_press_the_login_button(){
        loginPo.clickOn_Login_button();
    }

    @Then("I should be presented with a login popup of {}")
    public void i_should_be_presented_login_popup(String loginMessage) {
        loginPo.waitForAlert_And_validateText(loginMessage);
    }

    @And("I press the OK button on the alert box")
    public void i_press_the_ok_button_on_the_alert_box() {
        loginPo.waitForAlert_And_clickOK();

    }
}
