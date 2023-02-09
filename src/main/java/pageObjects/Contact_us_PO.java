package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Global_vars;


public class Contact_us_PO extends Base_PO{

    private @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstName_TextField;

    private @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastName_TextField;

    private @FindBy(xpath = "//input[@name='email']")
    WebElement email_TextField;

    private @FindBy(xpath = "//textarea[@name='message']")
    WebElement comment_TextField;

    private @FindBy(xpath = "//input[@value='SUBMIT']")
    WebElement submit_Button;

    private @FindBy(xpath = "//div[@id='contact_reply']/h1")
    WebElement successfulSubmission_message;

    public Contact_us_PO() {
        super();
    }

    public void navigateTo_WebDriverUniversity_contact_Us_page(){
        navitageTo_URL(Global_vars.WEBDRIVER_UNIVERSITY_URL+"/Contact-Us/contactus.html");
    }

    public void setFirstName_TextField(String firstname) {
        sendKeys(firstName_TextField,firstname);
    }


    public void setLastName_TextField(String lastname) {
        sendKeys(lastName_TextField,lastname);
    }

    public void setEmail_TextField(String email){
        sendKeys(email_TextField, email);
    }

    public void setComment_TextField(String comment){
        sendKeys(comment_TextField, comment);
    }

    public void clickOn_SubmitButton(){
        waitForWebElementAndClick(submit_Button);
    }

    public void validate_successful_Submission_Message() {
        waitFor(successfulSubmission_message);
        Assert.assertEquals(successfulSubmission_message.getText(), "Thank You for your Message!");
    }

}
