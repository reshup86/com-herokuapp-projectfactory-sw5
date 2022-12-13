package com.herokuapp.internet.pages;

import com.herokuapp.internet.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage extends Utility {
    //By usernameField = By.name("username");
    @CacheLookup
    @FindBy(name = "username")
    WebElement usernameField;
    //By passwordField = By.name("password");
    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordField;

    //By loginButton = By.xpath("//button/i [text() = ' Login']");
    @CacheLookup
    @FindBy(xpath = "//button/i [text() = ' Login']")
    WebElement loginButton;

    //By invalidUsernameMessage = By.xpath("//div[1]//div[@class = 'flash error' and contains(text(),'Your username is invalid!')]");
    @CacheLookup
    @FindBy(xpath = "//div[1]//div[@class = 'flash error' and contains(text(),'Your username is invalid!')]")
    WebElement invalidUsernameMessage;

    //By invalidPasswordMessage = By.xpath("//div[1]//div[@class = 'flash error' and contains(text(),'Your password is invalid!')]");
    @CacheLookup
    @FindBy(xpath = "//div[1]//div[@class = 'flash error' and contains(text(),'Your password is invalid!')]")
    WebElement invalidPasswordMessage;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    public void enterUsername(String username) {
        Reporter.log("Enter username "+username+ " to username field " +usernameField);
        sendTextToElement(usernameField, username);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter password to password field " +passwordField);
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on login button");
        clickOnElement(loginButton);
    }

    public String getInvalidUsernameMessage() {
        Reporter.log("Invalid user name error message is displayed");
        return getTextFromElement(invalidUsernameMessage);
    }

    public String getInvalidPasswordMessage() {
        Reporter.log("Invalid password error message is displayed");
        return getTextFromElement(invalidPasswordMessage);
    }
}