package first_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.Page;

public class InfiniteScroll extends Page {
private By paragraph = By.className("jscroll-added");

public WebElement scrollUntilParagraph(int index){
    String script = "window.scrollTo(0, document.body.scrollHeight)";
    JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
    while(getNumberOfParagraphsDisplayed() < index){
        jsExecutor.executeScript(script);
    }
    return driver.findElement(paragraph);
}

private int getNumberOfParagraphsDisplayed(){
    return driver.findElements(paragraph).size();
}
}
