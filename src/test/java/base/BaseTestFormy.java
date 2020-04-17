package base;

import first_level_pages.FormyPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class BaseTestFormy {
    private WebDriver driver;
    protected FormyPage formyPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        driver.manage().window().maximize();

        formyPage = new FormyPage(driver);
        //boolean isRadioButtonSelected = false;
//        List<WebElement> allRadioButtonElements = driver.findElements(By.cssSelector("input[type='radio']"));
//        for (WebElement radioButton : allRadioButtonElements) {
//            radioButton.isSelected();
//            radioButton.click();
//            System.out.println(radioButton.isSelected());
//            radioButton.click();
//            System.out.println(radioButton.isSelected());

   //     }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
