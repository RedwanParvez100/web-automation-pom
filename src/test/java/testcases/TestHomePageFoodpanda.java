package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePageFoodpanda;
import utilities.DriverSetup;

public class TestHomePageFoodpanda extends DriverSetup {

    HomePageFoodpanda homePageFoodpanda = new HomePageFoodpanda();

    @BeforeClass
    public void setupClass(){
        homePageFoodpanda.loadHomePage();
    }

    @Test
    public void testHomepageTitle(){
        Assert.assertEquals(homePageFoodpanda.getPageTitle(), homePageFoodpanda.title);
    }

    @Test
    public void testHomepageUrl(){
        Assert.assertTrue(homePageFoodpanda.getPageUrl().startsWith(homePageFoodpanda.url));
    }

    @Test
    public void testLoginButton(){
        Assert.assertTrue(homePageFoodpanda.isVisible(homePageFoodpanda.nav_login_btn));
        Assert.assertTrue(homePageFoodpanda.isEnable(homePageFoodpanda.nav_login_btn));
    }

    @Test
    public void testLoginWithValidCredentials() {
        homePageFoodpanda.clickOnElement(homePageFoodpanda.nav_login_btn);
        homePageFoodpanda.clickOnElement(homePageFoodpanda.login_btn);
        homePageFoodpanda.writeOnElement(homePageFoodpanda.email_input_field, homePageFoodpanda.username);
        homePageFoodpanda.clickOnElement(homePageFoodpanda.continue_btn);
        homePageFoodpanda.writeOnElement(homePageFoodpanda.password_input_field, homePageFoodpanda.password);
        homePageFoodpanda.clickOnElement(homePageFoodpanda.login_with_password_btn);

        Assert.assertTrue(homePageFoodpanda.isVisible(homePageFoodpanda.user));
        Assert.assertFalse(homePageFoodpanda.isVisible(homePageFoodpanda.nav_login_btn));
    }
}