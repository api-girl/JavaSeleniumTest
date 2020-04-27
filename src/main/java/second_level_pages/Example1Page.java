package second_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Page;

public class Example1Page extends Page {
    private String okButton = "#start button";
    private String loadedText = "#finish h4";
    private String loadingIndicator = "loading";

    public WebElement findOkButton(){
        waitForElementVisibility(By.cssSelector(okButton));
        return driver.findElement(By.cssSelector(okButton));
    }

    public void triggerLoading(){
        clickByCssSelector(okButton);
    }

    public String getLoadedText(){
        waitForElementVisibility(By.cssSelector(loadedText));
        return driver.findElement(By.cssSelector(loadedText)).getText();
    }

    public String getLoadedTextAfterLoadingEnds(){
        waitForElementInvisibility(By.id(loadingIndicator));
        return driver.findElement(By.cssSelector(loadedText)).getText();
    }

    public String getH4Title(){
        waitForElementsPresence(By.tagName("h4"));
        return driver.findElement(By.tagName("h4")).getText();
    }

}
