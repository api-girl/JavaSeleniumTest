package second_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Page;

public class ConfPage extends Page {

   public String getConfirmationMessage(){
        WebElement confirmationMessage = driver.findElement(By.id("content"));
        return confirmationMessage.getText();
    }


}
