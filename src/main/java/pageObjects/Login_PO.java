package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_vars;

public class Login_PO extends Base_PO{

    private @FindBy(id = "text")
    WebElement username_textField;

    private @FindBy(id = "password")
    WebElement password_TextField;

    private @FindBy(id = "login-button")
    WebElement login_Button;



    public Login_PO() {
        super();
    }

    public void navigateTo_WebDriverUniversity_login_page(){
        navitageTo_URL(Global_vars.WEBDRIVER_UNIVERSITY_URL+"/Login-Portal/index.html");
    }

    public void setUsername(String username){
        sendKeys(username_textField, username);
    }

    public void setPassword(String password){
        sendKeys(password_TextField, password);
    }

    public void clickOn_Login_button(){
        waitForWebElementAndClick(login_Button);
    }

}
