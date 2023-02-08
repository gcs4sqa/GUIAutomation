package features.stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import static driver.DriverFactory.getDriver;


public class Contact_Us_Steps {

    private WebDriver driver = getDriver();

    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }
    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");

    }
    @When("I enter a first name of {}")
    public void i_enter_a_first_name(String firstname) {
        if (firstname.equals("unique")){
            firstname = "AutoFN" + generateRandomNumber(5);
            System.out.println(firstname);
        }
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstname);
    }
    @And("I enter a last name of {}")
    public void i_enter_a_last_name(String lastname) {
        if (lastname.equals("unique")){
            lastname = "AutoLN" + generateRandomNumber(5);
        }
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastname);
    }
    @And("I enter an email address of {}")
    public void i_enter_an_email_address(String email) {
        if (email.equals("unique")){
            email = "AutoEmail" + generateRandomNumber(10)+"@mail.com";
        }
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
    }
    @And("I enter a comment of {}")
    public void i_enter_a_comment(String comment) {
        if (comment.equals("unique")){
            comment = "Hello World " + generateRandomString(20);
        }
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUs_Submission_Message.getText(), "Thank You for your Message!");
    }
}
