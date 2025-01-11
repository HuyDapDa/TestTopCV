package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.helpers.WebUI;

public class UpdateInforPage {
    private WebDriver driver;
    private WebUI webUI;

    private String url = "/cai-dat-thong-tin-ca-nhan";
    private String pageText = "Cài đặt thông tin cá nhân";
    private By headerTextPage = By.xpath("//h4[contains(text(),'Cài đặt thông tin cá nhân')]");
    private By name = By.xpath("//input[@placeholder='Nhập họ và tên']");
    private By phone = By.xpath("//div[@class='box-item']//input[@placeholder='Nhập số điện thoại']");
    private By btnSave = By.xpath("//button[@id='btn-topcv-update-profile-online']");
    private By msgError = By.xpath("//div[contains(text(),'Họ và tên không được để trống')]");
    private By msgError1 = By.xpath("//div[contains(text(),'Họ & Tên phải có độ dài từ 2 đến 50 ký tự')]");

    public UpdateInforPage(WebDriver driver)
    {
        this.driver = driver;
        webUI = new WebUI(driver);
    }

    public void openUpdateInfor(String name1, String phone1)
    {
        Assert.assertTrue(webUI.verifyURL(url), "Không phải trang Cài đặt thông tin cá nhân");
        Assert.assertTrue(webUI.verifyElementText(headerTextPage, pageText), "Không phải trang Cài đặt thông tin cá nhân");

        webUI.setText(name, name1);
        webUI.setText(phone, phone1);
        WebElement email = driver.findElement(By.xpath("//body/div[@id='main']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input"));
        Assert.assertFalse(email.isEnabled(), "Ô email hoạt động");
        webUI.clickElement(btnSave);

        boolean isNameEmpty = name1.isEmpty();
        boolean isNameLenghtInvalid = name1.length() == 1  || name1.length() > 50;
        boolean isErrorDisplayed = webUI.verifyElementDisplayed(msgError);
        boolean isLengthErrorDisplayed = webUI.verifyElementDisplayed(msgError1);

        // Case 1: Kiểm tra field rỗng
        Assert.assertEquals(isNameEmpty, isErrorDisplayed,
                isNameEmpty ? "Validate error không hiển thị khi không nhập họ và tên"
                        : "Validate error hiển thị khi đã nhập họ và tên");

        // Case 2: Kiểm tra độ dài không hợp lệ
        Assert.assertEquals(isNameLenghtInvalid, isLengthErrorDisplayed,
                isLengthErrorDisplayed ? "Không hiển thị thông báo lỗi khi tên có độ dài 1 ký tự hoặc trên 50 ký tự"
                : "Hiển thị không báo lỗi khi có tên độ dài hợp lệ");

        //Case 3: Đảm bảo không hiển thị cả 2 lỗi cùng lúc
        Assert.assertFalse(isErrorDisplayed && isLengthErrorDisplayed,
                "Không được hiển thị cả 2 thông báo lỗi cùng lúc");
    }
}
