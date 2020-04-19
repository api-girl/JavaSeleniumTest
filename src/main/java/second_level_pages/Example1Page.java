package second_level_pages;

import org.openqa.selenium.By;
import page.Page;

public class Example1Page extends Page {
    private String okButton = "#start button";
    private String loadedText = "#finish h4";
    private String loadingIndicator = "loading";

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

}
