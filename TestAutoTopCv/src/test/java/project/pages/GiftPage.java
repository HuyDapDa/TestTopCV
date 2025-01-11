package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.helpers.WebUI;

import javax.swing.*;

public class GiftPage {
    private WebDriver driver;
    private WebUI webUI;
    private Actions action;

    private String url = "/qua-tang";
    private String pageText = "Kích hoạt mã quà tặng";
    private By headerPageText = By.xpath("//h1[contains(text(),'Kích hoạt mã quà tặng')]");
    private By selectDropdown = By.xpath("//span[@role='combobox']");
    private By searchSelectDropdown = By.xpath("//input[@role='textbox']");
    private By code = By.xpath("//input[@placeholder='Nhập mã code']");
    private By btnAplly = By.xpath("//a[@id='btn-apply-coupon']");
    private By msgError = By.xpath("div[id='toast-container'] div:nth-child(2)");
    private By codeInvalid = By.xpath("//div[@class='alert alert-danger']");

    public GiftPage(WebDriver driver)
    {
        this.driver = driver;
        webUI = new WebUI(driver);
        action = new Actions(driver);
    }

    public void useGift(String giftCode)
    {
        Assert.assertTrue(webUI.verifyURL(url), "Khong phai trang qua tang");
        Assert.assertTrue(webUI.verifyElementText(headerPageText,pageText), "khon phai trang qua tang");

        webUI.clickElement(selectDropdown);
        webUI.setText(searchSelectDropdown, "Tài khoản Pro Vip (1 tháng)");
        action.sendKeys(Keys.ENTER).build().perform();
        webUI.setText(code, giftCode);
        webUI.clickElement(btnAplly);

        boolean isCodeEmpty = giftCode.isEmpty();
        boolean isErrorDisplayed = webUI.verifyElementDisplayed(msgError);
        boolean isInValidCodeDisplayed = webUI.verifyElementDisplayed(codeInvalid);

        // Case 1: Khi giftCode rỗng thì PHẢI hiển thị error message
        Assert.assertEquals(isCodeEmpty,isErrorDisplayed,"Thong bao loi phai duoc hien thi");

        // Case 2: Khi giftCode có giá trị
        // Nếu code invalid thì PHẢI hiển thị invalid message
        // Nếu code valid thì KHÔNG được hiển thị bất kỳ message nào
        Assert.assertEquals(!isCodeEmpty,isInValidCodeDisplayed,"Ma code khong hop le");

        // Đảm bảo không hiển thị cả 2 message cùng lúc
        Assert.assertFalse(isErrorDisplayed && isInValidCodeDisplayed, "Khong duoc hien thi ca 2 cung luc");

    }
}
