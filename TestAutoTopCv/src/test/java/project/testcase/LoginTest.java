package project.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.base.BaseSetup;
import project.pages.HomePage;
import project.pages.LoginPage;
import utils.helpers.WebUI;

public class LoginTest {
    private WebDriver driver;
    private WebUI webUI;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeClass
    public void setUp()
    {
        driver = new BaseSetup().setUpDriver("edge");
        webUI = new WebUI(driver);
    }

    @Test
    public void login()
    {
        loginPage = new LoginPage(driver);

        driver.get(new BaseSetup().getUrl());

        homePage = loginPage.signIn("quanghuytran0204@gmail.com", "Thamnamngudot123@");

        webUI.waitForPageLoaded();
    }

//    @AfterClass
//    public void tearDown() throws InterruptedException {
//        webUI.waitForPageLoaded();
//        driver.close();
//    }
}
