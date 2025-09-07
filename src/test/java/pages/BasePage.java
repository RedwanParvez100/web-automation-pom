package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.DriverSetup.getDriver;

public class BasePage {

    public WebElement getElement(By locator){
        return getDriver().findElement(locator);
    }

    public void clickOnElement(By locator){
        getElement(locator).click();
    }

    public void writeOnElement(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    public boolean isVisible(By locator){
        return getElement(locator).isDisplayed();
    }

    public boolean isEnable(By locator){
        return getElement(locator).isEnabled();
    }

    public void loadAPage(String url){
        getDriver().get(url);
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }

    public String getPageUrl(){
        return getDriver().getCurrentUrl();
    }
}
