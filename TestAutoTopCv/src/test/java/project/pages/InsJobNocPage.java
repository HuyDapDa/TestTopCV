package project.pages;

import org.openqa.selenium.WebDriver;
import utils.helpers.WebUI;

public class InsJobNocPage {
    private WebDriver driver;
    private WebUI webUI;

    public InsJobNocPage(WebDriver driver)
    {
        this.driver = driver;
        webUI = new WebUI(driver);
    }
}
