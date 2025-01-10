package project.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseSetup {
    private WebDriver driver ;
    private String url = "https://topcv.vn/login";

    public WebDriver getDriver()
    {
        return driver;
    }

    public String getUrl()
    {
        return url;
    }

    public WebDriver setUpDriver(String browserType) {
        switch (browserType.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initEdgeDriver();
        }
        return driver;
    }

    //Khởi tạo cấu hình của các Browser để đưa vào switch case
    private static WebDriver initChromeDriver()
    {
        System.out.println("Lauching Chrome browser...");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver initEdgeDriver()
    {
        System.out.println("Lauching Edge browser");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    //Chạy hàm initiaizeTestBaseSetUp trước hết khi class này được gọi
//    @Parameters({"browserType", "appURL"})
//    @BeforeClass
//    public void initializeTestBaseSetUp(String browserType, String appURL)
//    {
//        try {
//            //Khởi tạo driver và browser
//            setDriver(browserType, appURL);
//        }catch (Exception e)
//        {
//            System.out.println("Error..." + e.getStackTrace());
//        }
//    }
//
//    @AfterClass
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.quit();
//    }
}
