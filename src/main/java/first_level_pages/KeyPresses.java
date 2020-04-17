package first_level_pages;

import org.openqa.selenium.By;
import page.Page;

public class KeyPresses extends Page {
    private By textField = By.id("target");
    private By messageLoc = By.id("result");

   public void enterText(String text){
        driver.findElement(textField).sendKeys(text);
    }

    public String getResult(){
        return driver.findElement(messageLoc).getText();

    }
}
