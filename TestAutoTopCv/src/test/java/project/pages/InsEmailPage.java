package project.pages;

import org.openqa.selenium.WebDriver;
import utils.helpers.WebUI;

public class InsEmailPage {
    private WebDriver driver;
    private WebUI webUI;

    public InsEmailPage(WebDriver driver)
    {
        this.driver = driver;
        webUI = new WebUI(driver);
    }
}
