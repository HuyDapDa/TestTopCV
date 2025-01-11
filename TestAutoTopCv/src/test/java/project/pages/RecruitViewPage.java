package project.pages;

import org.openqa.selenium.WebDriver;
import utils.helpers.WebUI;

public class RecruitViewPage {
    private WebDriver driver;
    private WebUI webUI;

    public RecruitViewPage(WebDriver driver)
    {
        this.driver = driver;
        webUI = new WebUI(driver);
    }
}
