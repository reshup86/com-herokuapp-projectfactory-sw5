package com.herokuapp.internet.testsuite;

import com.herokuapp.internet.pages.LoginPage;
import com.herokuapp.internet.pages.SecureAreaPage;
import com.herokuapp.internet.testbase.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    LoginPage loginPage;
    SecureAreaPage secureAreaPage;

    public LoginPageTest() {
        PageFactory.initElements(driver, this);
    }

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        secureAreaPage = new SecureAreaPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();

        String expectedMessage = "Secure Area";
        Assert.assertEquals(secureAreaPage.getErrorMessage(), expectedMessage, "Secure area text is not displayed");
    }

    @Test (groups = {"smoke", "regression"})
    public void verifyTheUsernameErrorMessage() {
        loginPage.enterUsername("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();

        String expectedUsernameMessage = "Your username is invalid!\n" + "×";
        Assert.assertEquals(loginPage.getInvalidUsernameMessage(), expectedUsernameMessage, "Invalid username text is not displayed");
    }

    @Test (groups = {"regression"})
    public void verifyThePasswordErrorMessage() {
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        loginPage.clickOnLoginButton();

        String expectedPasswordMessage = "Your password is invalid!\n" + "×";
        Assert.assertEquals(loginPage.getInvalidPasswordMessage(), expectedPasswordMessage, "Invalid password text is not displayed");
    }
}
