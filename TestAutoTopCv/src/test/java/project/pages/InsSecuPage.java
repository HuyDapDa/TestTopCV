package project.pages;

import org.openqa.selenium.WebDriver;
import utils.helpers.WebUI;

public class InsSecuPage {
    private WebDriver driver;
    private WebUI webUI;

    public InsSecuPage(WebDriver driver)
    {
        this.driver = driver;
        webUI = new WebUI(driver);
    }
}
