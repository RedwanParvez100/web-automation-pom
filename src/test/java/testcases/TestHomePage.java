package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.DriverSetup;

public class TestHomePage extends DriverSetup {

    HomePage homePage = new HomePage();

    @BeforeClass
    public void setupClass(){
        homePage.loadHomePage();
    }

    @Test
    public void testHomepageTitle(){
        Assert.assertEquals(homePage.getPageTitle(), homePage.title);
    }

    @Test
    public void testHomepageUrl(){
        Assert.assertTrue(homePage.getPageUrl().startsWith(homePage.url));
    }

    @Test
    public void testLoginButton(){
        Assert.assertTrue(homePage.isVisible(homePage.nav_login_btn));
        Assert.assertTrue(homePage.isEnable(homePage.nav_login_btn));
    }

    @Test
    public void testLoginWithValidCredentials() {
        homePage.clickOnElement(homePage.nav_login_btn);
        homePage.clickOnElement(homePage.login_btn);
        homePage.writeOnElement(homePage.email_input_field, homePage.username);
        homePage.clickOnElement(homePage.continue_btn);
        homePage.writeOnElement(homePage.password_input_field, homePage.password);
        homePage.clickOnElement(homePage.login_with_password_btn);

        Assert.assertTrue(homePage.isVisible(homePage.user));
        Assert.assertFalse(homePage.isVisible(homePage.nav_login_btn));
    }
}