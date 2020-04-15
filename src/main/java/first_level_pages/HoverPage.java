package first_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class HoverPage {
    WebDriver driver;
    private By figureLoc = By.className("figure");
    private By captionLoc = By.className("figcaption");

    public HoverPage(WebDriver driver){
        this.driver = driver;
    }

    public Caption hoversOverFigure(int index){
        WebElement figure = driver.findElements(figureLoc).get(index-1);
        Actions action = new Actions(driver);
        action.moveToElement(figure).perform();
        return new Caption(figure.findElement(captionLoc));
    }

    /*
    model class, serves to be used as a return data type for hoversOverFigure() method, as it is not
    a good practice to return a WebElement
    to test method
     */
    public class Caption {
        WebDriver driver;
        private WebElement caption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");

        public Caption(WebElement caption){
            this.caption = caption;
        }

        public boolean isCaptionDisplayed(){
            return caption.findElement(header).isDisplayed();
        }

        public String getHeaderText(){
            return caption.findElement(header).getText();
        }

        public String getLink(){
            return caption.findElement(link).getAttribute("href");
        }

    }
}
