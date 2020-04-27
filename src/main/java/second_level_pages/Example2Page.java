package second_level_pages;

import org.openqa.selenium.By;

public class Example2Page extends Example1Page {
    private String loadedText = "#finish h4";


    public String getTextAfterElementIsPresent(){
        waitForElementsPresence(By.cssSelector(loadedText));
        return driver.findElement(By.cssSelector(loadedText)).getText();
    }
}
