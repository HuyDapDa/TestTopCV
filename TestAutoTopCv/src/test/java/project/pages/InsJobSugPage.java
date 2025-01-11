package project.pages;

import org.openqa.selenium.WebDriver;
import utils.helpers.WebUI;

public class InsJobSugPage {
    private WebDriver driver;
    private WebUI webUI;

    public InsJobSugPage(WebDriver driver)
    {
        this.driver = driver;
        webUI = new WebUI(driver);
    }
}
