package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.DriverSetup;

public class TestHomePage extends DriverSetup {

    HomePage homePage = new HomePage();

    @Test
    public void testHomepageTitle(){

        homePage.loadHomePage();
        Assert.assertEquals(homePage.getPageTitle(), homePage.title);
    }
}
