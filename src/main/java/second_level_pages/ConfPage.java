package second_level_pages;

import first_level_pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfPage extends Page {
    private WebDriver driver;

    public ConfPage(WebDriver driver){
        this.driver = driver;
    }

    public String getConfirmationMessage(){
        WebElement confirmationMessage = driver.findElement(By.id("content"));
        return confirmationMessage.getText();
    }


}
