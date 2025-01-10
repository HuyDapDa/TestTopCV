package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.helpers.WebUI;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebUI webUI;
    WebDriverWait wait;

    private By emailInput = By.xpath("//input[@placeholder='Email']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By btnSubmit = By.xpath("//button[contains(text(),'Đăng nhập')]");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        webUI = new WebUI(driver);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public HomePage signIn(String email, String password)
    {
        webUI.waitForPageLoaded();
        Assert.assertTrue(webUI.verifyElementText(btnSubmit, "Đăng nhập"), "Không phải trang đăng nhập");
        webUI.setText(emailInput, email);
        webUI.setText(passwordInput, password);
        webUI.clickELement(btnSubmit);
        return new HomePage(driver);
    }
}
