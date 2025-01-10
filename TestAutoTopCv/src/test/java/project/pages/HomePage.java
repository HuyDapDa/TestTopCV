package project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.helpers.WebUI;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebUI webUI;

    private String url ="/viec-lam";

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        webUI = new WebUI(driver);
    }

}
