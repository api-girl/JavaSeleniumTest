package first_level_pages;

import org.openqa.selenium.By;
import utilities.Page;

public class WysiwygEditorPage extends Page {
private By editorIframeId = By.id("mce_0_ifr"); //can be used for locating iframe or the iframe's index
private By textArea = By.id("tinymce");
private By indentButton = By.className("mce-i-indent");

    private void switchToiFrame(){
        driver.switchTo().frame(0); //since this is the only iframe on the page, index=0
    }

    private void switchToParentArea(){
        driver.switchTo().parentFrame();
    }

    public void clearTextArea(){
        switchToiFrame();
        driver.findElement(textArea).clear();
        switchToParentArea();
    }

    public void sendKeysToTextArea(String input){
        switchToiFrame();
        driver.findElement(textArea).sendKeys(input);
        switchToParentArea();
    }

    public void indentLine(){
        driver.findElement(indentButton).click();
    }

    public String getTextFromEditArea(){
        switchToiFrame();
        String text = driver.findElement(textArea).getText();
        switchToParentArea();
        return text;
    }
}

