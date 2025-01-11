package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.helpers.WebUI;

public class UpdateAccPage {
    private WebDriver driver;
    private WebUI webUI;

    private String url = "/tai-khoan/nang-cap";
    private String pageText = "NÂNG CẤP TÀI KHOẢN";
    private By headerPageText = By.xpath("//p[contains(text(),'Nâng cấp tài khoản')]");

    public UpdateAccPage(WebDriver driver)
    {
        this.driver = driver;
        webUI = new WebUI(driver);
    }

    public void openUpdateAccPage()
    {
        Assert.assertTrue(webUI.verifyURL(url), "Khong phai trang nang cap tai khoan");
        Assert.assertTrue(webUI.verifyElementText(headerPageText, pageText), "Khong phai trang nang cap tai khoan");
    }
}
