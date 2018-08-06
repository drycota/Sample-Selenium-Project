package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginToJiraPage {

    public LoginToJiraPage(WebDriver driver){
        this.driver = driver;
    }

    private WebDriver driver;
    String userNameXpath = "//*[@id=\"login-form-username\"]";
    String userPassXpath = "//*[@id=\"login-form-password\"]";
    String loginButtonXpath = "//*[@id=\"login-form-submit\"]";

    public void enterUserName (String userName) {driver.findElement(By.xpath(userNameXpath)).sendKeys(userName);}
    public void enterPassword (String password){driver.findElement(By.xpath(userPassXpath)).sendKeys(password);}
    public void clickSendButton(){driver.findElement(By.xpath(loginButtonXpath)).sendKeys(Keys.ENTER);}


}
