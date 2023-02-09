package features.stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Base_PO;
import pageObjects.Contact_us_PO;


public class Contact_Us_Steps extends Base_PO {

    private final Contact_us_PO contact_us_po;

    public Contact_Us_Steps(Contact_us_PO contact_us_po) {
        this.contact_us_po = contact_us_po;
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        contact_us_po.navigateTo_WebDriverUniversity_contact_Us_page();

    }
    @When("I enter a first name of {}")
    public void i_enter_a_first_name(String firstname) {
        if (firstname.equals("unique")){
            firstname = "AutoFN" + generateRandomNumber(5);
            System.out.println(firstname);
        }
        //sendKeys(By.xpath("//input[@name='first_name']"), firstname);
        contact_us_po.setFirstName_TextField(firstname);

    }
    @And("I enter a last name of {}")
    public void i_enter_a_last_name(String lastname) {
        if (lastname.equals("unique")){
            lastname = "AutoLN" + generateRandomNumber(5);
        }
        //sendKeys(By.xpath("//input[@name='last_name']"), lastname);
        contact_us_po.setLastName_TextField(lastname);
    }
    @And("I enter an email address of {}")
    public void i_enter_an_email_address(String email) {
        if (email.equals("unique")){
            email = "AutoEmail" + generateRandomNumber(10)+"@mail.com";
        }
        //sendKeys(By.xpath("//input[@name='email']"), email);
        contact_us_po.setEmail_TextField(email);
    }
    @And("I enter a comment of {}")
    public void i_enter_a_comment(String comment) {
        if (comment.equals("unique")){
            comment = "Hello World " + generateRandomString(20);
        }
        //sendKeys(By.xpath("//textarea[@name='message']"), comment);
        contact_us_po.setComment_TextField(comment);

    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        contact_us_po.clickOn_SubmitButton();
    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        contact_us_po.validate_successful_Submission_Message();
    }
}
