package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.DriverSetup;

public class TestHomePage extends DriverSetup {

    HomePage homePage = new HomePage();

    @BeforeMethod
    public void loadHomePageForTest(){
        homePage.loadHomePage();
    }

    @Test
    public void TestHomePageTitle(){
        Assert.assertEquals(getDriver().getTitle(), homePage.title);
    }

    @Test
    public void TestLoginSignupButton(){
        homePage.clickOnElement(homePage.login_signup_btn);
        Assert.assertFalse(getDriver().getCurrentUrl().equals(homePage.url));
    }
}
