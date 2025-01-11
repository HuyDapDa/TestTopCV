package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.helpers.WebUI;

public class HomePage {
    private WebDriver driver;
    private WebUI webUI;

    private String url ="/viec-lam";
    private By headerMenu = By.xpath("//li[@class='navbar-right__item group py16']//div[@class='title']");
    private By updateInfor = By.xpath("///body/nav[2]/div[1]/ul[2]/li[3]/div[2]/ul[1]/li[1]/a[1]");
    private By updateAcc = By.xpath("//body/nav[2]/div[1]/ul[2]/li[3]/div[2]/ul[1]/li[2]/a[1]");
    private By gift = By.xpath("//body/nav[2]/div[1]/ul[2]/li[3]/div[2]/ul[1]/li[3]/a[1]");
    private By recruitview = By.xpath("//body/nav[2]/div[1]/ul[2]/li[3]/div[2]/ul[1]/li[4]/a[1]");
    private By insJobSug = By.xpath("//body/nav[2]/div[1]/ul[2]/li[3]/div[2]/ul[1]/li[5]/a[1]");
    private By insJobNoc = By.xpath("//body/nav[2]/div[1]/ul[2]/li[3]/div[2]/ul[1]/li[6]/a[1]");
    private By insEmail = By.xpath("//body/nav[2]/div[1]/ul[2]/li[3]/div[2]/ul[1]/li[7]/a[1]");
    private By insSecu = By.xpath("//body/nav[2]/div[1]/ul[2]/li[3]/div[2]/ul[1]/li[8]/a[1]");
    private By changePass = By.xpath("//body/nav[2]/div[1]/ul[2]/li[3]/div[2]/ul[1]/li[9]/a[1]");
    private By logOut = By.xpath("//body/nav[2]/div[1]/ul[2]/li[3]/div[2]/ul[1]/li[10]/a[1]");

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        webUI = new WebUI(driver);
    }

    public UpdateInforPage updateInfor()
    {
        Assert.assertTrue(webUI.verifyURL(url), "Khong phai trang Homepage");
        webUI.clickElement(headerMenu);
        webUI.clickElement(updateInfor);
        return new UpdateInforPage(driver);
    }

    public UpdateAccPage updateAcc()
    {
        Assert.assertTrue(webUI.verifyURL(url), "Khong phai trang Homepage");
        webUI.clickElement(headerMenu);
        webUI.clickElement(updateAcc);
        return new UpdateAccPage(driver);

    }

    public GiftPage gift()
    {
        Assert.assertTrue(webUI.verifyURL(url), "Khong phai trang Homepage");
        webUI.clickElement(headerMenu);
        webUI.clickElement(gift);
        return new GiftPage(driver);
    }

    public RecruitViewPage recruitview()
    {
        Assert.assertTrue(webUI.verifyURL(url), "Khong phai trang Homepage");
        webUI.clickElement(headerMenu);
        webUI.clickElement(recruitview);
        return new RecruitViewPage(driver);
    }

    public InsJobSugPage insJobSug()
    {
        Assert.assertTrue(webUI.verifyURL(url), "Khong phai trang Homepage");
        webUI.clickElement(headerMenu);
        webUI.clickElement(insJobSug);
        return new InsJobSugPage(driver);
    }

    public InsJobNocPage insJobNoc()
    {
        Assert.assertTrue(webUI.verifyURL(url), "Khong phai trang Homepage");
        webUI.clickElement(headerMenu);
        webUI.clickElement(insJobNoc);
        return new InsJobNocPage(driver);
    }

    public InsEmailPage insEmail()
    {
        Assert.assertTrue(webUI.verifyURL(url), "Khong phai trang Homepage");
        webUI.clickElement(headerMenu);
        webUI.clickElement(insEmail);
        return new InsEmailPage(driver);
    }

    public InsSecuPage insSecu()
    {
        Assert.assertTrue(webUI.verifyURL(url), "Khong phai trang Homepage");
        webUI.clickElement(headerMenu);
        webUI.clickElement(insSecu);
        return new InsSecuPage(driver);
    }

    public ChangePassPage changePass()
    {
        Assert.assertTrue(webUI.verifyURL(url), "Khong phai trang Homepage");
        webUI.clickElement(headerMenu);
        webUI.clickElement(changePass);
        return new ChangePassPage(driver);
    }

    public LoginPage logOut()
    {
        Assert.assertTrue(webUI.verifyURL(url), "Khong phai trang Homepage");
        webUI.clickElement(headerMenu);
        webUI.clickElement(logOut);
        return new LoginPage(driver);
    }
}
