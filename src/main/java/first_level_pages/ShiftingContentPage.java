package first_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import second_level_pages.MenuElementPage;

public class ShiftingContentPage {
    private WebDriver driver;
    private By linkMenuElement = By.linkText("Example 1: Menu Element");

    public ShiftingContentPage(WebDriver driver){
        this.driver = driver;
    }

    public MenuElementPage gotoMenuElementPage(){
        WebElement menuElement = driver.findElement(linkMenuElement);
        menuElement.click();
        return new MenuElementPage(driver);
    }
}
