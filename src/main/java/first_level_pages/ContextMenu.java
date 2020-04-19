package first_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import page.Page;

public class ContextMenu extends Page {
    private By rightClickBox = By.id("hot-spot");

    public void rightClickOnBox(){
        WebElement box = driver.findElement(rightClickBox);
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public void closeAlert(){
        driver.switchTo().alert().dismiss();
    }
}
