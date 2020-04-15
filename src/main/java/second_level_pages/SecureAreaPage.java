package second_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SecureAreaPage {
    private WebDriver driver;
    private By promptMessage = By.id("flash");

    public SecureAreaPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPromptMessage(){
        WebElement prompt = driver.findElement(promptMessage);
        return prompt.getText();

    }
}
