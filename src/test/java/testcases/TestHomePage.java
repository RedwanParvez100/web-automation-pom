package testcases;

import io.qameta.allure.Description;
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

    @Test(description = "Test Home Page Title", priority = 1, groups = "Sanity, Regression")
    @Description ("Allure - Test Home Page Title")
    public void TestHomePageTitle(){
        homePage.addScreenshot("Home page");
        Assert.assertEquals(getDriver().getTitle(), homePage.title);
    }

    @Test(priority = 0, groups = "Sanity")
    public void TestLoginSignupButton(){
        homePage.addScreenshot("Home page");
        homePage.clickOnElement(homePage.login_signup_btn);
        Assert.assertFalse(getDriver().getCurrentUrl().equals(homePage.url));
    }
}
