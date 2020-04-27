package base;

import com.google.common.io.Files;
import first_level_pages.FormyPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Page;

import java.io.File;
import java.io.IOException;

public class BaseTestFormy {
    private static WebDriver driver;
    protected static Page page;
    private String url = "https://formy-project.herokuapp.com/form";
    protected Logger logger;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        page = new Page();
        page.setPageDriver(driver);
    }

    @BeforeMethod
    public void goHome(){
        driver.get(url);
        driver.manage().window().maximize();
    }

    protected void stepInfo(String stepDescription) {
        logger = LoggerFactory.getLogger(Thread.currentThread().getName() + "." + getClass().getSimpleName());
        logger.info(String.format("%s", stepDescription));
    }

    @AfterMethod
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

    public ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        return options.setHeadless(true);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
