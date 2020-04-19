package first_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.Page;


public class NestedFramesPage extends Page {
    private String bottomFrameSelector = "frame-bottom";
    private String parentTopFrame = "frame-top";
    private By frameTextLocator = By.tagName("body");

    private void switchToFrame(String frameName){
        driver.switchTo().frame(frameName);
    }

    private void switchBackToParent(){
        driver.switchTo().parentFrame();
    }

    public String goToNestedFrame(String frameName) {
        switchToFrame(parentTopFrame);
        switchToFrame(frameName);
        String frameText = getFrameText();
        switchBackToParent();
        switchBackToParent();
        return frameText;
}

    public String goToSingleFrame(){
        switchToFrame(bottomFrameSelector);
        String bottomFrameText = getFrameText();
        switchBackToParent();
        return bottomFrameText;
    }

    public String getFrameText(){
        return driver.findElement(frameTextLocator).getText();
    }

//    public String getArrayMember(String[] array){
//        for(String arrayMember : array){
//            return arrayMember;
//        }
//        return "Empty array";
//    }



}
