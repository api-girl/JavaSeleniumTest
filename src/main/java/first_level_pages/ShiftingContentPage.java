package first_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Page;
import second_level_pages.MenuElementPage;

public class ShiftingContentPage extends Page {
    private By linkMenuElement = By.linkText("Example 1: Menu Element");

    public MenuElementPage gotoMenuElementPage(){
        WebElement menuElement = driver.findElement(linkMenuElement);
        menuElement.click();
        return new MenuElementPage();
    }
}
