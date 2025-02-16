package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;

public class RegistrationPage extends BaseClass {

    @FindBy(id = "username")
    public WebElement usernameField;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(css = "button[aria-label='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//p[contains(@class, 'text-sm text-red-600') and contains(text(), 'The email field format is invalid.')]")
    public WebElement invalidEmailMessage;

    @FindBy(xpath = "//p[contains(@class, 'text-sm text-red-600') and contains(text(), 'The password field must be at least 6 characters.')]")
    public WebElement invalidPasswordMessage;

    @FindBy(xpath = "//p[contains(@class, 'text-sm text-red-600') and contains(text(), 'The email has already been taken.')]")
    public WebElement existingEmailErrorMessage;

    @FindBy(xpath = "//p[contains(@class, 'text-sm text-red-600') and contains(text(), 'The username has already been taken.')]")
    public WebElement existingUsernameErrorMessage;

    @FindBy(xpath = "//p[contains(@class, 'text-sm text-red-600') and contains(text(), 'The username field is required.')]")
    public WebElement emptyUsernameMessage;

    @FindBy(xpath = "//p[contains(@class, 'text-sm text-red-600') and contains(text(), 'The email field is required.')]")
    public WebElement emptyEmailMessage;

    @FindBy(xpath = "//p[contains(@class, 'text-sm text-red-600') and contains(text(), 'The password field is required.')]")
    public WebElement emptyPasswordMessage;

    public RegistrationPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        sendKeys(usernameField, username);
    }

    public void enterEmail(String email) {
        sendKeys(emailField, email);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public ProductPage clickRegisterButton() {
        click(registerButton);
        return new ProductPage(); 
    }
}

