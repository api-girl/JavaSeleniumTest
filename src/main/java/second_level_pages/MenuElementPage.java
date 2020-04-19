package second_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.Page;

import java.util.List;

public class MenuElementPage extends Page {
    private By menuItemsUnorderedList = By.xpath("//div[@class='example']/ul/li");


    public int countMenuItems(){
        List<WebElement> menuItems = driver.findElements(menuItemsUnorderedList);
        return menuItems.size();
    }
}
