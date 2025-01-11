package project.pages;

import org.openqa.selenium.WebDriver;
import utils.helpers.WebUI;

public class ChangePassPage {
    private WebDriver driver;
    private WebUI webUI;

    public ChangePassPage(WebDriver driver)
    {
        this.driver = driver;
        webUI = new WebUI(driver);
    }
}
