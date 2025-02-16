package tests;

import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.ProductPage;
import utils.BaseClass;
import org.json.JSONObject;

import java.io.InputStream;

public class UserTests extends BaseClass {
    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    ProductPage productPage;
    JSONObject testData;

    @BeforeClass
    public void setUpTestData() {
        InputStream dataIs = getClass().getClassLoader().getResourceAsStream("data/testData.json");
        testData = new JSONObject(new JSONTokener(dataIs));
    }

    @BeforeMethod
    public void setUpTest() {
        homePage = new HomePage();
    }

    @Test
    public void successfulLogin() {
    	loginPage = homePage.clickLoginButton();
        loginPage.enterEmail(testData.getJSONObject("data").getString("validEmail"));
        loginPage.enterPassword(testData.getJSONObject("data").getString("validPassword"));
        loginPage.clickLogInButton();
        Assert.assertTrue(productPage.isSearchFieldVisible(), "Search field should be visible after successful login.");
    }

    @Test
    public void invalidLoginCredentials() {
    	loginPage = homePage.clickLoginButton();
        loginPage.enterEmail(testData.getJSONObject("data").getString("invalidEmail"));
        loginPage.enterPassword(testData.getJSONObject("data").getString("invalidPassword"));
        loginPage.clickLogInButton();
        String expectedMessage = testData.getJSONObject("data").getString("unexistingCredentials");
        String actualMessage = loginPage.unexistingCredentials.getText(); 
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void emptyEmailField() {
    	loginPage = homePage.clickLoginButton();
        loginPage.enterEmail("");
        loginPage.enterPassword(testData.getJSONObject("data").getString("validPassword"));
        loginPage.clickLogInButton();
        String expectedMessage = testData.getJSONObject("data").getString("emptyEmailMessage");
        String actualMessage = loginPage.emptyEmailMessage.getText(); 
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void emptyPasswordField() {
    	loginPage = homePage.clickLoginButton();
        loginPage.enterEmail(testData.getJSONObject("data").getString("validEmail"));
        loginPage.enterPassword("");
        loginPage.clickLogInButton();
        String expectedMessage = testData.getJSONObject("data").getString("emptyPasswordMessage");
        String actualMessage = loginPage.emptyPasswordMessage.getText(); 
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void successfulRegistration() {
    	registrationPage = homePage.clickSignUpButton();
        registrationPage.enterUsername(testData.getJSONObject("data").getString("validUsername"));
        registrationPage.enterEmail(testData.getJSONObject("data").getString("validEmail"));
        registrationPage.enterPassword(testData.getJSONObject("data").getString("validPassword"));
        registrationPage.clickRegisterButton();
        Assert.assertTrue(productPage.isSearchFieldVisible(), "Search field should be visible after successful registration.");
    }

    @Test
    public void usernameAlreadyInUse() {
    	registrationPage = homePage.clickSignUpButton();
        registrationPage.enterUsername(testData.getJSONObject("data").getString("alreadyInUseUsername"));
        registrationPage.enterEmail(testData.getJSONObject("data").getString("validEmail"));
        registrationPage.enterPassword(testData.getJSONObject("data").getString("validPassword"));
        registrationPage.clickRegisterButton();
        String expectedMessage = testData.getJSONObject("data").getString("existingUsernameErrorMessage");
        String actualMessage = registrationPage.existingUsernameErrorMessage.getText(); 
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void emptyUsernameField() {
    	registrationPage = homePage.clickSignUpButton();
        registrationPage.enterUsername("");
        registrationPage.enterEmail(testData.getJSONObject("data").getString("validEmail"));
        registrationPage.enterPassword(testData.getJSONObject("data").getString("validPassword"));
        registrationPage.clickRegisterButton();
        String expectedMessage = testData.getJSONObject("data").getString("emptyUsernameMessage");
        String actualMessage = registrationPage.emptyUsernameMessage.getText(); 
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void emailAlreadyInUse() {
    	registrationPage = homePage.clickSignUpButton();
        registrationPage.enterUsername(testData.getJSONObject("data").getString("validUsername"));
        registrationPage.enterEmail(testData.getJSONObject("data").getString("validEmail"));
        registrationPage.enterPassword(testData.getJSONObject("data").getString("validPassword"));
        registrationPage.clickRegisterButton();
        String expectedMessage = testData.getJSONObject("data").getString("existingEmailErrorMessage");
        String actualMessage = registrationPage.existingEmailErrorMessage.getText(); 
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void invalidEmailFormat() {
    	registrationPage = homePage.clickSignUpButton();
        registrationPage.enterUsername(testData.getJSONObject("data").getString("validUsername"));
        registrationPage.enterEmail(testData.getJSONObject("data").getString("invalidEmail"));
        registrationPage.enterPassword(testData.getJSONObject("data").getString("validPassword"));
        registrationPage.clickRegisterButton();
        String expectedMessage = testData.getJSONObject("data").getString("invalidEmailMessage");
        String actualMessage = registrationPage.invalidEmailMessage.getText(); 
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void weakPassword() {
    	registrationPage = homePage.clickSignUpButton();
        registrationPage.enterUsername(testData.getJSONObject("data").getString("validUsername"));
        registrationPage.enterEmail(testData.getJSONObject("data").getString("validEmail"));
        registrationPage.enterPassword(testData.getJSONObject("data").getString("invalidPassword"));
        registrationPage.clickRegisterButton();
        String expectedMessage = testData.getJSONObject("data").getString("invalidPasswordMessage");
        String actualMessage = registrationPage.invalidPasswordMessage.getText(); 
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    
    @Test
    public void loginAndAddProductToCart() {
    	loginPage = homePage.clickLoginButton();
        loginPage.enterEmail(testData.getString("validEmail"));
        loginPage.enterPassword(testData.getString("validPassword"));
        productPage = loginPage.clickLogInButton();
        Assert.assertTrue(productPage.isSearchFieldVisible(), "User is not logged in");
        productPage.searchForProduct("Samsung");
        productPage.clickAddToCart();
        Assert.assertTrue(productPage.getProductTitle().contains("Samsung"), "Product was not added to the cart");
    }
    
    @Test
    public void registerAndAddProductToCart() {
    	registrationPage = homePage.clickSignUpButton();
        registrationPage.enterUsername(testData.getString("validUsername"));
        registrationPage.enterEmail(testData.getString("validEmail"));
        registrationPage.enterPassword(testData.getString("validPassword"));
        productPage = registrationPage.clickRegisterButton();
        Assert.assertTrue(productPage.isSearchFieldVisible(), "User is not registered");
        productPage.searchForProduct("Samsung");
        productPage.clickAddToCart();
        Assert.assertTrue(productPage.getProductTitle().contains("Samsung"), "Product was not added to the cart");
    }

    
}
