package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class AppTestLoginPage {

    @Test
    public void simpleTest() {
//        System.setProperty("webdriver.chrome.driver", "D:\\Hillel\\driver\\chromedriver.exe");

        String aTitle, eTitle = "Log in - Hillel IT School JIRA";

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                    DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        LoginToJiraPage loginPage = new LoginToJiraPage(driver);

        // запустить chrome и перейти по адресу
        driver.get("http://jira.hillel.it:8080/login.jsp");
        // разворачивает окно браузера
        driver.manage().window().maximize();

        // получить значение у тайтла страницы
        aTitle = driver.getTitle();

        // выполняем проверку
        assertEquals(aTitle, eTitle);

        loginPage.enterUserName("webinar5");
        loginPage.enterPassword("webinar5");
        loginPage.clickSendButton();

        assertEquals(driver.getTitle(), "System Dashboard - Hillel IT School JIRA");


        // закрываем окно браузера
        driver.close();

    }

}
