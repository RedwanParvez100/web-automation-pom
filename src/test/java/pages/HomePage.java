package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public String url = "https://www.foodpanda.com.bd/";
    public String username = "reyisew161@inupup.com";
    public String password = "m416+Kar98k";
    public String title = "Delivery service for your favourite restaurants - foodora";
    public By nav_login_btn = By.xpath("//span[contains(text(),'Log in')]");
    public By login_btn = By.xpath("//button[contains(text(),'Log in')]");
    public By email_input_field = By.xpath("//input[@id='email']");
    public By continue_btn = By.xpath("//span[contains(text(),'Continue')]");
    public By password_input_field = By.xpath("//input[@id='password']");
    public By login_with_password_btn = By.xpath("//span[contains(text(),'Log in with password')]");
    public By user = By.xpath("//div[contains(text(),'Redwan')]");


    public void loadHomePage(){
        loadAPage(url);
    }
}
