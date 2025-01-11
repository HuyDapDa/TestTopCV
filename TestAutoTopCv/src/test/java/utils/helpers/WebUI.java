package utils.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WebUI {
    private WebDriver driver;
    private WebDriverWait wait;
    JavascriptExecutor js;

    public WebUI(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
    }

    public void setText(By element, String value)
    {
        //Sendkeys một giá trị là Value cho element truyền vào
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);
    }

    public void clickElement(By element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    public boolean verifyURL(String url)
    {
        System.out.println(driver.getCurrentUrl());
        System.out.println(url);
        return driver.getCurrentUrl().contains(url);
    }

    public boolean verifyElementText(By element, String textvalue)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText().equals(textvalue);
    }

    public boolean verifyElementDisplayed(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForPageLoaded()
    {
        ExpectedCondition<Boolean> jQuery = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                try {
                    return ((long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e)
                {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver input){
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                            .equals("complete");
            }
        };
        try {
            WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(jQuery);
            wait.until(jsLoad);
        }
        catch (Exception e)
        {
            Assert.fail("Qua thoi gian Load trang");
        }
    }
}
