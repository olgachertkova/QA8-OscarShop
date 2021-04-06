package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase {
    @FindBy (id = "register_form")
    WebElement registerForm;
    
    @FindBy (id = "id_registration-email")
    WebElement registrationEmail;
    
    @FindBy (id = "id_registration-password1")
    WebElement registrationPassword;

    @FindBy (id = "id_registration-password2")
    WebElement registrationConfirmPassword;

    @FindBy (name = "registration_submit")
    WebElement registrationSubmitButton;

    @FindBy (className = "alert-danger")
    WebElement errorMessage;
    
    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilLoginPageIsLoaded() {
        waitUntilElementVisible(registerForm, 30);
    }

    public void inputEmail(String emailValid) {
        inputText(registrationEmail, emailValid);
    }

    public void inputPassword(String passwordValid) {
        inputText(registrationPassword, passwordValid);
    }

    public void confirmPassword(String passwordValid) {
        inputText(registrationConfirmPassword, passwordValid);
    }

    public void clickOnRegisterButton() {
        registrationSubmitButton.click();
    }

    public boolean errorMessageIsDisplayed() {
        return errorMessage.isDisplayed();
    }
}
