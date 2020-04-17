package base;

import page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import first_level_pages.HomePage;


public class BaseTest {
    private static WebDriver driver;
    protected static Page page;
    protected HomePage homePage;
    private static final String url = "https://the-internet.herokuapp.com/";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        goHome();

        page = new Page();
        page.setPageDriver(driver);

        homePage = new HomePage();
    }

    @BeforeMethod
    public void goHome(){
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
