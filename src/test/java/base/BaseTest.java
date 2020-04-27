package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import org.testng.ITestResult;
import first_level_pages.HomePage;
import utilities.EventListener;
import utilities.WindowManager;
import utilities.Page;
import java.io.File;
import java.io.IOException;

public class BaseTest {
    private static EventFiringWebDriver driver;
    protected static Page page;
    protected HomePage homePage;
    private static final String url = "https://the-internet.herokuapp.com/";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventListener());

        page = new Page();
        page.setPageDriver(driver);
    }


    @BeforeMethod
    public void goHome() {
        driver.get(url);
        homePage = new HomePage();

        driver.manage().window().maximize();
    }

    @AfterMethod
    //deleteCookies and recordFailure methods prohibit each other, find out why
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true);
        return options;
    }

    public WindowManager getWindowManager() {
        return new WindowManager();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
