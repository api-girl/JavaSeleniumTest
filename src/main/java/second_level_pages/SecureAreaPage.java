package second_level_pages;

import org.openqa.selenium.By;
import page.Page;


public class SecureAreaPage extends Page {
    private By promptMessage = By.id("flash");

    public String getPromptMessage(){
        return driver.findElement(promptMessage).getText();
    }
}
