package base;

import first_level_pages.FormyPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import page.Page;

public class BaseTestFormy {
    private static WebDriver driver;
    protected static Page page;
    protected FormyPage formyPage;
    private String url = "https://formy-project.herokuapp.com/form";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        page = new Page();
        page.setPageDriver(driver);

        formyPage = new FormyPage();

    }

    @BeforeMethod
    public void goHome(){
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void deleteCookies(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
