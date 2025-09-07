package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestLoginPage extends DriverSetup {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public  void setup_class(){
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.login_signup_btn);
    }

    @Test
    public void testLoginWithValidCredentials(){
        loginPage.writeOnElement(loginPage.email_input_box, "feciwe6718@anlocc.com");
        loginPage.writeOnElement(loginPage.password_input_box, "1234567Aa");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertTrue(homePage.isVisible(homePage.logout_btn));
        Assert.assertFalse(loginPage.isVisible(loginPage.login_btn));
    }

    @Test
    public void testLoginWithInvalidPassword(){
        loginPage.writeOnElement(loginPage.email_input_box, "feciwe6718@anlocc.com");
        loginPage.writeOnElement(loginPage.password_input_box, "Pass&Pas");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), "Your email or password is incorrect!");
        Assert.assertTrue(loginPage.isVisible(loginPage.login_btn));
    }

    @Test
    public void testLoginWithInvalidEmailAndPassword(){
        loginPage.writeOnElement(loginPage.email_input_box, "feciwe6718@anlocc.co");
        loginPage.writeOnElement(loginPage.password_input_box, "Pass&Pas");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), "Your email or password is incorrect!");
        Assert.assertTrue(loginPage.isVisible(loginPage.login_btn));
    }

    @Test
    public void testLoginWithInvalidEmailAndValidPassword(){
        loginPage.writeOnElement(loginPage.email_input_box, "feciwe6718@anlo.com");
        loginPage.writeOnElement(loginPage.password_input_box, "1234567Aa");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), "Your email or password is incorrect!");
        Assert.assertTrue(loginPage.isVisible(loginPage.login_btn));
    }

    @Test
    public void testLoginWithoutEmailAndPassword(){
        loginPage.writeOnElement(loginPage.email_input_box, "");
        loginPage.writeOnElement(loginPage.password_input_box, "");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.email_input_box).getAttribute("validationMessage"), "Please fill out this field.");
        Assert.assertTrue(loginPage.isVisible(loginPage.login_btn));
    }

    @Test
    public void testLoginEmailAndWithoutPassword(){
        loginPage.writeOnElement(loginPage.email_input_box, "feciwe6718@anlocc.com");
        loginPage.writeOnElement(loginPage.password_input_box, "");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.password_input_box).getAttribute("validationMessage"), "Please fill out this field.");
        Assert.assertTrue(loginPage.isVisible(loginPage.login_btn));
    }
}
